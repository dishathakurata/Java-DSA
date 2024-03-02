package recursion;

/*
 * 7. Write a Program to reverse an array using a recursive function.
 */

public class Prog7 {
	
	static void reverseArray(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

        reverseArray(arr, start + 1, end - 1);
    }

	public static void main(String[] args) {
		int[] array = {2, 3, 7, 1, 6};
		
		System.out.print("Original array: ");
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
		
		reverseArray(array, 0, array.length - 1);
		System.out.print("\nArray after reversing: ");
		for(int i = 0; i < array.length; i++)
			System.out.print(array[i] + " ");
	}
}
