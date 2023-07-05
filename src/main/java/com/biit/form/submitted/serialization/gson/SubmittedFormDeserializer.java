package com.biit.form.submitted.serialization.gson;

import com.biit.form.submitted.implementation.SubmittedForm;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;

public class SubmittedFormDeserializer extends SubmittedObjectDeserializer<SubmittedForm> {

    public SubmittedFormDeserializer() {
        super(SubmittedForm.class);
    }

    public void deserialize(JsonElement json, JsonDeserializationContext context, SubmittedForm element) {
        super.deserialize(json, context, element);
    }
}
