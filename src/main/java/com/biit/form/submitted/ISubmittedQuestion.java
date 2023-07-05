package com.biit.form.submitted;

import com.biit.form.entity.IQuestionWithAnswers;

import java.util.Set;

public interface ISubmittedQuestion extends ISubmittedObject, IQuestionWithAnswers {

    void addAnswer(String value);

    @Override
    Set<String> getAnswers();

    void setAnswers(Set<String> answers);

}
