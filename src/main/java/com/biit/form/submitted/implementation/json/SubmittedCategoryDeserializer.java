package com.biit.form.submitted.implementation.json;

import com.biit.form.submitted.implementation.SubmittedCategory;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;

public class SubmittedCategoryDeserializer extends SubmittedObjectDeserializer<SubmittedCategory> {

    public SubmittedCategoryDeserializer() {
        super(SubmittedCategory.class);
    }

    public void deserialize(JsonElement json, JsonDeserializationContext context, SubmittedCategory element) {
        super.deserialize(json, context, element);
    }
}
