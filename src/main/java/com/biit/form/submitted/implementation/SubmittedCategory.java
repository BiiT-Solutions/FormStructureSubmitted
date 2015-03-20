package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedCategory;
import com.biit.form.submitted.SubmittedObject;

public class SubmittedCategory extends SubmittedObject implements ISubmittedCategory {

	public SubmittedCategory(String tag) {
		super();
		setTag(tag);
		// Needed to make compatible the different importers
		setText(tag);
	}
}
