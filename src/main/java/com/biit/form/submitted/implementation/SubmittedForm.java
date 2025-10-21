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

import com.biit.form.entity.IQuestionWithAnswers;
import com.biit.form.jackson.serialization.ObjectMapperFactory;
import com.biit.form.submitted.ISubmittedForm;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.time.LocalDateTime;
import java.util.List;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedFormDeserializer.class)
@JsonSerialize(using = com.biit.form.submitted.serialization.jackson.SubmittedFormSerializer.class)
public class SubmittedForm extends SubmittedObject implements ISubmittedForm {

    private String applicationName;
    @JsonAlias("name")
    @JsonProperty("tag")
    private String name;
    private Integer version;
    private String organization;
    private String submittedBy;
    private LocalDateTime submittedAt;

    public SubmittedForm() {
        super();
    }

    public SubmittedForm(String applicationName, String formName) {
        this();
        this.applicationName = applicationName;
        this.name = formName;
    }

    public SubmittedForm(String applicationName, String formName, Integer version) {
        this(applicationName, formName);
        this.version = version;
    }

    public String getApplicationName() {
        return applicationName;
    }

    @Override
    public String getTag() {
        return getName();
    }

    @Override
    public void setTag(String tag) {
        super.setTag(tag);
        name = tag;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        if ((this.getApplicationName() != null) && (this.getName() != null)) {
            return this.getApplicationName() + "/" + this.getName();
        }
        return null;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public List<IQuestionWithAnswers> getQuestionsWithAnswers() {
        return getChildrenRecursive(IQuestionWithAnswers.class);
    }

    @Override
    public SubmittedForm fromJson(String jsonString) {
        try {
            return getFromJson(jsonString);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static SubmittedForm getFromJson(String jsonString) throws JsonProcessingException {
        return ObjectMapperFactory.getObjectMapper().readValue(jsonString, SubmittedForm.class);
    }

    @Override
    public String toJson() {
        try {
            return ObjectMapperFactory.getObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getSubmittedBy() {
        return submittedBy;
    }

    public void setSubmittedBy(String submittedBy) {
        this.submittedBy = submittedBy;
    }

    @Override
    public LocalDateTime getSubmittedAt() {
        return submittedAt;
    }

    public void setSubmittedAt(LocalDateTime submittedAt) {
        this.submittedAt = submittedAt;
    }
}
