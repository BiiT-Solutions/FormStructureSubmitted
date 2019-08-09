package com.biit.form.submitted.implementation.json;

import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import com.biit.form.submitted.implementation.SubmittedQuestion;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class SubmittedQuestionDeserializer extends SubmittedObjectDeserializer<SubmittedQuestion> {

	public SubmittedQuestionDeserializer() {
		super(SubmittedQuestion.class);
	}

	public void deserialize(JsonElement json, JsonDeserializationContext context, SubmittedQuestion element) {
		super.deserialize(json, context, element);

		JsonObject jobject = (JsonObject) json;
		// Answers deserialization

		Type listType = new TypeToken<HashSet<String>>() {
		}.getType();
		JsonElement childrenJson = jobject.get("answers");
		if (childrenJson != null) {
			Set<String> answers = context.deserialize(childrenJson, listType);
			element.setAnswers(answers);
		}
	}
}
