/**
 * 
 */
package arraystack;

import java.util.EmptyStackException;

/**
 * 
 * @author Vishesh
 * @version 02/28/2020.
 *
 * @param <T> defines a class that implements StackADT
 */
public class ArrayBasedStack<T> implements StackADT<T> {

    private T[] stackArray;
    private int size;
    private int capacity;

    /**
     * @param cap
     *            takes the integer parameter for stack's capacity.
     */
    @SuppressWarnings("unchecked")
    public ArrayBasedStack(int cap) {
        capacity = cap; 
        size = 0;

        T[] tempStack = (T[])new Object[capacity];
        stackArray = tempStack;
    }


    /**
     * Calls the parameterized constructor to construct a stack.
     */
    public ArrayBasedStack() {
        this(100);
    }


    /**
     * returns boolean if the stack is empty.
     */
    @Override
    public boolean isEmpty() {

        return size == 0;
    }


    /**
     * returns the topmost element of the stack.
     */
    @Override
    public T peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        return stackArray[size - 1];
    }


    /**
     * removes and returns the topmost element of the stack.
     */
    @Override
    public T pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T anEntry = stackArray[size - 1];
        stackArray[size - 1] = null;
        size--;
        return anEntry;
    }


    /**
     * Adds an item to the stack by placing it on the top.
     */
    @Override
    public void push(T item) {

        if (size == capacity) {
            this.expandCapacity();
        }

        stackArray[size] = item;
        size++;
    }


    /**
     * returns boolean if the stack contains the given element.
     */
    @Override
    public boolean contains(T item) {

        for (int i = 0; i < size; i++) {
            if (stackArray[i].equals(item)) {
                return true;
            }
        }

        return false;
    }


    /**
     * returns the size of the stack.
     */
    @Override
    public int size() {

        return size;
    }


    /**
     * clears the stack of all elements.
     */
    @Override
    public void clear() {

        for (int i = 0; i < size; i++) {
            stackArray[i] = null;
        }

        size = 0;
    }


    /**
     * converts the elements of the array to string.
     */
    @Override
    public T[] toArray() {

        @SuppressWarnings("unchecked")
        T[] copy = (T[])new Object[this.size()];
        for (int i = 0; i < this.size(); i++) {
            copy[i] = this.stackArray[i];
        }
        return copy;
    }


    /**
     * Expands the capacity of the stack by doubling its current capacity.
     */
    private void expandCapacity() {

        @SuppressWarnings("unchecked")
        T[] newArray = (T[])new Object[this.capacity * 2];

        for (int i = 0; i < this.capacity; i++) {
            newArray[i] = this.stackArray[i];
        }

        this.stackArray = newArray;
        this.capacity *= 2;
    }


    /**
     * Returns the string representation of the stack.
     * 
     * [] (if the stack is empty)
     * [bottom, item, ..., item, top] (if the stack contains items)
     * 
     * @return the string representation of the stack.
     */
    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < this.size(); i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(this.stackArray[i]));
        }
        builder.append(']');
        return builder.toString();
    }


    /**
     * Two stacks are equal iff they both have the same size and contain the
     * same elements in the same order.
     *
     * @param other
     *            the other object to compare to this
     *
     * @return {@code true}, if the stacks are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null) {  
            return false;
        }
        if (this.getClass().equals(other.getClass())) {
            ArrayBasedStack<?> otherStack = (ArrayBasedStack<?>)other;
            if (this.size() != otherStack.size()) {
                return false;
            }
            Object[] otherArray = otherStack.toArray();
            for (int i = 0; i < this.size(); i++) {
                if (!(this.stackArray[i].equals(otherArray[i]))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
