package com.biit.form.submitted;

import java.util.List;

public interface ISubmittedObject extends Comparable<ISubmittedObject> {

	String getTag();

	void setTag(String tag);

	String getText();

	void setText(String text);

	ISubmittedObject getParent();

	void setParent(ISubmittedObject parent);

	void addChild(ISubmittedObject child);

	List<ISubmittedObject> getChildren();

	void setChildren(List<ISubmittedObject> children);

	/**
	 * Makes a deep search of an element thas is from this type and has this tag.
	 */
	ISubmittedObject getChild(Class<?> type, String tag);

	/**
	 * Return all childrens that are of this class.
	 * 
	 * @param type
	 * @return
	 */
	List<ISubmittedObject> getChildren(Class<?> type);

	/**
	 * Creates a name with all the technical names
	 */
	String getPathName();

	Integer getIndex(ISubmittedObject child);

	int compareTo(ISubmittedObject arg0);

	int getLevel();

	/**
	 * This function takes a String list of names and returns the child
	 * referenced in the path. If the child doesn't exist returns null.
	 * 
	 * @param childPath
	 * @return
	 */
	ISubmittedObject getChild(List<String> subList);
	
	/**
	 * This function returns a treeObject child by name using . as a level
	 * separator. If the child doesn't exist returns null.
	 * 
	 * @param pathstring
	 * @return
	 */
	ISubmittedObject getChild(String pathstring);

}
