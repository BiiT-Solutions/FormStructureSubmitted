package com.biit.form.submitted.implementation.json;

import com.biit.form.submitted.ISubmittedObject;
import com.biit.form.submitted.implementation.SubmittedObject;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class SubmittedObjectDeserializer<T extends SubmittedObject> implements JsonDeserializer<T> {

	private Class<T> specificClass;

	public SubmittedObjectDeserializer(Class<T> specificClass) {
		this.specificClass = specificClass;
	}

	public void deserialize(JsonElement json, JsonDeserializationContext context, T element) {
		JsonObject jobject = (JsonObject) json;

		element.setTag(parseString("tag", jobject, context));
		element.setText(parseString("text", jobject, context));

		// Children deserialization
		Type listType = new TypeToken<ArrayList<ISubmittedObject>>() {
		}.getType();
		JsonElement childrenJson = jobject.get("children");
		if (childrenJson != null) {
			List<ISubmittedObject> children = context.deserialize(childrenJson, listType);
			element.setChildren(children);
		}
	}

	protected String parseString(String name, JsonObject jobject, JsonDeserializationContext context) {
		if (jobject.get(name) != null) {
			return context.deserialize(jobject.get(name), String.class);
		}
		return null;
	}

	@Override
	public T deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
		T instance;
		try {
			instance = specificClass.getConstructor().newInstance();
			deserialize(json, context, instance);
			return instance;
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException e) {
			throw new JsonParseException(e);
		}
	}

}
