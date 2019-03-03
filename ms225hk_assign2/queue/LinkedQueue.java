package ms225hk_assign2.queue;
/*
  LinkedQueue implements the interface <code>Queue</code>.
  @author Mohammed Sabbagh
 * @see package ms225hk_assign2.queue.java
 */

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue implements Queue {
    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public LinkedQueue() {

    }

    /**
     * current queue size
     *
     * @return <code>Integer</code> current size of the queue.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return <code>boolean</code> current state of the queue if it is empty.
     */
    @Override
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Add object <code>element</code> to the queue.
     *
     * @param element Object to be added to the queue.
     */
    @Override
    public void enqueue(Object element) {
        if (head == null) { // Add first element
            head = new Node(element);
            tail = head;
        } else {
            tail.next = new Node(element); // Attach new node
            tail = tail.next;// Update tail
        }
        size++;
    }

    /**
     * return and remove first element.
     *
     * @return the first object from the queue and delete it after that.
     * @throws IndexOutOfBoundsException when the queue is empty.
     */
    @Override
    public Object dequeue() throws IndexOutOfBoundsException {

        if (!isEmpty()) {
            Node first = head;
            Node pop = head.next;
            head = null;
            head = pop;
            size--;
            return first.value;
        }
        throw new IndexOutOfBoundsException();
    }

    /**
     * return (without removing) first element
     *
     * @return the value of the first element without removing it.
     * @throws EmptyStackException when queue is empty.
     */
    @Override
    public Object first() throws EmptyStackException {
        if (!isEmpty()) {
            return head.value;
        }
        throw new EmptyStackException();
    }

    /**
     * return (without removing) last element
     *
     * @return the value of the last element without removing it.
     * @throws EmptyStackException when tail is null.
     */
    @Override
    public Object last() {
        if (!isEmpty()) {
            return tail.value;
        }
        throw new EmptyStackException();
    }

    /**
     * @return a string of the queue content
     */
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        Node node = head;
        while (node != null) {
            buf.append(" ").append(node.value);
            node = node.next;
        }
        buf.append(" ]");
        return buf.toString();
    }

    /**
     * iterate all the elements in the queue.
     *
     * @return an iterator
     */
    @Override
    public Iterator<Object> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<Object> {
        private Node node = head;

        public boolean hasNext() {
            return node != null;
        }

        /**
         * @return The next element of the queue.
         */
        @Override
        public Object next() throws NoSuchElementException {
            if (node == null) {
                throw new NoSuchElementException();
            }
            Object value = node.value;
            node = node.next;
            return value;
        }

    }

    private class Node {
        Object value;
        Node next = null;

        Node(Object v) {
            value = v;
        }
    }
}
