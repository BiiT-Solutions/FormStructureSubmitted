package com.biit.form.submitted;

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
