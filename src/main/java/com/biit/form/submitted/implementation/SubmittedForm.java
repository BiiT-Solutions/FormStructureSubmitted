package com.biit.form.submitted.implementation;

import com.biit.form.entity.IQuestionWithAnswers;
import com.biit.form.jackson.serialization.ObjectMapperFactory;
import com.biit.form.submitted.ISubmittedForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedFormDeserializer.class)
@JsonSerialize(using = com.biit.form.submitted.serialization.jackson.SubmittedFormSerializer.class)
public class SubmittedForm extends SubmittedObject implements ISubmittedForm {

    private String applicationName;
    private String name;
    private Integer version;

    public SubmittedForm() {
        super();
    }

    public SubmittedForm(String applicationName, String formName) {
        this();
        this.applicationName = applicationName;
        this.name = formName;
    }

    public SubmittedForm(String applicationName, String formName, Integer version) {
        this(applicationName, formName);
        this.version = version;
    }

    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public String getTag() {
        return getName();
    }

    @Override
    public void setTag(String tag) {
        super.setTag(tag);
        name = tag;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        if ((this.getApplicationName() != null) && (this.getName() != null)) {
            return this.getApplicationName() + "/" + this.getName();
        }
        return null;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public List<IQuestionWithAnswers> getQuestionsWithAnswers() {
        return getChildrenRecursive(IQuestionWithAnswers.class);
    }

    @Override
    public SubmittedForm fromJson(String jsonString) {
        return getFromJson(jsonString);
    }

    public static SubmittedForm getFromJson(String jsonString) {
        try {
            return ObjectMapperFactory.getObjectMapper().readValue(jsonString, SubmittedForm.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toJson() {
        try {
            return ObjectMapperFactory.getObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
