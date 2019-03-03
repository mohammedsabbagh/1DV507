package ms225hk_assign2.queue;

import java.util.Iterator;

public class ArrayQueueMain {

    public static void main(String[] args) {

        ArrayQueue array = new ArrayQueue();
        Object o1 = 1;
        Object o2 = 2;
        Object o3 = 3;
        Object o4 = 4;
        Object o5 = 5;
        array.enqueue(o1);
        array.enqueue(o2);
        array.enqueue(o3);
        array.enqueue(o4);
        array.enqueue(o5);
        Iterator<Object> iterator = array.iterator();
        while (iterator.hasNext()) {
            Object temp = iterator.next();
            System.out.print(temp.toString() + " ");
        }
        System.out.println();
        System.out.println("First element in the Queue: " + array.first());
        System.out.println("Last element in the Queue: " + array.last());

        System.out.println("elements left in the queue: " + array.toString());
        System.out.println("Is the queue empty: " + array.isEmpty());

        try {
            System.out.printf("dequeue element: %s\n", array.dequeue());
        } catch (Exception e) {
            System.err.printf("Exception: %s\n", e.getMessage());
        }
        System.out.printf("queue size: %d\n", array.size());
        System.out.println("elements left in the queue: " + array.toString());
    }

}


