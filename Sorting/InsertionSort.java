package sorting;

/*
 * 1. Write functions for each of the following sorting techniques (show the result after each iteration)
 * b. Insertion
 */

public class InsertionSort<T extends Comparable<T>> {
	
	void insertionSort(T[] array) {
		int n = 1;
		
        for(int i = 1; i < array.length; i++) {
            T key = array[i];
            int j = i - 1;
            
            while(j >= 0 && array[j].compareTo(key) > 0) {
                array[j + 1] = array[j];
                j--;
            }
            
            array[j + 1] = key;
            
            System.out.println("\nArray after iteration " + n + ": ");
			for(T el : array) {
				System.out.print(el + ",");
			}
			System.out.println();
			n++;
        }
	}

	public static void main(String[] args) {
		Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
        InsertionSort<Integer> intSort=new InsertionSort<>();
        
        System.out.println("Original integer array:");
        for(int el : intArray) {
        	System.out.print(el + ",");
        }
        System.out.println();
        
        intSort.insertionSort(intArray);
        System.out.println("\nSorted integer array using Insertion sort:");
        for(int el : intArray) {
        	System.out.print(el + ", ");
        }
        System.out.println();
	}

}
