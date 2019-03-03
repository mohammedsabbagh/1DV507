package ms225hk_assign2.queue;

import java.util.Iterator;


public class QueueMain {

    public static void main(String[] args) {

        LinkedQueue queue = new LinkedQueue();
        Object o1 = 1;
        Object o2 = 2;
        Object o3 = 3;
        Object o4 = 4;
        Object o5 = 5;
        queue.enqueue(o1);
        queue.enqueue(o2);
        queue.enqueue(o3);
        queue.enqueue(o4);
        queue.enqueue(o5);
        Iterator<Object> iterator = queue.iterator();
        while (iterator.hasNext()) {
            Object temp = iterator.next();
            System.out.print(temp.toString() + " ");
        }
        System.out.println();
        System.out.println("First element in the Queue: " + queue.first());
        System.out.println("Last element in the Queue: " + queue.last());
        queue.dequeue();
        System.out.println("elements left in the queue: " + queue.toString());
        queue.dequeue();
        System.out.println("elements left in the queue: " + queue.toString());
        queue.dequeue();
        System.out.println("elements left in the queue: " + queue.toString());
        queue.dequeue();
        System.out.println("elements left in the queue: " + queue.toString());

        System.out.println("Is the queue empty: " + queue.isEmpty());


    }
}
