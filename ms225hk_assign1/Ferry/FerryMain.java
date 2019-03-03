package ms225hk_assign1.Ferry;

import java.util.Iterator;

public class FerryMain {

    public static void main(String[] args) {
        Ferry ferry = new FerryImplement();


        for (int i = 0; i < 50; i++) {
            Passenger p = new Passenger();
            ferry.embark(p);
        }

        embarkCar(ferry, 1, 4);
        System.out.println(ferry.toString());
        embarkBus(ferry, 8, 13);
        System.out.println(ferry.toString());
        embarkBus(ferry, 2, 10);
        System.out.println(ferry.toString());
        embarkLorry(ferry, 3, 2);
        System.out.println(ferry.toString());
        embarkLorry(ferry, 4, 1);
        System.out.println(ferry.toString());
        embarkLorry(ferry, 5, 2);
        System.out.println(ferry.toString());
        embarkLorry(ferry, 6, 2);
        System.out.println(ferry.toString());
        embarkBicycle(ferry, 7, 1);
        System.out.println(ferry.toString());

        Iterator<Vehicle> iterator = ferry.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().toString());
        }

        embarkCar(ferry, 2, 5);
        embarkCar(ferry, 1, 3);
        embarkBus(ferry, 3, 16);
        embarkBus(ferry, 1, 8);
        embarkLorry(ferry, 1, 2);
        embarkLorry(ferry, 3, 3);
        embarkBicycle(ferry, 2, 2);
        embarkBicycle(ferry, 1, 1);


        System.out.println(ferry.toString());

    }

    private static void embarkCar(Ferry ferry, int id, int passengersCount) {
        Vehicle v1 = new Car(id);
        try {
            v1.setPassengersCount(passengersCount);
        } catch (Exception e) {
            System.out.println("Car is " + e.getMessage());
            return;
        }
        ferry.embark(v1);
    }

    private static void embarkBus(Ferry ferry, int id, int passengersCount) {
        Vehicle v2 = new Bus(id);
        try {
            v2.setPassengersCount(passengersCount);
        } catch (Exception e) {
            System.out.println("Bus is " + e.getMessage());
            return;
        }
        ferry.embark(v2);
    }

    private static void embarkLorry(Ferry ferry, int id, int passengersCount) {
        Vehicle v3 = new Lorry(id);
        try {
            v3.setPassengersCount(passengersCount);
        } catch (Exception e) {
            System.out.println("Lorry is " + e.getMessage());
            return;
        }
        ferry.embark(v3);
    }

    private static void embarkBicycle(Ferry ferry, int id, int passengersCount) {
        Vehicle v4 = new Bicycle(id);
        try {
            v4.setPassengersCount(passengersCount);
        } catch (Exception e) {
            System.out.println("Bicycle is " + e.getMessage());
            return;
        }
        ferry.embark(v4);
    }


}
