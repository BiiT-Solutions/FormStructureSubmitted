package com.biit.form.submitted.implementation.json;

import com.biit.form.submitted.implementation.SubmittedGroup;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;

public class SubmittedGroupDeserializer extends SubmittedObjectDeserializer<SubmittedGroup> {

    public SubmittedGroupDeserializer() {
        super(SubmittedGroup.class);
    }

    public void deserialize(JsonElement json, JsonDeserializationContext context, SubmittedGroup element) {
        super.deserialize(json, context, element);
    }
}
