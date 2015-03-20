package com.biit.form.submitted;

public interface ISubmittedFormElement {

	public String getName();

	public String getOriginalValue();

	public boolean isVariableDefined(String varName);

	public boolean isVariableDefined(Object submittedFormTreeObject, String varName);

	public Object getVariableValue(String varName);

	public Object getVariableValue(Object submmitedFormObject, String varName);

	public void setVariableValue(String varName, Object value);

	public void setVariableValue(Object submmitedFormObject, String varName, Object value);

	public String generateXML(String tabs);

	/**
	 * Returns the variable value for a element of selected type with defined name.
	 * 
	 * @param type
	 * @param treeObjectName
	 * @param varName
	 * @return
	 */
	public Object getVariableValue(Class<?> type, String treeObjectName, String varName);

	/**
	 * Returns the variable value of the first element of the desired type.
	 * 
	 * @param type
	 * @param varName
	 * @return
	 */
	public Object getVariableValue(Class<?> type, String varName);
}
