package ms225hk_assign2.queue;

import java.util.EmptyStackException;
import java.util.Iterator;

public class ArrayQueue implements Queue {

    int first = 0;
    int last = 0;
    int next = 0;
    int size = 0;
    private Object[] array = new Object[8];

    /**
     * @return <code>Integer</code>    current queue size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * @return <code>Boolean</code> true if queue is empty
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param element add element at end of queue
     */
    @Override
    public void enqueue(Object element) {
        if (size + 1 > array.length)
            resize();
        array[next] = element;
        increment();
    }

    /**
     * @return element return and remove first element
     */
    @Override
    public Object dequeue() {

        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Empty queue");
        }
        Object element;
        element = array[(first++) % array.length];
        --size;
        return element;
    }

    /**
     * @return element first element in the queue
     */
    @Override
    public Object first() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[first];
    }

    /**
     * @return element  last element in the queue
     */
    @Override
    public Object last() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[last];
    }

    /**
     * @return element iterator   The iterator iterates over all elements of the queue
     */
    @Override
    public Iterator<Object> iterator() {
        return new Iterator<Object>() {
            int temp = first;

            @Override
            public boolean hasNext() {
                return (temp >= 0) && (temp <= last);
            }

            @Override
            public Object next() {
                return array[(temp++) % array.length];
            }
        };
    }

    private void resize() {
        int oldSize = array.length;
        int newSize = oldSize * 2;
        int diff = newSize - oldSize;

        int headSize = array.length - first;

        Object[] arrayTmp = new Object[newSize];

        if (first > last) {
            System.arraycopy(array, 0, arrayTmp, 0, next); // next = last + 1
            System.arraycopy(array, first, arrayTmp, first += diff, headSize);
        } else {
            System.arraycopy(array, first, arrayTmp, first, size);
            next = size;
        }

        array = arrayTmp;
    }

    /**
     * @return a string of the queue content
     */
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("[");
        Iterator<Object> itr = iterator();

        while (itr.hasNext()) {
            if (buf.length() != 0) {
                buf.append(" ");
            }
            buf.append(itr.next());
        }
        buf.append(" ]");
        return buf.toString();
    }

    private void increment() {
        last = next;
        if (size < array.length && next + 1 >= array.length) {
            next = 0;
        } else {
            next++;
        }
        size++;
    }


}
