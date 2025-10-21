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

import com.biit.form.submitted.implementation.SubmittedObject;

import java.util.List;

public interface ISubmittedObject extends Comparable<ISubmittedObject> {

    String getTag();

    void setTag(String tag);

    String getText();

    void setText(String text);

    ISubmittedObject getParent();

    void setParent(SubmittedObject parent);

    void addChild(SubmittedObject child);

    List<SubmittedObject> getChildren();

    void setChildren(List<SubmittedObject> children);

    /**
     * Makes a deep search of an element that is from this type and has this tag.
     */
    <T> T getChild(Class<T> type, String tag);

    /**
     * Return all children that are of this class.
     *
     * @param type
     * @return
     */
    <T> List<T> getChildrenRecursive(Class<T> type);

    /**
     * Creates a name with all the technical names
     */
    String getPathName();

    /**
     * Gets the path to the element as a list of tags.
     *
     * @return
     */
    List<String> getPath();

    Integer getIndex(ISubmittedObject child);

    int compareTo(ISubmittedObject arg0);

    int getLevel();

    /**
     * This function takes a String list of names and returns the child referenced
     * in the path. If the child doesn't exist returns null.
     *
     * @return
     */
    ISubmittedObject getChild(List<String> subList);

    /**
     * This function returns a treeObject child by name using '.' as a level
     * separator. If the child doesn't exist returns null.
     *
     * @param pathstring
     * @return
     */
    ISubmittedObject getChild(String pathstring);

    /**
     * Returns the xpath of the object.
     *
     * @return
     */
    String getXPath();

    <T> List<T> getChildren(Class<T> type);

}
