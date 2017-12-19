package com.biit.form.submitted;

import java.util.Set;

import com.biit.form.entity.IQuestionWithAnswers;

public interface ISubmittedQuestion extends ISubmittedObject, IQuestionWithAnswers {

	public void addAnswer(String value);

	public Set<String> getAnswers();

	void setAnswers(Set<String> answers);

}
