package com.biit.form.submitted.implementation;

import com.biit.form.submitted.ISubmittedObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubmittedObject implements ISubmittedObject, Comparable<ISubmittedObject> {
    protected static final String DEFAULT_PATH_SEPARATOR = "/";
    // Tags of the Orbeon form
    private String tag;
    // The real name of the element
    private String text;

    private transient SubmittedObject parent;
    private List<SubmittedObject> children;

    public SubmittedObject() {
        children = new ArrayList<>();
    }

    @Override
    public String getTag() {
        return tag;
    }

    @Override
    public void setTag(String tag) {
        this.tag = tag;
    }

    @Override
    public String getText() {
        if (text != null) {
            return text;
        }
        return tag;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }

    public ISubmittedObject getParent() {
        return parent;
    }

    @Override
    public void setParent(SubmittedObject parent) {
        this.parent = parent;
    }

    @Override
    public void addChild(SubmittedObject child) {
        children.add(child);
        child.setParent(this);
    }

    @Override
    public List<SubmittedObject> getChildren() {
        return children;
    }

    @Override
    public void setChildren(List<SubmittedObject> children) {
        this.children = children;
        for (ISubmittedObject child : children) {
            child.setParent(this);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> T getChild(Class<T> type, String tag) {
        // Check first level.
        for (ISubmittedObject child : getChildren()) {
            if (child != null) {
                if (type.isInstance(child)) {
                    if (child.getTag().equals(tag)) {
                        return (T) child;
                    }
                }
                final T returnedChild = child.getChild(type, tag);
                if (returnedChild != null) {
                    return (T) returnedChild;
                }
            }
        }
        return null;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> getChildrenRecursive(Class<T> type) {
        final List<T> children = new ArrayList<>();
        for (ISubmittedObject child : getChildren()) {
            if (type.isInstance(child)) {
                children.add((T) child);
            }
            children.addAll(child.<T>getChildrenRecursive(type));
        }
        return children;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> List<T> getChildren(Class<T> type) {
        final List<T> children = new ArrayList<>();
        for (ISubmittedObject child : getChildren()) {
            if (type.isInstance(child)) {
                children.add((T) child);
            }
        }
        return children;
    }

    @Override
    public String toString() {
        return getPathName();
    }

    /**
     * Creates a name with all the technical names
     */
    @Override
    public String getPathName() {
        // Ignores the form.
        if (parent == null) {
            return null;
        } else {
            final String parentPath = parent.getPathName();
            if (parentPath == null) {
                return getTag();
            } else {
                return parentPath + DEFAULT_PATH_SEPARATOR + getTag();
            }
        }
    }

    @Override
    public List<String> getPath() {
        // Ignores the form.
        if (parent == null) {
            return new ArrayList<>();
        } else {
            final List<String> path = new ArrayList<>();
            final List<String> parentPath = parent.getPath();
            if (parentPath == null || parentPath.isEmpty()) {
                path.add(getTag());
                return path;
            } else {
                path.addAll(parentPath);
                path.add(getTag());
                return path;
            }
        }
    }

    /**
     * Get index of child
     *
     * @param child
     * @return
     */
    @Override
    public Integer getIndex(ISubmittedObject child) {
        return children.indexOf(child);
    }

    @Override
    public int getLevel() {
        if (parent == null) {
            return 0;
        } else {
            return parent.getLevel() + 1;
        }
    }

    @Override
    public int compareTo(ISubmittedObject arg0) {
        // This compare will only work for members of the same tree structure
        // Both of them are root
        if (getParent() == null && arg0.getParent() == null) {
            return 0;
        }
        // If one of the elements is root
        if (getParent() == null && arg0.getParent() != null) {
            return -1;
        }
        if (getParent() != null && arg0.getParent() == null) {
            return 1;
        }
        // None of them are root.
        final int levelThis = getLevel();
        final int levelArg0 = arg0.getLevel();

        if (levelThis == levelArg0) {
            // Both are in the same level
            if (getParent() != null) {
                if (getParent().equals(arg0.getParent())) {
                    // Same parent
                    return getParent().getIndex(this).compareTo(getParent().getIndex(arg0));
                } else {
                    return getParent().compareTo(arg0.getParent());
                }
            } else {
                // Two root elements
                return 0;
            }
        } else {
            // Check if they are father/son
            if (getParent().equals(arg0)) {
                return 1;
            }
            if (arg0.getParent().equals(this)) {
                return -1;
            }
            // If not, then return comparison with deepest element parent.
            if (levelThis > levelArg0) {
                return getParent().compareTo(arg0);
            } else {
                return compareTo(arg0.getParent());
            }
        }
    }

    /**
     * This function takes a String list of names and returns the child referenced
     * in the path. If the child doesn't exist returns null.
     *
     * @param childPath
     * @return
     */
    public ISubmittedObject getChild(List<String> childPath) {
        if (childPath == null || childPath.isEmpty()) {
            return null;
        } else {
            for (ISubmittedObject child : getChildren()) {
                if (child.getTag().equals(childPath.get(0))) {
                    if (childPath.size() == 1) {
                        return child;
                    } else {
                        return child.getChild(childPath.subList(1, childPath.size()));
                    }
                }
            }
            return null;
        }
    }

    /**
     * This function returns a treeObject child by name using '/' as a level
     * separator. If the child doesn't exist returns null.
     *
     * @param pathstring
     * @return
     */
    public ISubmittedObject getChild(String pathstring) {
        if (pathstring == null) {
            return null;
        }
        return getChild(pathstring.split(DEFAULT_PATH_SEPARATOR));
    }

    /**
     * Returns a treeObject child by the names of the path to it. If the child
     * doesn't exist returns null.
     *
     * @param pathStrings
     * @return
     */
    public ISubmittedObject getChild(String... pathStrings) {
        return getChild(Arrays.asList(pathStrings));
    }

    @Override
    public String getXPath() {
        final StringBuilder path = new StringBuilder();
        if (getParent() != null) {
            path.append(getParent().getXPath());
        }
        path.append("/" + this.getClass().getSimpleName() + "[@name='" + getTag() + "']");
        return path.toString();
    }

}
