// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Vishesh (visheshfogla)

/**
 * The class defines a stack that is implemented through linked nodes. The class
 * also uses a private Node class. Linked Stack class defines basic methods for
 * the operation of a Stack which would be used to stack disks in the every
 * tower to solve the Tower of Hanoi.
 */
package towerofhanoi;

import java.util.EmptyStackException;

/**
 * @author Vishesh (visheshfogla)
 * @version 2020-03-25
 *
 * @param <T>
 *            Determines the data type of the objects that would be stored in
 *            the stack.
 */
public class LinkedStack<T> implements StackInterface<T> {

    /**
     * Declares the field that indicate the topNode and size of the stack.
     */
    private Node<T> topNode;
    private int size;

    /**
     * Defines the constructor of the LinkedStack class. The constructor
     * initializes the topNode to null and sets the size of the stack to be 0.
     * This defines the initial state of the stack which is empty.
     */
    public LinkedStack() {

        topNode = null;
        size = 0;
    }


    /**
     * 
     * The method returns an integer value which represents the size of the
     * stack. The size changes when objects are pushed or pop from the stack.
     * 
     * @return the size of the stack based on the number of objects or elements
     *         it contains.
     */
    public int size() {
        return size;
    }


    /**
     * The method makes the topNode of the LinkedStack null thereby making the
     * stack empty. This method empties the stack.
     */
    @Override
    public boolean isEmpty() {

        return topNode == null;
    }


    /**
     * The method returns the data of the topmost Node of the stack. This when
     * implemented with the disk object would return the topmost disk of the
     * stack. When the stack is empty then the method throws an exception.
     * 
     * @return T the data of the topNode in the LinkedStack.
     */
    @Override
    public T peek() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T data = topNode.getData();

        return data;
    }


    /**
     * The method removes the top most object of the stack and returns it. In
     * the case of disk implementation, the method would remove the topmost disk
     * from the stack and return it. The method also decreases the value of the
     * size. When the stack is empty then the method throws an exception.
     * 
     * @return T the data of the topmost Node of the stack.
     */
    @Override
    public T pop() {

        if (isEmpty()) {
            throw new EmptyStackException();
        }

        T data = topNode.getData();

        topNode = topNode.getNextNode();
        size--;
        return data;
    }


    /**
     * The method inserts an item in the stack. It takes the item to be inserted
     * in the stack as a parameter. It then pushes the item in the stack. In
     * case of disk implementation the method would push a disk in the tower.
     */
    @Override
    public void push(T item) {

        Node<T> newNode = new Node<T>(item, topNode);
        topNode = newNode;
        size++;
    }


    /**
     * The method clears the stack of any object and makes the sets the value of
     * size as 0.
     * The method clears the stack by setting the topNode as null and thereby
     * erasing the entire LinkedStack.
     */
    @Override
    public void clear() {

        topNode = null;
        size = 0;
    }


    /**
     * The method returns a string that shows the objects in the stack in the
     * form of strings. These objects are of data type T.
     * 
     * @return a string value that display the objects of the LinkedStack in
     *         order.
     */
    public String toString() {

        Node<T> temp = new Node<T>(null);
        temp = topNode;
        StringBuilder builder = new StringBuilder();
        builder.append('[');

        boolean firstItem = true;
        for (int i = 0; i < size; i++) {
            if (!firstItem) {
                builder.append(", ");
            }
            else {
                firstItem = false;
            }

            // String.valueOf will print null or the toString of the item
            builder.append(String.valueOf(temp.getData()));
            temp = temp.getNextNode();
        }
        builder.append(']');
        return builder.toString();
    }

    /**
     * 
     * @author Vishesh
     *
     * @param <T>
     *            determines the data type of the node that the class defines.
     */

    @SuppressWarnings("hiding")
    private class Node<T> {

        /**
         * Declares the fields for Node class which represent the next pointer
         * and data of the Node.
         */
        private Node<T> next;
        private T data;

        /**
         * 
         * The constructor sets the data field of the Node to anEntry which is
         * taken as a parameter.
         * 
         * @param anEntry
         *            takes the entry which the data field is set to.
         */
        public Node(T anEntry) {
            data = anEntry;
        }


        /**
         * 
         * Defines a second constructor that takes anEntry and the next Node as
         * parameter.
         * 
         * @param anEntry
         *            the item that the data field is set to.
         * @param further
         *            represents the next Node which is to be set.
         */
        public Node(T anEntry, Node<T> further) {
            data = anEntry;
            setNextNode(further);

        }


        /**
         * 
         * The method gives the nextNode that is followed by the current one.
         * 
         * @return the Node following the one that the pointer is currently
         *         pointing to.
         */
        public Node<T> getNextNode() {

            return next;
        }


        /**
         * 
         * The method gives the data of the Node that the pointer is currently
         * pointing to.
         * 
         * @return the data of the Current Node.
         */
        public T getData() {

            return data;
        }


        /**
         * 
         * The method sets the next field of the Current Node to point to the
         * Node that is taken in the parameter.
         * 
         * @param nextNode
         *            the Node that to which the next field of the current Node
         *            will point to.
         */
        public void setNextNode(Node<T> nextNode) {
            next = nextNode;
        }

    }

}
