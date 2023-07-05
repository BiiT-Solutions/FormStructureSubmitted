package com.biit.form.submitted;

import java.util.HashMap;

public interface ISubmittedFormElement {

    String getName();

    String getOriginalValue();

    boolean isVariableDefined(String varName);

    boolean isVariableDefined(Object submittedFormTreeObject, String varName);

    Object getVariableValue(String varName);

    Object getVariableValue(Object submmitedFormObject, String varName);

    HashMap<String, Object> getVariablesValue(Object submmitedFormObject);

    HashMap<String, Object> getVariablesValue();

    void setVariableValue(String varName, Object value);

    void setVariableValue(Object submmitedFormObject, String varName, Object value);

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
