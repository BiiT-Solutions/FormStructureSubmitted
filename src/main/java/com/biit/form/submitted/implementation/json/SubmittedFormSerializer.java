package com.biit.form.submitted.implementation.json;

import com.biit.form.submitted.implementation.SubmittedForm;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;

public class SubmittedFormSerializer extends SubmittedObjectSerializer<SubmittedForm> {

    @Override
    public JsonElement serialize(SubmittedForm src, Type typeOfSrc, JsonSerializationContext context) {
        return super.serialize(src, typeOfSrc, context);
    }

}
