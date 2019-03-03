package ms225hk_assign1.Ferry;

public abstract class Vehicle {
    private int id; // Id for each vehicle
    private int passengersMax;
    private int passengersCount = 0; // passengers count
    private int passengerFee = 0; // passengers count
    private int space; // using bicycle as unit (5 Bicycle 1 car and so on)
    private int fee; // how much is the fee for the vehicle


    public Vehicle(int id, int passengersMax) { // constructor has id parameter//
        this.id = id;
        this.passengersMax = passengersMax;
    }


    public int getId() {
        return id;
    }

    public int getFee() {
        return this.fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public boolean hasRoom(int passengersCount) {
        return passengersCount <= passengersMax;
    }

    public void setSpace(int space) {
        this.space = space;
    }

    public int getPassengersCount() {
        return passengersCount;
    }

    public void setPassengersCount(int passengersCount) throws Exception {
        if (!hasRoom(passengersCount)) {
            throw new Exception("Overload");
        }
        this.passengersCount = passengersCount;
    }

    public int getTotalFee() {
        return fee + passengersCount * passengerFee;
    }

    public void setPassengerFee(int passengerFee) {
        this.passengerFee = passengerFee;
    }


    public int getSpace() {
        return space;
    }


    public abstract String toString();
}
