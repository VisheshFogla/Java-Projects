/// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh Fogla (visheshfogla)

/**
 * The class creates an ArrayQueue which would store an array of persons later
 * in the program.
 */
package spacecolonies;

import queue.EmptyQueueException;

/**
 * 
 * @author Vishesh
 * @version 19.04.2020
 * @param <T>
 *            generic datatype.
 */
public class ArrayQueue<T> implements queue.QueueInterface<T> {
    private T[] queue;
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * the max capacity.
     */
    public static final int MAX_CAPACITY = 100;
    private int enqueueIndex;
    private int dequeueIndex;
    private int size;

    /**
     * Defines the constructor for the ArrayQueue class.The queue can initially
     * hold DEFAULT_CAPACITY objects. If more objects need to be added, then the
     * size can be expanded until it reaches MAX_CAPACITY objects. If
     * MAX_CAPACITY is exceeded, then throw an IllegalStateException.
     * Initializes the queue with the length of the array.
     */
    @SuppressWarnings("unchecked")
    public ArrayQueue() {
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        size = 0;
        enqueueIndex = 0;
        dequeueIndex = DEFAULT_CAPACITY;

    }


    /**
     * dequeue method (throws EmptyQueueException). Removes the front.
     * 
     * @return
     *         the thing dequeued
     */
    public T dequeue() {
        if (isEmpty()) {
            throw (new EmptyQueueException("Tried to dequeue from empty"));
        }
        T front = queue[enqueueIndex];
        queue[enqueueIndex] = null;
        enqueueIndex = (enqueueIndex + 1) % queue.length;
        size--;
        return front;
    } // end dequeue


    /**
     * reset values.
     */
    @SuppressWarnings("unchecked")
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
        queue = (T[])new Object[DEFAULT_CAPACITY + 1];
        size = 0;
        enqueueIndex = 0;
        dequeueIndex = DEFAULT_CAPACITY;
    }


    /**
     * enqueue, doubles size if the queue is full and doesn't exceed capacity
     * 
     * @param newEntry
     *            the object to put in
     */
    public void enqueue(T newEntry) {

        if (isFull()) { // double size of array
            System.out.println("Array is full");
            T[] oldQueue = queue;
            int oldSize = oldQueue.length;
            int newSize = size * 2 + 1;
            if (newSize > MAX_CAPACITY) {

                throw (new IllegalStateException("Capacity exceeded maximum"));
            }
            @SuppressWarnings("unchecked")
            T[] tempQueue = (T[])new Object[newSize];
            queue = tempQueue;
            for (int index = 0; index < oldSize - 1; index++) {
                queue[index] = oldQueue[enqueueIndex];
                enqueueIndex = (enqueueIndex + 1) % oldSize;
            } // end for
            enqueueIndex = 0;
            dequeueIndex = oldSize - 2;
        } // end if
        size++;
        dequeueIndex = (dequeueIndex + 1) % queue.length;
        queue[dequeueIndex] = newEntry;
    }


    /**
     * get size
     * 
     * @return
     *         size (how many elements in array)
     */
    public int getSize() {
        return size;
    }


    /**
     * get length of Queue array
     * 
     * @return
     *         length
     */
    public int getLength() {
        // return (size - enqueueIndex + dequeueIndex) % size + 1;
        return queue.length;
    }


    /**
     * if empty
     * 
     * @return
     *         true/false
     */
    public boolean isEmpty() {
        return (enqueueIndex == (dequeueIndex + 1) % queue.length);
    }


    /**
     * if full
     * 
     * @return
     *         true/false
     */
    private boolean isFull() {
        return (enqueueIndex == (dequeueIndex + 2) % queue.length);
    }


    /**
     * return the array version of the arrayQueue.
     * 
     * @return
     *         object array
     */
    public Object[] toArray() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }

        Object[] a = new Object[size];
        // count from enqueue, without manipulating it
        for (int i = 0; i < size; i++) {
            int j = (enqueueIndex + i) % queue.length;
            a[i] = queue[j];
            System.out.println("A at " + i + " was " + a[i].toString());
            // "Increment" The index from queue
        }
        return a;
    }


    /**
     * tostring method
     * 
     * @return
     *         string version, "[]" if empty
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            // "Increment" The index from queue
            int j = (enqueueIndex + i) % queue.length;
            sb.append(queue[j].toString());
            if (i < size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }


    /**
     * get the front element
     * 
     * @return
     *         front
     */
    public T getFront() {
        if (isEmpty()) {
            throw (new EmptyQueueException("Tried to access front of empty"));
        }
        T front = null;
        front = queue[enqueueIndex];
        return front;
    }


    /**
     * Two ArrayQueues are equal when they contain the same
     * elements in the same order. The method compares the sizes of the two
     * ArrayQueues and then iterate over the
     * contents.
     * 
     * 
     * @param obj
     *            the queue that is to be compared with.
     * 
     * @return a boolean value which indicates whether the ArrayQueues are equal
     *         or not.
     */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else if (obj == null) {
            return false;
        }
        else if (this.getClass() == obj.getClass()) {
            @SuppressWarnings("unchecked")
            ArrayQueue<T> other = (ArrayQueue<T>)obj;

            if (this.getSize() == other.getSize()) {
                for (int i = 0; i < size; i++) {

                    T myElement = queue[(enqueueIndex + i) % queue.length];

                    T otherElement = (T)other.queue[(other.enqueueIndex + i)
                        % other.queue.length];

                    if (!myElement.equals(otherElement)) {

                        return false;
                    }

                }

                return true;
            }

        }

        return false;
    }
}
