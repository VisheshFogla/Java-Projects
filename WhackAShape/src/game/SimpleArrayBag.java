/**
 * 
 */
package game;

import bag.SimpleBagInterface;
import student.TestableRandom;

/**
 * 
 * @author Vishesh visheshfogla.
 * @version 02/26/2020.
 *
 * @param <T>
 *            defines a generic class that can be of any data type.
 */
public class SimpleArrayBag<T> implements SimpleBagInterface<T> {

    private T[] bag;
    private static final int MAX = 25;
    private int numberOfEntries;

    /**
     * Defines the constructor of the SimpleArrayBag class.
     */
    public SimpleArrayBag() {
        @SuppressWarnings("unchecked")
        T[] tempBag = (T[])new Object[MAX];
        bag = tempBag;
        numberOfEntries = 0;
    }


    /**
     * The method adds an entry into the bag.
     */
    @Override
    public boolean add(T anEntry) {

        if ((numberOfEntries >= 25) || (anEntry == null)) {
            return false;
        }

        bag[numberOfEntries] = anEntry;
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
     * The method checks if the bag is empty or not
     * and accordingly returns the boolean value.
     */
    @Override
    public boolean isEmpty() {

        return numberOfEntries == 0;
    }


    /**
     * The method randomly picks an item from the bag and returns it.
     */
    @Override
    public T pick() {

        if (isEmpty()) {
            return null;
        }

        TestableRandom generator = new TestableRandom();
        int index = generator.nextInt(numberOfEntries);

        return bag[index];
    }


    /**
     * @param anEntry
     *            Takes an entry to get its index.
     * @return the index or position of the specified entry.
     */
    private int getIndexOf(T anEntry) {
        for (int i = 0; i < numberOfEntries; i++) {
            if (bag[i].equals(anEntry)) {
                return i;
            }

        }

        return -1;
    }


    /**
     * The method remove a given element from the bag.
     */
    @Override
    public boolean remove(T anEntry) {

        if (getIndexOf(anEntry) == -1) {
            return false;
        }

        bag[getIndexOf(anEntry)] = bag[numberOfEntries - 1];
        bag[numberOfEntries - 1] = null;
        numberOfEntries--;
        return true;

    }

}
