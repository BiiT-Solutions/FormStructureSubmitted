package com.biit.form.submitted.implementation;

import java.util.List;

import com.biit.form.entity.IQuestionWithAnswers;
import com.biit.form.submitted.ISubmittedForm;
import com.biit.form.submitted.SubmittedObject;

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
}
