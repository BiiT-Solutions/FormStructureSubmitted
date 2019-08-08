package com.biit.form.submitted.implementation.json;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.biit.form.submitted.ISubmittedObject;
import com.biit.form.submitted.SubmittedObject;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class SubmittedObjectDeserializer<T extends SubmittedObject> implements JsonDeserializer<T> {

	private Class<T> specificClass;

	public SubmittedObjectDeserializer(Class<T> specificClass) {
		this.specificClass = specificClass;
	}

	public void deserialize(JsonElement json, JsonDeserializationContext context, T element) {
		JsonObject jobject = (JsonObject) json;

		element.setTag(parseString("tag", jobject, context));
		element.setText(parseString("text", jobject, context));

		// Children deserialization
		Type listType = new TypeToken<ArrayList<SubmittedObject>>() {
		}.getType();
		JsonElement childrenJson = jobject.get("children");
		if (childrenJson != null) {
			List<ISubmittedObject> children = context.deserialize(childrenJson, listType);
			element.setChildren(children);
		}
	}

	protected String parseString(String name, JsonObject jobject, JsonDeserializationContext context) {
		if (jobject.get(name) != null) {
			return (String) context.deserialize(jobject.get(name), String.class);
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
