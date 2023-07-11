package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedGroup;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class SubmittedGroupSerializer extends SubmittedObjectSerializer<SubmittedGroup> {

    @Override
    public void serialize(SubmittedGroup src, JsonGenerator jgen) throws IOException {
        super.serialize(src, jgen);
        jgen.writeStringField("repeatable", String.valueOf(src.isRepeatable()));
        jgen.writeStringField("numberOfIterations", String.valueOf(src.getNumberOfIterations()));
    }
}
