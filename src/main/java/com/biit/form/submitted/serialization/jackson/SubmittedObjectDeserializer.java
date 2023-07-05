package com.biit.form.submitted.serialization.jackson;

import com.biit.form.jackson.serialization.ObjectMapperFactory;
import com.biit.form.log.FormStructureLogger;
import com.biit.form.submitted.implementation.SubmittedObject;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class SubmittedObjectDeserializer<T extends SubmittedObject> extends StdDeserializer<T> {
    private static final String TIMESTAMP_FORMAT = "dd-MM-yyyy HH:mm:ss";
    private static final DateTimeFormatter TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(TIMESTAMP_FORMAT);
    private static final String OLD_TIMESTAMP_FORMAT = "MMM d, yyyy h:mm:ss a";
    private static final DateTimeFormatter OLD_TIMESTAMP_FORMATTER = DateTimeFormatter.ofPattern(OLD_TIMESTAMP_FORMAT);

    private final Class<T> specificClass;

    public SubmittedObjectDeserializer() {
        this(null);
    }

    public SubmittedObjectDeserializer(Class<T> aClass) {
        super(aClass);
        this.specificClass = aClass;
    }

    public void deserialize(T element, JsonNode jsonObject, DeserializationContext context) throws IOException {
        element.setTag(parseString("tag", jsonObject));
        element.setText(parseString("text", jsonObject));


        // Children deserialization
        final JsonNode childrenJson = jsonObject.get("children");
        if (childrenJson != null) {
            //Handle children one by one.
            if (childrenJson.isArray()) {
                for (JsonNode childNode : childrenJson) {
                    try {
                        final Class<T> classType = (Class<T>) Class.forName(childNode.get("class").asText());
                        element.addChild(ObjectMapperFactory.getObjectMapper().readValue(childNode.toPrettyString(), classType));
                    } catch (ClassNotFoundException e) {
                        FormStructureLogger.errorMessage(this.getClass().getName(), e);
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }


    protected String parseString(String name, JsonNode jsonObject) {
        if (jsonObject != null && jsonObject.get(name) != null) {
            return jsonObject.get(name).textValue();
        }
        return null;
    }

    protected Timestamp parseTimestamp(String name, JsonNode jsonObject) {
        if (jsonObject != null && jsonObject.get(name) != null) {
            final String value = jsonObject.get(name).toString();
            try {
                return Timestamp.valueOf(value);
            } catch (Exception e) {
                try {
                    return Timestamp.valueOf(LocalDateTime.from(OLD_TIMESTAMP_FORMATTER.parse(value)));
                } catch (Exception e2) {
                    try {
                        return Timestamp.valueOf(LocalDateTime.from(TIMESTAMP_FORMATTER.parse(value)));
                    } catch (Exception e3) {
                        return new Timestamp(new Date().getTime());
                    }
                }
            }
        }
        return null;
    }

    protected Long parseLong(String name, JsonNode jsonObject) {
        if (jsonObject != null && jsonObject.get(name) != null) {
            return jsonObject.get(name).longValue();
        }
        return null;
    }

    protected Integer parseInteger(String name, JsonNode jsonObject) {
        if (jsonObject != null && jsonObject.get(name) != null) {
            return jsonObject.get(name).intValue();
        }
        return null;
    }

    protected boolean parseBoolean(String name, JsonNode jsonObject) {
        if (jsonObject != null && jsonObject.get(name) != null) {
            return jsonObject.get(name).booleanValue();
        }
        return false;
    }

    @Override
    public T deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        final JsonNode jsonObject = jsonParser.getCodec().readTree(jsonParser);

        final Class<T> classType;
        try {
            classType = (Class<T>) Class.forName(jsonObject.get("class").asText());
            final T element = classType.getDeclaredConstructor().newInstance();
            deserialize(element, jsonObject, deserializationContext);
            return element;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | InvocationTargetException
                 | NoSuchMethodException e) {
            FormStructureLogger.errorMessage(this.getClass().getName(), e);
            throw new RuntimeException(e);
        }
    }
}
