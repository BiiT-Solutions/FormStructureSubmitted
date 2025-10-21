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

import java.util.Map;

public interface ISubmittedFormElement {

    String getName();

    String getOriginalValue();

    boolean isVariableDefined(String varName);

    boolean isVariableDefined(ISubmittedObject submittedFormTreeObject, String varName);

    Object getVariableValue(String varName);

    Object getVariableValue(ISubmittedObject submmitedFormObject, String varName);

    Map<String, Object> getVariablesValue(ISubmittedObject submittedFormObject);

    Map<String, Object> getVariablesValue();

    void setVariableValue(String varName, Object value);

    void setVariableValue(ISubmittedObject submittedFormObject, String varName, Object value);

    String generateXML(String tabs);

    /**
     * Returns the variable value for a element of selected type with defined name.
     *
     * @param type
     * @param treeObjectName
     * @param varName
     * @return
     */
    <T extends ISubmittedObject> Object getVariableValue(Class<T> type, String treeObjectName, String varName);

    /**
     * Returns the variable value of the first element of the desired type.
     *
     * @param type
     * @param varName
     * @return
     */
    <T extends ISubmittedObject> Object getVariableValue(Class<T> type, String varName);
}
