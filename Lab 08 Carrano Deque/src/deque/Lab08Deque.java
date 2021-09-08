package deque;

/**
 * A deque implemented using a doubly-linked chain.
 *
 * @param <T>
 *            The type of elements contained in the deque.
 *
 * @author <Vishesh> <visheshfogla>
 * @version <03/24/2020>
 */
public class Lab08Deque<T> extends DLinkedDeque<T> {

    private DLNode<T> newNode;

    /**
     * Defines the constructor of the class.
     */
    public Lab08Deque() {
        super();
    }


    /**
     * Inserts a new item at the front of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToFront(T newEntry) {
        newNode = new DLNode<>(null, newEntry, firstNode);

        if (isEmpty()) {
            lastNode = newNode;
        }
        else {
            firstNode.setPreviousNode(newNode);
        }
        firstNode = newNode;

        size++;

    }


    /**
     * Insert a new item at the rear of the deque.
     * 
     * @param newEntry
     *            the item to insert.
     */
    public void addToBack(T newEntry) {

        newNode = new DLNode<>(lastNode, newEntry, null);

        if (isEmpty()) {
            firstNode = newNode;
        }
        else {
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        size++;

    }


    /**
     * Remove the item at the front of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is not an element at the front
     */
    public T removeFront() {

        if (firstNode == null) {
            throw new EmptyQueueException();
        }

        T data = getFront();
        firstNode = firstNode.getNextNode();

        size--;
        return data;
    }


    /**
     * Remove the item at the rear of the deque.
     * 
     * @return The item that was removed
     * @throws EmptyQueueException
     *             if there is no element at the front
     */
    public T removeBack() {

        if (firstNode == null) {
            throw new EmptyQueueException();
        }

        T data = getBack();
        lastNode = lastNode.getPreviousNode();

        size--;
        return data;

    }


    /**
     * Get the item at the front (the head) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the front of the deque.
     * @throws EmptyQueueException
     *             if no element at the front
     */
    public T getFront() {

        if (firstNode == null) {
            throw new EmptyQueueException();
        }

        return firstNode.getData();

    }


    /**
     * Get the item at the rear (the tail) of the deque. Does not alter the
     * deque.
     * 
     * @return the item at the rear of the deque.
     * @throws EmptyQueueException
     *             if no element at rear
     * 
     */
    public T getBack() {

        if (firstNode == null) {
            throw new EmptyQueueException();
        }

        return lastNode.getData();

    }


    /**
     * Check if the deque is empty
     * 
     * @return true if the deque has no items
     */
    public boolean isEmpty() {

        return size == 0;

    }


    /**
     * Empty the deque.
     */
    public void clear() {

        firstNode = null;
        lastNode = null;
        size = 0;

    }


    // ----------------------------------------------------------
    /**
     * Returns a string representation of this deque. A deque's string
     * representation is written as a comma-separated list of its contents (in
     * front-to-rear order) surrounded by square brackets, like this:
     * 
     * [52, 14, 12, 119, 73, 80, 35]
     * 
     * An empty deque is simply [].
     *
     * @return a string representation of the deque
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");
        DLNode<T> p = firstNode;
        while (p != null) {
            if (s.length() > 1) {
                s.append(", ");
            }
            s.append(p.getData());
            p = p.getNextNode();
        }
        s.append("]");
        return s.toString();
    }


    /**
     * Removes and returns the second entry of this deque The front entry stays
     * the same and the third entry becomes the second.
     * 
     * @return The second object of the deque. Null, if it doesn't exist.
     * @throws EmptyQueueException
     *             if the deque is empty before the operation.
     */

    public T removeSecond() {
        if (isEmpty()) {
            throw new EmptyQueueException();
        }
        else if (this.size() == 1) {
            return null;
        }
        else if (this.size() == 2) {

            T data = firstNode.getNextNode().getData();
            lastNode = lastNode.getPreviousNode();
            
            return data;
        }
        
        DLNode<T> data = firstNode.getNextNode();
        data.getPreviousNode().setNextNode(data.getNextNode());
        data.getNextNode().setPreviousNode(data.getPreviousNode());
        
        return data.getData();

    } // end removeSecond


    /**
     * Removes and returns the second to last entry of this deque. All other
     * entries stay the same and the third to last entry becomes the second to
     * last.
     * 
     * @return The object second to last in the deque and null if it doesn't
     *         exist.
     * @throws EmptyQueueException
     *             if the deque is empty before the operation.
     */
    public T removeSecondToLast() {
      
        if(isEmpty())
        {
            throw new EmptyQueueException();
        }
        else if(this.size() == 1)
        {
            return null;
        }
        else if(this.size() == 2)
        {
            T data = firstNode.getData();
            firstNode = firstNode.getNextNode();
            
            return data; 
        } 
        
        DLNode<T> data = lastNode.getPreviousNode();
        data.getPreviousNode().setNextNode(data.getNextNode());
        data.getNextNode().setPreviousNode(data.getPreviousNode());
        
        return data.getData();
        
    } // end removeSecondToLast

}
