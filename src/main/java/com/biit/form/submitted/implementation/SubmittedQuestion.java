package com.biit.form.submitted.implementation;

/*-
 * #%L
 * Form Structure Submitted Answers
 * %%
 * Copyright (C) 2015 - 2025 BiiT Sourcing Solutions S.L.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * #L%
 */

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
