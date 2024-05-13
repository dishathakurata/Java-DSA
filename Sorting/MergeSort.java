package sorting;

import java.util.*;

/*
 * 2. Write functions for each of the following sorting techniques
 * b. Merge
 */

public class MergeSort<T extends Comparable<T>> {

    public void mergeSort(T[] array) {
        if(array == null || array.length <= 1) {
            return;
        }
        
        mergeSort(array, 0, array.length - 1);
    }

    private void mergeSort(T[] array, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            mergeSort(array, left, mid);
            mergeSort(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(T[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        List<T> leftArray = new ArrayList<>();
        List<T> rightArray = new ArrayList<>();

        for(int i = 0; i < n1; i++) {
            leftArray.add(array[left + i]);
        }

        for(int j = 0; j < n2; j++) {
            rightArray.add(array[mid + 1 + j]);
        }

        int i = 0, j = 0, k = left;

        while(i < n1 && j < n2) {
            if(leftArray.get(i).compareTo(rightArray.get(j)) <= 0) {
                array[k] = leftArray.get(i);
                i++;
            }
            
            else {
                array[k] = rightArray.get(j);
                j++;
            }
            k++;
        }

        while(i < n1) {
            array[k] = leftArray.get(i);
            i++;
            k++;
        }

        while(j < n2) {
            array[k] = rightArray.get(j);
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        MergeSort<Integer> mSort = new MergeSort<>();
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        mSort.mergeSort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}