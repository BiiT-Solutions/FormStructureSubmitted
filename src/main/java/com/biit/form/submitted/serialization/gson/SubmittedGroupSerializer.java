package com.biit.form.submitted.serialization.gson;

import com.biit.form.submitted.implementation.SubmittedGroup;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;

public class SubmittedGroupSerializer extends SubmittedObjectSerializer<SubmittedGroup> {

    @Override
    public JsonElement serialize(SubmittedGroup src, Type typeOfSrc, JsonSerializationContext context) {
        return super.serialize(src, typeOfSrc, context);
    }

}
