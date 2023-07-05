package com.biit.form.submitted.serialization.jackson;

import com.biit.form.jackson.serialization.ObjectMapperFactory;
import com.biit.form.submitted.implementation.SubmittedQuestion;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.util.Set;

public class SubmittedQuestionDeserializer extends SubmittedObjectDeserializer<SubmittedQuestion> {

    @Override
    public void deserialize(SubmittedQuestion element, JsonNode jsonObject, DeserializationContext context) throws IOException {
        super.deserialize(element, jsonObject, context);

        // Answers deserialization

        final JsonNode answersJson = jsonObject.get("answers");
        if (answersJson != null) {
            final Set<String> children = ObjectMapperFactory.getObjectMapper().readValue(answersJson.toPrettyString(),
                    new TypeReference<>() {
                    });
            element.setAnswers(children);
        }
    }
}
