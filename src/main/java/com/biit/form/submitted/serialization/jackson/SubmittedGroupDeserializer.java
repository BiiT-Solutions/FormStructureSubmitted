package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedGroup;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class SubmittedGroupDeserializer extends SubmittedObjectDeserializer<SubmittedGroup> {

    @Override
    public void deserialize(SubmittedGroup element, JsonNode jsonObject, DeserializationContext context) throws IOException {
        super.deserialize(element, jsonObject, context);
        element.setRepeatable(parseBoolean("repeatable", jsonObject));
        element.setNumberOfIterations(parseInteger("numberOfIterations", jsonObject));
    }
}
