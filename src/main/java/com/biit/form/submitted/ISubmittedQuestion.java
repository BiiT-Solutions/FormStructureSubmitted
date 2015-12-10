package com.biit.form.submitted;

import java.util.Set;

public interface ISubmittedQuestion extends ISubmittedObject {

	public void addAnswer(String value);

	public Set<String> getAnswers();

	void setAnswers(Set<String> answers);

}
