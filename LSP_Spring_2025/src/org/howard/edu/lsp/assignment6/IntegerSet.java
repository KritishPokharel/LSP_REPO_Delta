package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;

//Edited the exception part in largest and smallest to meet assignment 6 requirement

/**
 * Represents a collection of distinct integers.
 * Internally, the set is managed using an ArrayList.
 */
public class IntegerSet {

    // Internal storage for the set elements.
    private ArrayList<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor that creates an empty IntegerSet.
     */
    public IntegerSet() {
    }

    /**
     * Constructs an IntegerSet using an existing ArrayList.
     * Only unique integers are added; duplicates are omitted.
     *
     * @param set the ArrayList of integers used for initialization.
     */
    public IntegerSet(ArrayList<Integer> set) {
        this.set = new ArrayList<Integer>();
        for (Integer num : set) {
            if (!this.set.contains(num)) {
                this.set.add(num);
            }
        }
    }

    /**
     * Clears all the integers from the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of integers in the set.
     *
     * @return the size of the set.
     */
    public int length() {
        return set.size();
    }

    /**
     * Compares this IntegerSet with another object.
     * Two IntegerSets are equal if they contain exactly the same integers,
     * irrespective of order.
     *
     * @param o the object to compare with.
     * @return true if both sets are equivalent; false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof IntegerSet))
            return false;
        IntegerSet other = (IntegerSet) o;
        if (this.length() != other.length())
            return false;
        for (Integer num : this.set) {
            if (!other.set.contains(num)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Checks if the set contains a given integer.
     *
     * @param value the integer to look for.
     * @return true if the integer is present; false otherwise.
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest integer in the set.
     *
     * @return the maximum integer.
     * @throws IntegerSetException if the set is empty(Changed to meet the assignment 6 requirements).
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new IntegerSetException("The set is empty.");
        }
        int max = set.get(0);
        for (int num : set) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Returns the smallest integer in the set.
     *
     * @return the minimum integer.
     * @throws IntegerSetException if the set is empty (Changed to meet the assignment 6 requirements).
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new IntegerSetException("The set is empty.");
        }
        int min = set.get(0);
        for (int num : set) {
            if (num < min) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Adds an integer to the set.
     * If the integer already exists, the set remains unchanged.
     *
     * @param item the integer to add.
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes the specified integer from the set.
     * If the integer is not present, no changes are made.
     *
     * @param item the integer to remove.
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Updates this set to be the union with another IntegerSet.
     * After this operation, this set will contain all unique integers from both sets.
     *
     * @param intSetb the other IntegerSet to union with.
     */
    public void union(IntegerSet intSetb) {
        for (int num : intSetb.set) {
            if (!this.set.contains(num)) {
                this.set.add(num);
            }
        }
    }

    /**
     * Updates this set to be the intersection with another IntegerSet.
     * Only the integers common to both sets are retained.
     *
     * @param intSetb the other IntegerSet to intersect with.
     */
    public void intersect(IntegerSet intSetb) {
        ArrayList<Integer> intersection = new ArrayList<Integer>();
        for (int num : this.set) {
            if (intSetb.set.contains(num)) {
                intersection.add(num);
            }
        }
        this.set = intersection;
    }

    /**
     * Updates this set to be the difference from another IntegerSet.
     * This removes all integers in the other set from this set.
     *
     * @param intSetb the IntegerSet to subtract from this set.
     */
    public void diff(IntegerSet intSetb) {
        ArrayList<Integer> difference = new ArrayList<Integer>();
        for (int num : this.set) {
            if (!intSetb.set.contains(num)) {
                difference.add(num);
            }
        }
        this.set = difference;
    }

    /**
     * Updates this set to be the complement relative to a universal set.
     * After this operation, this set will contain only those integers
     * that are in the universal set but not in the current set.
     *
     * @param intSetb the universal IntegerSet.
     */
    public void complement(IntegerSet intSetb) {
        ArrayList<Integer> complement = new ArrayList<Integer>();
        for (int num : intSetb.set) {
            if (!this.set.contains(num)) {
                complement.add(num);
            }
        }
        this.set = complement;
    }

    /**
     * Checks whether the set is empty.
     *
     * @return true if the set contains no integers; false otherwise.
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set.
     *
     * @return a string displaying the integers in the set.
     */
    @Override
    public String toString() {
        return set.toString();
    }
}
