package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedQuestion;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.HashSet;
import java.util.Set;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedQuestionDeserializer.class)
@JsonSerialize(using = com.biit.form.submitted.serialization.jackson.SubmittedQuestionSerializer.class)
public class SubmittedQuestion extends SubmittedObject implements ISubmittedQuestion {
    private Set<String> answers;

    public SubmittedQuestion() {
        super();
    }

    public SubmittedQuestion(String tag) {
        super();
        setTag(tag);
        setText(tag);
    }

    @Override
    public void addAnswer(String answer) {
        if (this.answers == null) {
            this.answers = new HashSet<>();
        }
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
