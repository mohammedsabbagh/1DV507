package ms225hk_assign2.queue;

import java.util.Iterator;

/**
 * An interface for linked queue.
 */


public interface Queue {
    /**
     * @return <code>Integer</code>    current queue size
     */
    int size();                     // current queue size

    /**
     * @return <code>Boolean</code> true if queue is empty
     */
    boolean isEmpty();              // true if queue is empty

    /**
     * @param element add element at end of queue
     */
    void enqueue(Object element);   // add element at end of queue

    /**
     * @return element return and remove first element
     */
    Object dequeue();               // return and remove first element.

    /**
     * @return element first element in the queue
     */
    Object first();                 // return (without removing) first element

    /**
     * @return element  last element in the queue
     */
    Object last();                  // return (without removing) last element

    /**
     * @return String representation of the queue content
     */
    String toString();              // return a string representation of the queue content

    /**
     * @return element iterator   The iterator iterates over all elements of the queue
     */
    Iterator<Object> iterator();    // element iterator
}
