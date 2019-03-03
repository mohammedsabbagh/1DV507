package ms225hk_assign1.intCollection;

import java.util.Iterator;

public class ArrayIntList extends AbstractIntCollection implements IntList {

    @Override
    public void add(int n) {
        if (super.size == super.values.length) // full list
            resize(); // list 16

        values[size++] = n; // add integer to the array.
    }

    @Override
    public void addAt(int n, int index) throws IndexOutOfBoundsException {

        if (!checkIndex(index, values.length))
            throw new IndexOutOfBoundsException();
        if (size + 1 > values.length)
            resize();
        System.arraycopy(values, index, values, index + 1, size - index); // shift all element to the right from index
        values[index] = n;       // add the integer to specific index
        size++;
    }

    @Override
    public void remove(int index) throws IndexOutOfBoundsException {

        if (checkIndex(index, values.length)) {
            for (int i = index; i < super.size() - 1; i++) {
                values[i] = values[i + 1];
            }
            size--;
        } else {
            throw new IndexOutOfBoundsException();
        }

    }

    @Override
    public int get(int index) throws IndexOutOfBoundsException {

        if (checkIndex(index, values.length)) {
            return values[index];
        } else {
            throw new IndexOutOfBoundsException();

        }
    }

    @Override
    public int indexOf(int n) {

        Iterator<Integer> indexOfiterator = super.iterator();
        for (int i = 0; i < super.size(); i++) {
            if (n == indexOfiterator.next()) {
                return i;
            }
        }
        return -1;
    }

}