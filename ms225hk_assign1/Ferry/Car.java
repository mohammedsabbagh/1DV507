package ms225hk_assign1.Ferry;

public class Car extends Vehicle {

    public Car(int id) {
        super(id, 4);
        super.setSpace(5);                        // Car size = 5
        super.setFee(100);                        // 100 kr car fee
        super.setPassengerFee(20);
    }

    @Override
    public String toString() {
        return "Car, id " + super.getId();
    }
}
