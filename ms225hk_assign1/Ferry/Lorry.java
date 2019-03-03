package ms225hk_assign1.Ferry;

public class Lorry extends Vehicle {

    public Lorry(int id) {
        super(id, 2);
        super.setSpace(40);                        // Lorry size = 40
        super.setFee(300);                        // 300 kr lorry fee
        super.setPassengerFee(20);

    }

    @Override
    public String toString() {
        return "Lorry, id " + super.getId();
    }
}
