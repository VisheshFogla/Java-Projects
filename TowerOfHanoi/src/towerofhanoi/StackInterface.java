// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * 
 */
package towerofhanoi;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 *
 * @param <T>
 *            decides the data type that the Stack interface will implement.
 *
 */
public interface StackInterface<T> {

    /**
     * Checks if the stack is empty.
     * 
     * @return Returns true if the stack is empty.
     */
    public boolean isEmpty();


    /**
     * Checks the item at the top of the
     * stack without removing it.
     * 
     * @return Item at the top of the stack.
     */
    public T peek();


    /**
     * Removes the item at the top of
     * the stack.
     * 
     * @return The item that was removed.
     */
    public T pop();


    /**
     * Pushes an item onto the stack.
     * 
     * @param item
     *            Item to be pushed
     *            onto the stack.
     */
    public void push(T item);


    /**
     * Checks if an item is in the stack.
     * 
     * @param item
     *            Item to be looked for.
     * @return Returns true if the item is
     *         somewhere in the stack.
     */

    /**
     * Clears the stack (removes all of
     * the items from the stack).
     */
    public void clear();
}
