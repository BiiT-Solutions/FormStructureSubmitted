package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedQuestion;

import java.util.HashSet;
import java.util.Set;

public class SubmittedQuestion extends SubmittedObject implements ISubmittedQuestion {
    private Set<String> answers;

    public SubmittedQuestion() {

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
