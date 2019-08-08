package com.biit.form.submitted.implementation.json;

import java.lang.reflect.Type;

import com.biit.form.submitted.SubmittedObject;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

public class SubmittedObjectSerializer<T extends SubmittedObject> implements JsonSerializer<T> {

	@Override
	public JsonElement serialize(T src, Type typeOfSrc, JsonSerializationContext context) {
		final JsonObject jsonObject = new JsonObject();

		jsonObject.add("class", context.serialize(src.getClass().getName()));
		jsonObject.add("tag", context.serialize(src.getTag()));
		jsonObject.add("text", context.serialize(src.getText()));

		jsonObject.add("children", context.serialize(src.getChildren()));

		return jsonObject;
	}

}
