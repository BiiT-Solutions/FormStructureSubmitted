package com.biit.form.submitted;

import com.biit.form.entity.IFormWithAnswers;

public interface ISubmittedForm extends ISubmittedObject, IFormWithAnswers {

	public String getApplicationName();

	public String getName();

	public String getId();

}
