package ms225hk_assign1.Ferry;

public class Bus extends Vehicle {

    public Bus(int id) {
        super(id, 20);
        super.setSpace(20);                        // Bus size = 1.
        super.setFee(200);                        // 200 kr buss fee
        super.setPassengerFee(15);


    }

    @Override
    public String toString() {
        return "Bus, id " + super.getId();
    }
}
