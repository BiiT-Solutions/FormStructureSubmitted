package com.biit.form.submitted.implementation;

import com.biit.form.entity.IQuestionWithAnswers;
import com.biit.form.submitted.ISubmittedForm;
import com.biit.form.submitted.ISubmittedObject;
import com.biit.form.submitted.serialization.gson.InterfaceAdapter;
import com.biit.form.submitted.serialization.gson.SubmittedCategoryDeserializer;
import com.biit.form.submitted.serialization.gson.SubmittedCategorySerializer;
import com.biit.form.submitted.serialization.gson.SubmittedFormDeserializer;
import com.biit.form.submitted.serialization.gson.SubmittedFormSerializer;
import com.biit.form.submitted.serialization.gson.SubmittedGroupDeserializer;
import com.biit.form.submitted.serialization.gson.SubmittedGroupSerializer;
import com.biit.form.submitted.serialization.gson.SubmittedQuestionDeserializer;
import com.biit.form.submitted.serialization.gson.SubmittedQuestionSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedFormDeserializer.class)
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
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(SubmittedForm.class, new SubmittedFormDeserializer());
        gsonBuilder.registerTypeAdapter(SubmittedCategory.class, new SubmittedCategoryDeserializer());
        gsonBuilder.registerTypeAdapter(SubmittedGroup.class, new SubmittedGroupDeserializer());
        gsonBuilder.registerTypeAdapter(SubmittedQuestion.class, new SubmittedQuestionDeserializer());
        gsonBuilder.registerTypeAdapter(ISubmittedObject.class, new InterfaceAdapter<ISubmittedObject>());
        final Gson gson = gsonBuilder.create();

        return gson.fromJson(jsonString, SubmittedForm.class);
    }

    @Override
    public String toJson() {
        final GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        gsonBuilder.registerTypeAdapter(SubmittedForm.class, new SubmittedFormSerializer());
        gsonBuilder.registerTypeAdapter(SubmittedCategory.class, new SubmittedCategorySerializer());
        gsonBuilder.registerTypeAdapter(SubmittedGroup.class, new SubmittedGroupSerializer());
        gsonBuilder.registerTypeAdapter(SubmittedQuestion.class, new SubmittedQuestionSerializer());
        gsonBuilder.registerTypeAdapter(ISubmittedObject.class, new InterfaceAdapter<ISubmittedObject>());
        final Gson gson = gsonBuilder.create();
        return gson.toJson(this);
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
