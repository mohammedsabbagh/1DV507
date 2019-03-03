package ms225hk_assign1.Ferry;


public class Bicycle extends Vehicle {

    public Bicycle(int id) {
        super(id, 1);
        super.setSpace(1);                        // bicycle size = 1.
        super.setFee(15);                        // 15 kr (passenger not included)
        super.setPassengerFee(25);      // passenger with bike

    }

    @Override
    public String toString() {
        return "Bicycle, id " + super.getId();
    }
}
