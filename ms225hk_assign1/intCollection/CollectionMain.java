package ms225hk_assign1.intCollection;

import java.util.Iterator;

public class CollectionMain {

    private static void arrayintlisttest() {
        IntList listOfInterger = new ArrayIntList();

        System.out.println("check list if it is empty: " + listOfInterger.isEmpty());
        System.out.println("Adding  integers");
        listOfInterger.add(34);
        listOfInterger.add(343);
        listOfInterger.add(4);
        listOfInterger.add(100);
        listOfInterger.add(200);
        listOfInterger.add(341);
        listOfInterger.add(14);

        System.out.println(listOfInterger);
        System.out.println("-----------");
        System.out.println("Get position of integer 14: " + listOfInterger.indexOf(14));
        System.out.println("-----------");
        try {
            System.out.println("add (1000) at position 6 ");
            listOfInterger.addAt(1000, 6);
            System.out.println(listOfInterger);
            System.out.println("-----------");
            System.out.println("Remove integer at position 17");
            listOfInterger.remove(17);
        } catch (IndexOutOfBoundsException e) {
        }

        System.out.println(listOfInterger);
        System.out.println("-----------");

        try {

            System.out.println("Get integer at position 3: " + listOfInterger.get(3));
            System.out.println("-----------");
            System.out.println("Remove integer at position 7");

            System.out.println("-----------");
        } catch (IndexOutOfBoundsException e) {
        }
        listOfInterger.remove(7);
        System.out.println(listOfInterger);

        try {
            System.out.println("add (98) at position 78 ");
            listOfInterger.addAt(98, 78);
        } catch (IndexOutOfBoundsException e) {

        }
        System.out.println(listOfInterger.toString());
        Iterator<Integer> iterator = listOfInterger.iterator();
        while (iterator.hasNext()) {
            System.out.println("ArrayIntList next " + iterator.next());
        }
    }

    private static void intstacktest() {

        ArrayIntStack arrayIntStack = new ArrayIntStack();

        System.out.println("\n**************\n");
        System.out.println("Add integer to the top of Stack 1st time 879");
        arrayIntStack.push(879);
        System.out.println("Stack status empty: " + arrayIntStack.isEmpty());
        System.out.println("Stack pop: " + arrayIntStack.pop());
        System.out.println("size is: " + arrayIntStack.size());
        try {
            System.out.println("Stack pop: " + arrayIntStack.pop());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Cant pop Stack empty");
        }
        try {
            System.out.println("Stack peek: " + arrayIntStack.peek());
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Cant peek Stack empty");
        }

        System.out.println("Add integer to the top of Stack 2st time 532");
        arrayIntStack.push(532);
        System.out.println("size is: " + arrayIntStack.size());
        System.out.println("Return the top integer: " + arrayIntStack.peek());
        arrayIntStack.push(987);
        Iterator<Integer> iterator = arrayIntStack.iterator();
        while (iterator.hasNext()) {
            System.out.println("ArrayIntStack next " + iterator.next());
        }
        System.out.println(arrayIntStack.toString());

    }

    public static void main(String[] args) {
        arrayintlisttest();
        intstacktest();
    }

}
