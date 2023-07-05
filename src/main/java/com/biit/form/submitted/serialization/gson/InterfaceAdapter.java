package com.biit.form.submitted.serialization.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;

public class InterfaceAdapter<T> implements JsonSerializer<T>, JsonDeserializer<T> {

    private static final String JSON_CLASSNAME = "class";
    private static final String JSON_DATA = "data";

    @Override
    public T deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext)
            throws JsonParseException {

        final JsonObject jsonObject = jsonElement.getAsJsonObject();
        final JsonPrimitive prim = (JsonPrimitive) jsonObject.get(JSON_CLASSNAME);
        if (prim == null) {
            return null;
        }
        final String className = prim.getAsString();
        return jsonDeserializationContext.deserialize(jsonObject, getObjectClass(className));
    }

    @Override
    public JsonElement serialize(T jsonElement, Type type, JsonSerializationContext jsonSerializationContext) {
        final JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(JSON_CLASSNAME, jsonElement.getClass().getName());
        jsonObject.add(JSON_DATA, jsonSerializationContext.serialize(jsonElement));
        return jsonObject;
    }

    public Class<?> getObjectClass(String className) {
        try {
            return Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new JsonParseException(e.getMessage());
        }
    }
}
