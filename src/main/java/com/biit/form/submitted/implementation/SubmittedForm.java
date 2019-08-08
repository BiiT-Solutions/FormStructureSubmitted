package com.biit.form.submitted.implementation;

import java.util.List;

import com.biit.form.entity.IQuestionWithAnswers;
import com.biit.form.result.FormResult;
import com.biit.form.submitted.ISubmittedForm;
import com.biit.form.submitted.SubmittedObject;
import com.biit.form.submitted.implementation.json.SubmittedObjectDeserializer;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SubmittedForm extends SubmittedObject implements ISubmittedForm {

	private String applicationName;
	private String name;

	public SubmittedForm() {
		super();
	}

	public SubmittedForm(String applicationName, String formName) {
		super();
		this.applicationName = applicationName;
		this.name = formName;
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
		return getChildren(IQuestionWithAnswers.class);
	}

	@Override
	public FormResult fromJson(String jsonString) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.registerTypeAdapter(SubmittedForm.class,
				new SubmittedObjectDeserializer<SubmittedForm>(SubmittedForm.class));
		gsonBuilder.registerTypeAdapter(SubmittedCategory.class,
				new SubmittedObjectDeserializer<SubmittedCategory>(SubmittedCategory.class));
		gsonBuilder.registerTypeAdapter(SubmittedGroup.class,
				new SubmittedObjectDeserializer<SubmittedGroup>(SubmittedGroup.class));
		gsonBuilder.registerTypeAdapter(SubmittedQuestion.class,
				new SubmittedObjectDeserializer<SubmittedQuestion>(SubmittedQuestion.class));
		Gson gson = gsonBuilder.create();

		return gson.fromJson(jsonString, FormResult.class);
	}

	@Override
	public String toJson() {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.setPrettyPrinting();
		gsonBuilder.registerTypeAdapter(SubmittedForm.class,
				new SubmittedObjectDeserializer<SubmittedForm>(SubmittedForm.class));
		gsonBuilder.registerTypeAdapter(SubmittedCategory.class,
				new SubmittedObjectDeserializer<SubmittedCategory>(SubmittedCategory.class));
		gsonBuilder.registerTypeAdapter(SubmittedGroup.class,
				new SubmittedObjectDeserializer<SubmittedGroup>(SubmittedGroup.class));
		gsonBuilder.registerTypeAdapter(SubmittedQuestion.class,
				new SubmittedObjectDeserializer<SubmittedQuestion>(SubmittedQuestion.class));
		Gson gson = gsonBuilder.create();
		return gson.toJson(this);
	}
}
