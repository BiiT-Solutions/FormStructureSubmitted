package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedSystemField;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;
import java.io.Serial;

public class SubmittedSystemFieldDeserializer extends SubmittedObjectDeserializer<SubmittedSystemField> {

    @Serial
    private static final long serialVersionUID = 1148447386767847268L;

    @Override
    public void deserialize(SubmittedSystemField element, JsonNode jsonObject, DeserializationContext context) throws IOException {
        super.deserialize(element, jsonObject, context);
        element.setValue(parseString("value", jsonObject));
    }
}
