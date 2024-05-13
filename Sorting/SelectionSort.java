package sorting;

/*
 * 1. Write functions for each of the following sorting techniques (show the result after each iteration)
 * a. Selection
 */

public class SelectionSort<T extends Comparable<T>> {
	
	void selectionSort(T[] array) {
		int n = 1;
		
		for(int i = 0; i < array.length - 1; i++) {
			int min_index = i;
			
			for(int j = i + 1; j < array.length; j++) {
				if(array[j].compareTo(array[min_index]) < 0) {
					min_index = j;
	            }
	        }

			if(min_index != i) {
				 T temp = array[min_index];   
				 array[min_index] = array[i];  
				 array[i] = temp;
			}
			
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
        SelectionSort<Integer> intSort = new SelectionSort<>();
        System.out.println("Original integer array:");
        
        for(int el : intArray) {
        	System.out.print(el + ",");
        }
        System.out.println();
        
        intSort.selectionSort(intArray);
        System.out.println("\nSorted integer array using Selection sort:");
        
        for(int el : intArray) {
        	System.out.print(el + ", ");
        }
        System.out.println();
	}
}
