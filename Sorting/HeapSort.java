package sorting;

/*
 * 3. Write functions for each of the following sorting techniques
 * b. Heap sort
 */

public class HeapSort<T extends Comparable<T>> {

    public void heapSort(T[] arr) {
        int n = arr.length;

        for(int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        for(int i = n - 1; i > 0; i--) {
            T temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
    }

    void heapify(T[] arr, int n, int i) {
        int largest = i;
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        if(l < n && arr[l].compareTo(arr[largest]) > 0)
            largest = l;

        if(r < n && arr[r].compareTo(arr[largest]) > 0)
            largest = r;

        if(largest != i) {
            T swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }

    public void printArray(T[] arr) {
        int n = arr.length;
        for(int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        HeapSort<Integer> heapSort = new HeapSort<>();
        Integer[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Original array:");
        heapSort.printArray(arr);
        heapSort.heapSort(arr);
        System.out.println("Sorted array:");
        heapSort.printArray(arr);
    }
}