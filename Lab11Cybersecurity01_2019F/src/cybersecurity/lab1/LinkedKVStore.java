package cybersecurity.lab1;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A doubly linked list with sentinel nodes, where each node contains a
 * key-value pair.
 * 
 * @author victoriahairston1
 * @version 29.3.2017
 *
 * @param <K>
 *            the type of the key
 * @param <V>
 *            the type of the value
 */
public class LinkedKVStore<K, V>
    implements LinkedKVStoreInterface<K, V>, Iterable<K> {

    private class Node { // non-static inner class, every Node belongs to an
                         // outer LinkedKVStore object

        private Node prev;
        private Node next;
        private K key;
        private V value;

        /**
         * Node constructor no parameters
         */
        public Node() {
            prev = null;
            next = null;
            key = null;
            value = null;

        }


        /**
         * Node constructor that takes two parameters.
         * 
         * @param key1
         *            takes the key that would correspond to a value.
         * @param value1
         *            represents the value of the key taken.
         */
        public Node(K key1, V value1) {

            prev = null;
            next = null;
            key = key1;
            value = value1;
        }


        /**
         * Links the node taken in the parameter and the node on which the
         * method is called.
         * 
         * @param nextNode
         *            the node which is to be linked.
         */
        private void linkWith(Node nextNode) {

            this.next = nextNode;
            nextNode.prev = this;
        }


        /**
         * inserts a node after the currentNode taken in the parameter.
         * 
         * @param current
         *            the node after which a new node has to be inserted.
         */
        private void insertAfter(Node current) {

            this.linkWith(current.next);

            current.next = this;
            this.prev = current;
            size++;

        }


        /**
         * removes the currentNode on which the method is called.
         */
        private void remove() {

            this.key = null;
            this.value = null;
            this.prev.linkWith(this.next);
            this.prev = null;
            this.next = null;
            size--;
        }

    }

    private int size;
    private Node head;
    private Node tail;

    /**
     * Creates the LinkedKVStore class
     */
    public LinkedKVStore() {

        head = new Node();
        tail = new Node();
        clear();
    }


    /**
     * Returns true if this list contains no elements.
     * 
     * @return true if this list contains no elements
     */
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Returns the number of elements in this list.
     * 
     * @return the number of elements in this list
     */
    public int size() {
        return size;
    }


    /**
     * Removes all of the elements from this list. The list will be empty after
     * this call returns.
     */
    public void clear() {
        size = 0;
        head.next = tail;
        tail.prev = head;
    }


    /**
     * Returns the first occurrence of the specified element in this list (when
     * traversing from head to tail). If this list contains an entry for the
     * specified key, the associated value is returned; otherwise, null is
     * returned.
     * 
     * @param key
     *            a key in this list
     * @return the value to which the key is mapped in this list
     */
    public V getFirst(K key) {
        for (Node current = head.next; current != tail; current =
            current.next) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }


    /**
     * Returns the last occurrence of the specified element in this list (when
     * traversing from head to tail). If this list contains an entry for the
     * specified key, the associated value is returned; otherwise, null is
     * returned.
     * 
     * @param key
     *            a key in this list
     * @return the value to which the key is mapped in this list
     */
    public V getLast(K key) {
        for (Node current = tail.prev; current != head; current =
            current.prev) {
            if (current.key.equals(key)) {
                return current.value;
            }
        }
        return null;
    }


    /**
     * Inserts the key (and its corresponding value) at the beginning of this
     * list.
     * 
     * @param key
     *            the key to be inserted
     * @param value
     *            the value to which the key will be mapped
     */
    public void addFirst(K key, V value) {
        Node node = new Node(key, value);
        node.insertAfter(head);
    }


    /**
     * Inserts the key (and its corresponding value) at the end of this list.
     * 
     * @param key
     *            the key to be inserted
     * @param value
     *            the value to which the key will be mapped
     */
    public void addLast(K key, V value) {
        Node node = new Node(key, value);
        node.insertAfter(tail.prev);

    }


    /**
     * Removes the first occurrence of the key (and its corresponding value) in
     * this list (when traversing the list from head to tail). If the list does
     * not contain the key, it is unchanged.
     * 
     * @param key
     *            the key that needs to be removed, if present
     * @return true if the list contained the specified element
     */
    public boolean removeFirst(K key) {
        for (Node curr = head.next; curr != tail; curr = curr.next) {
            if (curr.key.equals(key)) {
                curr.remove();
                return true;
            }
        }
        return false;
    }


    /**
     * Removes the last occurrence of the key (and its corresponding value) in
     * this list (when traversing the list from head to tail). If the list does
     * not contain the key, it is unchanged.
     * 
     * @param key
     *            the key that needs to be removed, if present
     * @return true if the list contained the specified element
     */
    public boolean removeLast(K key) {
        for (Node current = tail.prev; current != head; current =
            current.prev) {
            if (current.key.equals(key)) {
                current.remove();
                return true;
            }
        }
        return false;
    }


    /**
     * Returns true if this list contains the specified key.
     * 
     * @param key
     *            key whose presence in this list is to be tested
     * @return true if this list contains the specified key
     */
    public boolean contains(K key) {
        for (Node curr = head.next; curr != tail; curr = curr.next) {
            if (curr.key.equals(key)) {
                return true;
            }
        }
        return false;
    }


    /**
     * Creates a KVStoreIterator
     * 
     * @return an iterator
     */
    public Iterator<K> iterator() {
        return new KVStoreIterator();
    }


    /**
     * Returns a string representation of this linked-list displaying the key.
     * The list's string representation is written as a comma-separated list of
     * its contents (in front-to-rear order) surrounded by square brackets, like
     * this:
     * 
     * [52, 14, 12, 119, 73, 80, 35]
     * 
     * An empty linked-list is simply [].
     *
     * @return a string representation of the linked-list's keys
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Iterator<K> i = iterator();
        builder.append("[");
        while (i.hasNext()) {
            builder.append(i.next());
            builder.append(i.hasNext() ? ", " : "");
        }
        builder.append("]");
        return builder.toString();
    }

    private class KVStoreIterator implements Iterator<K> {
        private Node curr;

        /**
         * Creates the iterator
         */
        public KVStoreIterator() {
            curr = head;
        }


        /**
         * Checks if there is a next node
         * 
         * @return true if there is a next node
         */
        public boolean hasNext() {

            return curr.next.key != null;
        }


        /**
         * Moves to the next node
         * 
         * @return the key of the next node
         * @throws NoSuchElementException
         *             if called when no next element exists
         */
        public K next() {

            if (curr.next.key == null) {
                throw new NoSuchElementException();
            }

            K data = curr.next.key;
            curr = curr.next;
            return data;
        }
    }

}
