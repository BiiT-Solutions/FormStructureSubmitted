package com.biit.form.submitted.implementation.json;

import java.lang.reflect.Type;

import com.biit.form.submitted.implementation.SubmittedQuestion;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;

public class SubmittedQuestionSerializer extends SubmittedObjectSerializer<SubmittedQuestion> {

	@Override
	public JsonElement serialize(SubmittedQuestion src, Type typeOfSrc, JsonSerializationContext context) {
		final JsonObject jsonObject = (JsonObject) super.serialize(src, typeOfSrc, context);
		jsonObject.add("answers", context.serialize(src.getAnswers()));
		return jsonObject;
	}

}
