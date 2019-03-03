package ms225hk_assign2.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedQueueTest {
    private static int testCounts = 0;

    private static void enqueueGenerator(Queue queue, int times) {
        for (int i = 0; i < times; i++) {
            queue.enqueue(i);
        }
    }

    private static void dequeueGenerator(Queue queue, int times) {
        for (int i = 0; i < times; i++) {
            queue.dequeue();
        }
    }

    Queue create() {

          return new LinkedQueue();
        //return new ArrayQueue();
    }

    private Queue creatorFunction(int number) {
        Queue queue = create();
        enqueueGenerator(queue, number);
        return queue;
    }

    @BeforeEach
    void setUp() {
        testCounts++;
        System.out.print("Test: " + testCounts + ": ");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test pass");
    }

    @Test
    void sizeTest() {
        Queue queue = creatorFunction(100000);
        assertEquals(100000, queue.size());
        queue = creatorFunction(0);
        assertEquals(0, queue.size());

    }

    @Test
    void isEmptyTest() {
        Queue queue = create();
        enqueueGenerator(queue, 10000);
        assertEquals(10000, queue.size());
        assertFalse(queue.isEmpty());
        queue = creatorFunction(0);
        assertTrue(queue.isEmpty());

    }

    @Test
    void enqueueTest() {

        Queue queue = creatorFunction(1999);
        queue.enqueue(2000);
        queue.enqueue("add");
        queue.enqueue(1);
        queue.enqueue(2);
        assertEquals(2003, queue.size());
        queue = creatorFunction(1000000);
        assertEquals(1000000, queue.size());

    }

    @Test
    void dequeueTest() {
        Queue queue = create();
        enqueueGenerator(queue, 10000);
        assertEquals(10000, queue.size());
        dequeueGenerator(queue, 10000);
        assertEquals(0, queue.size());
        //Check the exceptions throw
        assertThrows(IndexOutOfBoundsException.class, queue::dequeue);


    }

    @Test
    void firstTest() {
        Queue queue = create();
        enqueueGenerator(queue, 10000);
        assertEquals(0, queue.first());
        dequeueGenerator(queue, 10000);
        //Check the exceptions throw
        assertThrows(EmptyStackException.class, queue::first);

    }

    @Test
    void lastTest() {
        Queue queue = create();
        enqueueGenerator(queue, 8954);
        assertEquals(8953, queue.last());
        dequeueGenerator(queue, 8954);
        //Check the exceptions throw
        assertThrows(EmptyStackException.class, queue::last);
    }

    @Test
    void toStringTest() {
        Queue testS = creatorFunction(5);
        testS.enqueue("to string test");
        assertEquals("[ 0 1 2 3 4 to string test ]", testS.toString());
    }

    @Test
    void iteratorTest() {
        Queue queue = create();
        Iterator<Object> itr1 = queue.iterator();
        assertThrows(NoSuchElementException.class, itr1::next);
        enqueueGenerator(queue, 156);
        Iterator<Object> itr2 = queue.iterator();
        assertTrue(itr2.hasNext());
    }
}