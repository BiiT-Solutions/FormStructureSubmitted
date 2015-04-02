package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedForm;
import com.biit.form.submitted.SubmittedObject;

public class SubmittedForm extends SubmittedObject implements ISubmittedForm {

	private String applicationName;
	private String name;
	private String formVersion;

	public SubmittedForm(String applicationName, String formName, String formVersion) {
		super();
		this.applicationName = applicationName;
		this.name = formName;
		this.formVersion = formVersion;
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
	public String getVersion() {
		return formVersion;
	}
}
