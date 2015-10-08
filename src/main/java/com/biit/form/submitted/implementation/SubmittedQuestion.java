package com.biit.form.submitted.implementation;

import java.util.HashSet;
import java.util.Set;

import com.biit.form.submitted.ISubmittedQuestion;
import com.biit.form.submitted.SubmittedObject;

public class SubmittedQuestion extends SubmittedObject implements ISubmittedQuestion {
	private Set<String> answers;

	public SubmittedQuestion(String tag) {
		super();
		setTag(tag);
		setText(tag);
	}

	@Override
	public void setAnswer(String answer) {
		this.answers = new HashSet<>();
		this.answers.add(answer);
	}

	@Override
	public void setAnswers(Set<String> answers) {
		this.answers = answers;
	}

	@Override
	public Set<String> getAnswers() {
		return answers;
	}

}
