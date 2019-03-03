package ms225hk_assign1.intCollection;

public class ArrayIntStack extends AbstractIntCollection implements IntStack {

    @Override
    public void push(int n) {
        if (values.length == size) {
            resize();
        }
        values[size++] = n;
    }

    @Override
    public int pop() throws IndexOutOfBoundsException {
        if (super.isEmpty()) {
            throw new IndexOutOfBoundsException("Stack empty");
        }
        return values[--size];
    }

    @Override
    public int peek() throws IndexOutOfBoundsException {
        if (super.isEmpty()) {
            throw new IndexOutOfBoundsException();
        }
        return values[size - 1];
    }

}
