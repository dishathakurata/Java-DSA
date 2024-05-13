package sorting;

import java.util.Arrays;

/*
 * 2. Write functions for each of the following sorting techniques
 * a. Quick
 */

public class QuickSort<T extends Comparable<T>> {

    public void sort(T[] arr) {
        if(arr == null || arr.length == 0) {
            return;
        }

        quickSort(arr, 0, arr.length - 1);
    }

    private void quickSort(T[] arr, int low, int high) {
        if(low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    private int partition(T[] arr, int low, int high) {
        T pivot = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++) {
            if(arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, high);

        return i + 1;
    }

    private void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Character[] arr = {'d', 'i', 's', 'h', 'a'};
        QuickSort<Character> qSort = new QuickSort<>();
        
        qSort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}