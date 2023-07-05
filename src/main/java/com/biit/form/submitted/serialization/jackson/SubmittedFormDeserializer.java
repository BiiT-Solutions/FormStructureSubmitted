package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedForm;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class SubmittedFormDeserializer extends SubmittedObjectDeserializer<SubmittedForm> {

    @Override
    public void deserialize(SubmittedForm element, JsonNode jsonObject, DeserializationContext context) throws IOException {
        super.deserialize(element, jsonObject, context);
    }
}
