package array;

import java.util.Scanner;

/*
 * 2. Create a Class BasicSort within that implement three Generic methods that can implement the
BuubleSort(), SelectionSort(), InsertionSort() that can sort of any type of data.
 */

class BasicSort<T extends Comparable<T>> {
	
	void bubbleSort(T[] array) {
        for(int i=0;i<array.length;i++) {
        	for(int j=1;j<(array.length-i);j++) {
        		if(array[j-1].compareTo(array[j])>0) {
        			T temp=array[j-1];
                    array[j-1]=array[j];
                    array[j]=temp;  
                 }  
             }
        }
	}
	
	void selectionSort(T[] array) {
		for(int i=0;i<array.length-1;i++) {
			int min_index=i;
			for(int j=i+1;j<array.length;j++) {
				if(array[j].compareTo(array[min_index])<0) {
					min_index=j;  
	            }  
	         }
			 if(min_index!=i) {
				 T temp=array[min_index];   
				 array[min_index]=array[i];  
				 array[i]=temp;				 
			 }
	    }  
	}
	
	void insertionSort(T[] array) {  
        for(int i=1;i<array.length;i++) {
            T key=array[i];
            int j=i-1;
            while(j>=0 && array[j].compareTo(key)>0) {
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=key;
        }
	}
	
	public static void main(String[] args) {
		System.out.print("1. Bubble Sort"+"\n2. Selection Sort"+"\n3. Insertion Sort"+"\nEnter your choice: ");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.print("\n1. Integer"+"\n2. String"+"\nEnter your choice: ");
			int chf=sc.nextInt();
			switch(chf) {
			case 1:
				Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
		        BasicSort<Integer> intSort=new BasicSort<>();
		        System.out.println("\nOriginal integer array:");
		        for(int el:intArray) {
		        	System.out.print(el+",");
		        }
		        intSort.bubbleSort(intArray);
		        System.out.println("\nSorted integer array using Bubble sort:");
		        for(int el:intArray) {
		        	System.out.print(el+", ");
		        }
		        System.out.println();
		        break;
			
			case 2:
				String[] stringArray={"B","D","A","C"};
				BasicSort<String> stringSort=new BasicSort<>();
				System.out.println("\nOriginal string array: ");
				for(String els:stringArray) {
					System.out.print(els+", ");
				}
				stringSort.bubbleSort(stringArray);
				System.out.println("\nSorted string array using Bubble sort:");
				for(String els:stringArray) {
					System.out.print(els+", ");
				}
				System.out.println();
				break;
			}
			break;
			
		case 2:
			System.out.print("\n1. Integer"+"\n2. String"+"\nEnter your choice: ");
			int chs=sc.nextInt();
			switch(chs) {
			case 1:
				Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
		        BasicSort<Integer> intSort=new BasicSort<>();
		        System.out.println("\nOriginal integer array:");
		        for(int el:intArray) {
		        	System.out.print(el+",");
		        }
		        intSort.selectionSort(intArray);
		        System.out.println("\nSorted integer array using Selection sort:");
		        for(int el:intArray) {
		        	System.out.print(el+", ");
		        }
		        System.out.println();
		        break;
		        
			case 2:
				String[] stringArray={"B","D","A","C"};
				BasicSort<String> stringSort=new BasicSort<>();
				System.out.println("\nOriginal string array: ");
				for(String els:stringArray) {
					System.out.print(els+", ");
				}
				stringSort.selectionSort(stringArray);
				System.out.println("\nSorted string array using Selection sort:");
				for(String els:stringArray) {
					System.out.print(els+", ");
				}
				System.out.println();
				break;
			}
			break;
			
		case 3:
			System.out.print("\n1. Integer"+"\n2. String"+"\nEnter your choice: ");
			int cht=sc.nextInt();
			switch(cht) {
			case 1:
				Integer[] intArray = {64, 34, 25, 12, 22, 11, 90};
		        BasicSort<Integer> intSort=new BasicSort<>();
		        System.out.println("\nOriginal integer array:");
		        for(int el:intArray) {
		        	System.out.print(el+",");
		        }
		        intSort.insertionSort(intArray);
		        System.out.println("\nSorted integer array using Insertion sort:");
		        for(int el:intArray) {
		        	System.out.print(el+", ");
		        }
		        System.out.println();
		        break;
		        
			case 2:
				String[] stringArray={"B","D","A","C"};
				BasicSort<String> stringSort=new BasicSort<>();
				System.out.println("\nOriginal string array: ");
				for(String els:stringArray) {
					System.out.print(els+", ");
				}
				stringSort.insertionSort(stringArray);
				System.out.println("\nSorted string array using Insertion sort:");
				for(String els:stringArray) {
					System.out.print(els+", ");
				}
				System.out.println();
				break;
			}
			break;
			
		default: System.out.println("Enter valid choice");
		}
	}
}
