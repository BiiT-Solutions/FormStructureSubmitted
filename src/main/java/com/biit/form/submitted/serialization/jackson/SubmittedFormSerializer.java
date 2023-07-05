package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedForm;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class SubmittedFormSerializer extends SubmittedObjectSerializer<SubmittedForm> {

    @Override
    public void serialize(SubmittedForm src, JsonGenerator jgen) throws IOException {
        super.serialize(src, jgen);
    }
}
