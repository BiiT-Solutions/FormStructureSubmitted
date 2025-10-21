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

import com.biit.form.submitted.ISubmittedGroup;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.List;

@JsonDeserialize(using = com.biit.form.submitted.serialization.jackson.SubmittedGroupDeserializer.class)
@JsonSerialize(using = com.biit.form.submitted.serialization.jackson.SubmittedGroupSerializer.class)
public class SubmittedGroup extends SubmittedObject implements ISubmittedGroup {
    private boolean repeatable = false;
    private int numberOfIterations = 0;

    public SubmittedGroup() {
        super();
    }

    public SubmittedGroup(String tag) {
        super();
        setTag(tag);
        setText(tag);
    }

    @Override
    public boolean isRepeatable() {
        return repeatable;
    }

    @Override
    public void setRepeatable(boolean repeatable) {
        this.repeatable = repeatable;
    }

    public void setNumberOfIterations(int numberOfIterations) {
        this.numberOfIterations = numberOfIterations;
    }

    public int getNumberOfIterations() {
        return numberOfIterations;
    }

    @Override
    public void increaseNumberOfIterations() {
        setRepeatable(true);
        numberOfIterations++;
    }

    @Override
    public List<SubmittedObject> getIteration(int iteration) {
        if (iteration > numberOfIterations) {
            return null;
        }
        final int childrenByIteration = getChildren().size() / numberOfIterations;

        return getChildren().subList(iteration * childrenByIteration,
                iteration * childrenByIteration + childrenByIteration);
    }

}
