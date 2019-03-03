package ms225hk_assign3.count_words;

import java.util.Iterator;

public class HashWordSet implements WordSet {

    private int sz; // Current size
    private Node[] buckets = new Node[8];

    private int getBucketNumber(Word word) {
        int hc = word.hashCode();                // Use hashCode() from String class
        if (hc < 0) {
            hc = -hc;
        }             // Make sure non−negative
        return hc % buckets.length;    // Simple hash function
    }

    private void rehash() {
        Node[] temp = buckets; // Copy of old buckets
        buckets = new Node[2 * temp.length];   // New empty buckets
        sz = 0;
        for (Node n : temp) { // Insert old values into new buckets
            if (n == null) continue; // Empty bucket
            while (n != null) {
                add(n.value); // Add elements again
                n = n.next;
            }
        }
    }

    @Override
    public void add(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos]; // First node in list
        while (node != null) { // Search list
            if (node.value.equals(word))
                return; // Element found ==> return
            else
                node = node.next; // Next node in list

        }
        node = new Node(word); // Not found, add new node as first entry
        node.next = buckets[pos];
        buckets[pos] = node;
        sz++;
        if (sz == buckets.length) rehash(); // Rehash if needed
    }

    @Override
    public boolean contains(Word word) {
        int pos = getBucketNumber(word);
        Node node = buckets[pos];
        while (node != null) { // Search list for element
            if (node.value.equals(word))
                return true; // Found!
            else
                node = node.next;
        }
        return false; // Not found
    }

    @Override
    public int size() {
        return sz;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("HASH: ");
        for (Node bucket : buckets) {
            Node node = bucket;
            while (node != null) {
                str.append(node.value).append(" ");
                node = node.next;
            }
        }
        return str.toString();
    }

    /**
     * Returns an iterator over elements of type {@code T}.
     *
     * @return an Iterator.
     */
    @Override
    public Iterator<Word> iterator() {
        return new HashIte();
    }

    private class Node { // Private inner classes
        Word value;
        Node next = null;

        Node(Word word) {
            value = word;
        }
    }

    private class HashIte implements Iterator<Word> {
        private int pos;
        private HashWordSet.Node node;

        HashIte() {
            pos = -1; //beginning
            node = null;
        }

        /**
         * Returns {@code true} if the iteration has more elements.
         * (In other words, returns {@code true} if {@link #next} would
         * return an element rather than throwing an exception.)
         *
         * @return {@code true} if the iteration has more elements
         */
        @Override
        public boolean hasNext() {
            if (node != null && node.next != null) {
                return true;
            }

            for (int i = pos + 1; i < buckets.length; i++) {
                if (buckets[i] != null) {
                    return true;
                }
            }
            return false;
        }

        /**
         * Returns the next element in the iteration.
         *
         * @return the next element in the iteration
         */
        @Override
        public Word next() {
            if (node == null || node.next == null) {
                pos++;
                while (buckets[pos] == null) { // check next bucket if empty or not
                    pos++;
                }
                node = buckets[pos];
            } else {
                node = node.next; // jump to next one
            }
            return node.value;
        }
    }
}