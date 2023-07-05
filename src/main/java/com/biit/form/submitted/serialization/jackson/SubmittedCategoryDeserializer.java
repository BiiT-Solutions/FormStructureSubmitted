package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedCategory;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class SubmittedCategoryDeserializer extends SubmittedObjectDeserializer<SubmittedCategory> {

    @Override
    public void deserialize(SubmittedCategory element, JsonNode jsonObject, DeserializationContext context) throws IOException {
        super.deserialize(element, jsonObject, context);
    }
}
