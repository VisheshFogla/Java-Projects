/**
 * 
 */
package game;

import bag.SimpleBagInterface;

import student.TestableRandom;
import bag.Node;

/**
 * 
 * @author Vishesh visheshfogla
 * @version 02/26/2020.
 * 
 * @param <T>
 *            Defines a generic class for implementing bag
 *            with the help of a linked chain.
 */
public class SimpleLinkedBag<T> implements SimpleBagInterface<T> {

    private Node<T> firstNode;
    private int numberOfEntries;

    /**
     * Defines the constructor for SimpleLinkedBag class.
     */
    public SimpleLinkedBag() {
        firstNode = null;
        numberOfEntries = 0;
    }


    /**
     * The method adds an element in the bag.
     */
    @Override
    public boolean add(T anEntry) {

        if (anEntry == null) {
            return false;
        }

        Node<T> scan = new Node<T>(anEntry);
        scan.setNext(firstNode);
        firstNode = scan;
        numberOfEntries++;
        return true;
    }


    /**
     * The method returns the current size of the bag.
     */
    @Override
    public int getCurrentSize() {

        return numberOfEntries;
    }


    /**
     * The method checks if the bag is empty of not.
     */
    @Override
    public boolean isEmpty() {

        return numberOfEntries == 0;
    }


    /**
     * The method picks an element from the bag and returns it.
     */
    @Override
    public T pick() {

        if (isEmpty()) {
            return null;
        }

        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);

        Node<T> start = firstNode;

        for (int i = 0; i < index; i++) {
            start = start.next();
        }

        return start.data();
    }


    /**
     * @param anEntry
     *            The method returns the position of a
     *            given element in the bag.
     * @return position of an element in the bag.
     */
    private Node<T> getReferenceTo(T anEntry) {

        Node<T> currentNode = firstNode;

        while ((currentNode != null)) {
            if (currentNode.data().equals(anEntry)) {
                return currentNode;
            }

            currentNode = currentNode.next();
        }

        return currentNode;

    }


    /**
     * The method removes a specified element from the bag.
     */
    @Override
    public boolean remove(T anEntry) {

        if (getReferenceTo(anEntry) == null) {
            return false;
        }

        Node<T> remove = getReferenceTo(anEntry);

        remove.setData(firstNode.data());
        firstNode = firstNode.next();
        numberOfEntries--;

        return true;
    }

}
