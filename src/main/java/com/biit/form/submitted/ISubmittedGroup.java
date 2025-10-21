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

public interface ISubmittedGroup extends ISubmittedObject {

    /**
     * Is a loop.
     *
     * @return
     */
    boolean isRepeatable();

    /**
     * Mark this group as a loop.
     *
     * @param repeatable
     */
    void setRepeatable(boolean repeatable);

    /**
     * Returns the childs that are in an iteration. Returns a sublist of getChildren() with the elements in range
     * between [iteration * childrenByIteration, iteration * childrenByIteration + childrenByIteration - 1]
     *
     * @param iteration
     * @return
     */
    List<SubmittedObject> getIteration(int iteration);

    /**
     * Adds an iteration in the group.
     */
    void increaseNumberOfIterations();
}
