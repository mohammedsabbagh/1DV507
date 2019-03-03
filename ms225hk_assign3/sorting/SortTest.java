package ms225hk_assign3.sorting;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static ms225hk_assign3.sorting.SortingAlgorithms.mergeSort;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTest {
    private static int testCounts = 0;


    @BeforeEach
    void setUp() {
        testCounts++;
        System.out.print("Test: " + testCounts + ": ");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Test pass");
    }


    @Test
    void testInsertionSortIntArray() {

        SortingAlgorithms sa = new SortingAlgorithms();

        int[] arr1 = {78, -56, 35, -16, 1, 55, 21, -6};
        int[] sortedIntArr = sa.insertionSort(arr1);
        assertEquals("[-56, -16, -6, 1, 21, 35, 55, 78]", Arrays.toString(sortedIntArr));
        int[] arr2 = {298};
        sortedIntArr = sa.insertionSort(arr2);
        assertEquals("[298]", Arrays.toString(sortedIntArr));
        int[] arr3 = {7, 7, 7, 7, 7};
        sortedIntArr = sa.insertionSort(arr3);
        assertEquals("[7, 7, 7, 7, 7]", Arrays.toString(sortedIntArr));
        int[] arr4 = {77, 54, 54, 54, 98, -68};
        sortedIntArr = sa.mergeSort(arr4);
        assertEquals("[-68, 54, 54, 54, 77, 98]", Arrays.toString(sortedIntArr));
    }

    @Test
    void testMergeSortIntArray() {
        SortingAlgorithms sa = new SortingAlgorithms();

        int[] arr1 = {98, -49, 37, -18, 8, 61, 25, -89};
        int[] sortedIntArr = sa.mergeSort(arr1);
        assertEquals("[-89, -49, -18, 8, 25, 37, 61, 98]", Arrays.toString(sortedIntArr));
        int[] arr2 = {859};
        sortedIntArr = sa.mergeSort(arr2);
        assertEquals("[859]", Arrays.toString(sortedIntArr));
        int[] arr3 = {589, 589, 589, 589, 589};
        sortedIntArr = sa.mergeSort(arr3);
        assertEquals("[589, 589, 589, 589, 589]", Arrays.toString(sortedIntArr));
        int[] arr4 = {189, 189, 234, 54, 786, -5};
        sortedIntArr = sa.mergeSort(arr4);
        assertEquals("[-5, 54, 189, 189, 234, 786]", Arrays.toString(sortedIntArr));
    }

    @Test
    void testInsertionSortStringArrayComparatorOfString() {
        SortingAlgorithms sa = new SortingAlgorithms();
        Comparator<String> comp = String::compareTo;

        String[] str1 = {"desolately", "baby", "cries", "A"};
        String[] sortedStringArr = sa.insertionSort(str1, comp);
        assertEquals("[A, baby, cries, desolately]", Arrays.toString(sortedStringArr));
        String[] str2 = {"brownish", "descends", "every", "friday", "A", "cloud"};
        sortedStringArr = sa.insertionSort(str2, comp);
        assertEquals("[A, brownish, cloud, descends, every, friday]", Arrays.toString(sortedStringArr));
        String[] str3 = {"Mohammed", "Ibrahim", "Mohammed", "Sabbagh"};
        sortedStringArr = sa.insertionSort(str3, comp);
        assertEquals("[Ibrahim, Mohammed, Mohammed, Sabbagh]", Arrays.toString(sortedStringArr));
        String[] str4 = {"Mohammed"};
        sortedStringArr = sa.insertionSort(str4, comp);
        assertEquals("[Mohammed]", Arrays.toString(sortedStringArr));
    }

    @Test
    void testMergeSortStringArrayComparatorOfString() {
        Comparator<String> comp = String::compareTo;

        String[] str = {"1", "", "sabbagh", "Mohammed", "Ibrahim", "Mohammed", "Sabbagh",};
        String[] sortPrint = mergeSort(str, comp);
        assertEquals("[, 1, Ibrahim, Mohammed, Mohammed, Sabbagh, sabbagh]", Arrays.toString(sortPrint));

    }
}