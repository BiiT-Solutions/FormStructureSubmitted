package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedQuestion;
import com.biit.form.submitted.SubmittedObject;

public class SubmittedQuestion extends SubmittedObject implements ISubmittedQuestion {
	private String answer;

	public SubmittedQuestion(String tag) {
		super();
		setTag(tag);
		setText(tag);
	}

	@Override
	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Override
	public String getAnswer() {
		return answer;
	}

}
