package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedForm;
import com.biit.form.submitted.SubmittedObject;

public class SubmittedForm extends SubmittedObject implements ISubmittedForm {

	private String applicationName;
	private String name;
	
	public SubmittedForm() {
		
	}

	public SubmittedForm(String applicationName, String formName) {
		super();
		this.name = formName;
		this.applicationName = applicationName;
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

}
