package com.biit.form.submitted;

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
