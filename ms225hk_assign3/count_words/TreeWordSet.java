package ms225hk_assign3.count_words;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TreeWordSet implements WordSet {

    private int size = 0;
    private BST root = null;
    private int count = 0;
    private Word[] arr = new Word[8];

    @Override
    public void add(Word word) {
        if (root == null) {
            root = new BST(word); //Create a new tree if root doesnt exist
            size++;
        } else {
            root.add(word); //add the word to a new branch
        }
    }

    @Override
    public boolean contains(Word word) {
        return root.contains(word);
    }

    @Override
    public int size() {
        return size;
    }

    private void resize() {
        Word[] temp = new Word[arr.length * 2];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        arr = temp;
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Word> iterator() {
        return new TreeIte();
    }

    public String toString() {
        return root.print();
    }

    private class BST { // private inner class
        Word value;
        private BST left = null;
        private BST right = null;

        BST(Word val) {
            value = val;
        }

        void add(Word w) { // recursive add
            if (w.compareTo(value) < 0) { // add to left branch
                if (left == null) {
                    left = new BST(w);
                    size++;
                } else
                    left.add(w); // Recursive call
            } else if (w.compareTo(value) > 0) { // add to right branch
                if (right == null) {
                    right = new BST(w);
                    size++;
                } else
                    right.add(w); // Recursive call
            }
        }

        private String print() {
            String str = null;
            if (left != null) // visit left child
                left.print();
            str += " " + value;
            if (right != null) // visit right child
                right.print();
            return str;
        }

        private boolean contains(Word w) { // recursive look−up
            if (w.compareTo(value) < 0) { // search left branch
                if (left == null)
                    return false;
                else
                    return left.contains(w);
            } else if (w.compareTo(value) > 0) { // search right branch
                if (right == null)
                    return false;
                else
                    return right.contains(w);
            }
            return true; // Found!
        }

        // save elements to array
        private void WordtoArray() {
            if (left != null)
                left.WordtoArray();
            if (count == arr.length)
                resize();
            arr[count] = value;
            count++;
            if (right != null)
                right.WordtoArray();
        }
    }

    private class TreeIte implements Iterator<Word> {
        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        private int count = 0;

        TreeIte() {
            root.WordtoArray();
        }

        @Override
        public boolean hasNext() {
            if (root == null)
                return false;
            else return arr[count] != null;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Word next() {
            return arr[count++];
        }
    }

}