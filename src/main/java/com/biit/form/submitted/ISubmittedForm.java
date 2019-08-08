package com.biit.form.submitted;

import com.biit.form.entity.IFormWithAnswers;
import com.biit.form.result.FormResult;

public interface ISubmittedForm extends ISubmittedObject, IFormWithAnswers {

	public String getApplicationName();

	public String getName();

	public String getId();

	String toJson();

	FormResult fromJson(String jsonString);

}
