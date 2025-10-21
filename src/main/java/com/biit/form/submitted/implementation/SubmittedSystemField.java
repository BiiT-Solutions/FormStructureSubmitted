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

import com.biit.form.submitted.ISubmittedSystemField;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedSystemFieldDeserializer.class)
@JsonSerialize(using = com.biit.form.submitted.serialization.jackson.SubmittedSystemFieldSerializer.class)
public class SubmittedSystemField extends SubmittedObject implements ISubmittedSystemField {

    private String value;

    public SubmittedSystemField() {
        super();
    }

    public SubmittedSystemField(String tag) {
        super();
        setTag(tag);
        setText(tag);
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }
}
