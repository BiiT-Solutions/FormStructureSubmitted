package com.biit.form.submitted.serialization.gson;

import com.biit.form.submitted.implementation.SubmittedQuestion;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class SubmittedQuestionDeserializer extends SubmittedObjectDeserializer<SubmittedQuestion> {

    public SubmittedQuestionDeserializer() {
        super(SubmittedQuestion.class);
    }

    public void deserialize(JsonElement json, JsonDeserializationContext context, SubmittedQuestion element) {
        super.deserialize(json, context, element);

        final JsonObject jobject = (JsonObject) json;
        // Answers deserialization

        final Type listType = new TypeToken<HashSet<String>>() {
        }.getType();
        final JsonElement childrenJson = jobject.get("answers");
        if (childrenJson != null) {
            final Set<String> answers = context.deserialize(childrenJson, listType);
            element.setAnswers(answers);
        }
    }
}
