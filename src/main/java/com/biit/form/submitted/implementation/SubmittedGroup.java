package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedGroup;

import java.util.List;

public class SubmittedGroup extends SubmittedObject implements ISubmittedGroup {
    private boolean repeatable = false;
    private int numberOfIterations = 0;

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
