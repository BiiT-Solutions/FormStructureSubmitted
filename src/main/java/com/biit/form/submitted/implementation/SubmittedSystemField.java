package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedSystemField;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedSystemFieldDeserializer.class)
@JsonSerialize(using = com.biit.form.submitted.serialization.jackson.SubmittedSystemFieldSerializer.class)
public class SubmittedSystemField extends SubmittedObject implements ISubmittedSystemField {

    private String value;

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
