package sorting;

import java.util.*;

/*
 * 3. Write functions for each of the following sorting techniques
 * a. Radix
 */

public class RadixSort<T extends Comparable<T>> {

    public void radixSort(T[] arr) {
        T max = arr[0];
        
        for(int i = 1; i < arr.length; i++) {
            if(arr[i].compareTo(max) > 0)
                max = arr[i];
        }

        for(int exp = 1; ((Integer) max).intValue() / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    private void countingSort(T[] arr, int exp) {
        int n = arr.length;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for(int i = 0; i < n; i++) {
            count[((Integer) arr[i]).intValue() / exp % 10]++;
        }

        for(int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        T[] output = Arrays.copyOf(arr, n);
        
        for(int i = n - 1; i >= 0; i--) {
            output[count[((Integer) arr[i]).intValue() / exp % 10] - 1] = arr[i];
            count[((Integer) arr[i]).intValue() / exp % 10]--;
        }

        System.arraycopy(output, 0, arr, 0, n);
    }

    public void printArray(T[] arr) {
        for(T t : arr) {
            System.out.print(t + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RadixSort<Integer> radixSort = new RadixSort<>();
        Integer[] arr = {3, 6, 1, 8, 5, 7, 2};
        System.out.println("Original array:");
        radixSort.printArray(arr);
        radixSort.radixSort(arr);
        System.out.println("Sorted array:");
        radixSort.printArray(arr);
    }
}