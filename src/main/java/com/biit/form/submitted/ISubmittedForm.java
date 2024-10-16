package com.biit.form.submitted;

import com.biit.form.entity.IFormWithAnswers;
import com.biit.form.submitted.implementation.SubmittedForm;

import java.time.LocalDateTime;

public interface ISubmittedForm extends ISubmittedObject, IFormWithAnswers {

    String getApplicationName();

    String getName();

    String getId();

    String toJson();

    SubmittedForm fromJson(String jsonString);

    String getSubmittedBy();

    LocalDateTime getSubmittedAt();

}
