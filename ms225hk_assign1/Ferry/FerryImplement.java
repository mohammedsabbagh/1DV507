package ms225hk_assign1.Ferry;

import java.util.ArrayList;
import java.util.Iterator;

public class FerryImplement implements Ferry {

    private int maxPassenger = 200; //
    private int maxVehiclesSpace = 200; // we consider bicycle as unit so 1 bike = 5 cars
    private ArrayList<Vehicle> vehicleRegistration = new ArrayList<>();
    private ArrayList<Passenger> passengerRegistration = new ArrayList<>();
    private int totalMoney = 0;

    @Override
    public int countPassengers() {
        int counter = passengerRegistration.size();
        for (Vehicle vehicle : vehicleRegistration)
            counter += vehicle.getPassengersCount();

        return counter;

    }

    @Override
    public int countVehicleSpace() {
        int countVehicles = 0;
        for (Vehicle vehicleSpace : vehicleRegistration)
            countVehicles += vehicleSpace.getSpace();

        return countVehicles;
    }

    @Override
    public int countMoney() {
        return totalMoney;
    }

    @Override
    public Iterator<Vehicle> iterator() {
        return new Iterator<Vehicle>() {
            int index = 0;

            @Override
            public boolean hasNext() {
                return index < vehicleRegistration.size();
            }

            @Override
            public Vehicle next() {
                return vehicleRegistration.get(index++);
            }
        };
    }

    @Override
    public void embark(Vehicle v) {
        // check if there is not available space for vehicles
        if (!hasSpaceFor(v)) {
            System.err.println("no enough space to embark vehicle " + v.toString());
            return;
        }
        for (Vehicle ve : vehicleRegistration) // check if two vehicles have same ID.
            if (v.getId() == ve.getId()) {
                System.err.println("can not embark same vehicle, " + v.toString());
                return;
            }
        vehicleRegistration.add(v);
        totalMoney += v.getTotalFee();

    }

    @Override
    public void embark(Passenger p) {
        // check if there is not available space for passenger
        if (!hasRoomFor(p)) {
            System.err.println("no enough room to embark passenger " + p.toString());
            return;
        }

        passengerRegistration.add(p);
        totalMoney += p.getFee();
    }

    @Override
    public void disembark() {
        vehicleRegistration.clear();
        passengerRegistration.clear();
    }

    @Override
    public boolean hasSpaceFor(Vehicle v) {

        return countVehicleSpace() + v.getSpace() <= maxVehiclesSpace && v.getPassengersCount() + passengerRegistration.size() <= maxPassenger;
    }

    @Override
    public boolean hasRoomFor(Passenger p) {
        return countPassengers() + 1 <= maxPassenger;
    }

    @Override
    public String toString() {
        return ("Number of Passengers : " + countPassengers() + "\t") +
                "space used by Vehicles : " + countVehicleSpace() + "\t" +
                "Money Collected : " + countMoney();
    }

}
