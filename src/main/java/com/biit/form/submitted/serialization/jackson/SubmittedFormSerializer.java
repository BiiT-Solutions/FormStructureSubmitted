package com.biit.form.submitted.serialization.jackson;

import com.biit.form.submitted.implementation.SubmittedForm;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class SubmittedFormSerializer extends SubmittedObjectSerializer<SubmittedForm> {

    @Override
    public void serialize(SubmittedForm src, JsonGenerator jgen) throws IOException {
        super.serialize(src, jgen);
        if (src.getApplicationName() != null) {
            jgen.writeStringField("applicationName", src.getApplicationName());
        }
        if (src.getOrganization() != null) {
            jgen.writeStringField("organization", src.getOrganization());
        }
        if (src.getVersion() != null) {
            jgen.writeStringField("version", String.valueOf(src.getVersion()));
        }
        if (src.getSubmittedBy() != null) {
            jgen.writeStringField("submittedBy", String.valueOf(src.getSubmittedBy()));
        }
    }
}
