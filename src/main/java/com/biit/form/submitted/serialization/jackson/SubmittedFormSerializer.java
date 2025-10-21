package com.biit.form.submitted.serialization.jackson;

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

import com.biit.form.submitted.implementation.SubmittedForm;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

public class SubmittedFormSerializer extends SubmittedObjectSerializer<SubmittedForm> {

    @Override
    public void serialize(SubmittedForm src, JsonGenerator jgen) throws IOException {
        super.serialize(src, jgen);
        if (src.getApplicationName() != null) {
            jgen.writeStringField("applicationName", src.getApplicationName());
        }
        if (src.getOrganization() != null) {
            jgen.writeStringField("organization", src.getOrganization());
        }
        if (src.getVersion() != null) {
            jgen.writeStringField("version", String.valueOf(src.getVersion()));
        }
        if (src.getSubmittedBy() != null) {
            jgen.writeStringField("submittedBy", String.valueOf(src.getSubmittedBy()));
        }
    }
}
