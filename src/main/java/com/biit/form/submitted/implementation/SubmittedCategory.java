package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedCategory;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedCategoryDeserializer.class)
public class SubmittedCategory extends SubmittedObject implements ISubmittedCategory {
    public SubmittedCategory() {

    }

    public SubmittedCategory(String tag) {
        super();
        setTag(tag);
        // Needed to make compatible the different importers
        setText(tag);
    }
}
