package com.biit.form.submitted;

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
