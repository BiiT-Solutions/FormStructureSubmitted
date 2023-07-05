package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedCategory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class SubmittedCategorySerializer extends SubmittedObjectSerializer<SubmittedCategory> {

    @Override
    public void serialize(SubmittedCategory src, JsonGenerator jgen) throws IOException {
        super.serialize(src, jgen);
    }
}
