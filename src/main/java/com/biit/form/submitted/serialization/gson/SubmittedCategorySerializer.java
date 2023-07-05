package com.biit.form.submitted.serialization.gson;

import com.biit.form.submitted.implementation.SubmittedCategory;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializationContext;

import java.lang.reflect.Type;

public class SubmittedCategorySerializer extends SubmittedObjectSerializer<SubmittedCategory> {

    @Override
    public JsonElement serialize(SubmittedCategory src, Type typeOfSrc, JsonSerializationContext context) {
        return super.serialize(src, typeOfSrc, context);
    }

}
