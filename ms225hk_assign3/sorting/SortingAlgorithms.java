package ms225hk_assign3.sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.NoSuchElementException;

public class SortingAlgorithms {

    public static void main(String[] args) {

        SortingAlgorithms sa = new SortingAlgorithms();

        int[] arr = {76, -56, 35, -16, 1, 55, 21, -6};
        int[] sortedIntArr = sa.insertionSort(arr);
        System.out.println("Sorted integers Array with insertion sort: ");
        for (int i : sortedIntArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        SortingAlgorithms sa2 = new SortingAlgorithms();
        int[] newSortedArr = sa.mergeSort(arr);
        System.out.println("Sorted integers Array with merge sort: ");
        for (int i : newSortedArr) {
            System.out.print(i + " ");
        }
        System.out.println();

        Comparator<String> comp = String::compareTo;
        String[] str = {"life", "is", "really", "simple", "but", "we", "insist", "on", "making", "it", "complicated"};
        String[] sortedStringArr = sa.insertionSort(str, comp);
        System.out.println("Sorted string array in alphabetical order: ");
        for (String s : sortedStringArr) {
            System.out.print(s + " ");
        }

        System.out.println();
        String[] str1 = {"carl", "adam", "been", "david", "frederik", "erik"};
        String[] sortPrint = mergeSort(str1, comp);
        System.out.println("Sorted: " + Arrays.toString(sortPrint));


    }

    // VG Exercise
    static String[] mergeSort(String[] in, Comparator<String> c) {
        if (in.length == 0)
            throw new NoSuchElementException();
        else if (in.length == 1)
            return in;
        else {
            //create two arrays and copy values
            String[] left = new String[in.length / 2];
            String[] rigth = new String[in.length - left.length];
            System.arraycopy(in, 0, left, 0, in.length / 2);
            System.arraycopy(in, in.length / 2, rigth, 0, in.length - left.length);
            //calling merge to both sides
            return merge(mergeSort(left, c), mergeSort(rigth, c), in);
        }
    }

    private static String[] merge(String[] left, String[] right, String[] in) {
        int l1 = 0;
        int r1 = 0;
        int n = 0;
        //comparing
        while (l1 < left.length && r1 < right.length)
            if (left[l1].compareTo(right[r1]) < 0) {
                in[n] = left[l1];
                l1++;
                n++;
            } else {
                in[n] = right[r1];
                r1++;
                n++;
            }
        //putting the leftovers to the in array
        while (l1 < left.length) {
            in[n] = left[l1];
            l1++;
            n++;
        }
        while (r1 < right.length) {
            in[n] = right[r1];
            r1++;
            n++;
        }
        return in;
    }

    //https://www.geeksforgeeks.org/insertion-sort/
    int[] insertionSort(int[] in) {
        int n = in.length;
        int[] newTemp = new int[n];
        System.arraycopy(in, 0, newTemp, 0, n);

        for (int i = 1; i < n; ++i) {
            int key = newTemp[i];
            int j = i - 1;
            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && newTemp[j] > key) {
                newTemp[j + 1] = newTemp[j];
                j = j - 1;
            }
            newTemp[j + 1] = key;
        }
        return newTemp;
    }

    String[] insertionSort(String[] in, Comparator<String> c) {
        int n = in.length;
        String[] newTemp = new String[n];
        System.arraycopy(in, 0, newTemp, 0, n);


        for (int i = 1; i < n; i++) {
            String temp = newTemp[i];
            int pos = i;
            while (pos > 0 && c.compare(newTemp[pos - 1], temp) > 0) {
                newTemp[pos] = newTemp[pos - 1];
                pos = pos - 1;
            }
            newTemp[pos] = temp;
        }
        return newTemp;
    }

    int[] mergeSort(int[] in) {
        MergeSort ob = new MergeSort();
        int[] tmp = new int[in.length];
        System.arraycopy(in, 0, tmp, 0, in.length);
        ob.sort(tmp, 0, tmp.length - 1);
        return tmp;
    }

    // https://www.geeksforgeeks.org/merge-sort/
    private class MergeSort {
        // Merges two subarray of arr[].
        // First subarray is arr[l..m]
        // Second subarray is arr[m+1..r]
        private void merge(int[] arr, int l, int m, int r) {
            // Find sizes of two subarray to be merged
            int n1 = m - l + 1;
            int n2 = r - m;

            /* Create temp arrays */
            int[] L = new int[n1];
            int[] R = new int[n2];

            /*Copy data to temp arrays*/
            System.arraycopy(arr, l, L, 0, n1);
            for (int j = 0; j < n2; ++j)
                R[j] = arr[m + 1 + j];

            /* Merge the temp arrays */

            // Initial indexes of first and second subarray
            int i = 0, j = 0;

            // Initial index of merged subarray array
            int k = l;
            while (i < n1 && j < n2) {
                if (L[i] <= R[j]) {
                    arr[k] = L[i];
                    i++;
                } else {
                    arr[k] = R[j];
                    j++;
                }
                k++;
            }

            /* Copy remaining elements of L[] if any */
            while (i < n1) {
                arr[k] = L[i];
                i++;
                k++;
            }

            /* Copy remaining elements of R[] if any */
            while (j < n2) {
                arr[k] = R[j];
                j++;
                k++;
            }
        }

        // Main function that sorts arr[l..r] using
        // merge()
        private void sort(int[] arr, int l, int r) {
            if (l < r) {
                // Find the middle point
                int m = (l + r) / 2;

                // Sort first and second halves
                sort(arr, l, m);
                sort(arr, m + 1, r);

                // Merge the sorted halves
                merge(arr, l, m, r);
            }
        }
    }

}