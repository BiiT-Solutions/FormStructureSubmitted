package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedSystemField;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.io.Serial;

public class SubmittedSystemFieldSerializer extends SubmittedObjectSerializer<SubmittedSystemField> {

    @Serial
    private static final long serialVersionUID = 561476524047996292L;

    @Override
    public void serialize(SubmittedSystemField src, JsonGenerator jgen) throws IOException {
        super.serialize(src, jgen);
        jgen.writeStringField("value", String.valueOf(src.getValue()));
    }
}
