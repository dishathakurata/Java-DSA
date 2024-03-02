package recursion;

/*
 * 6. Write a Program to implement Binary Search using a recursive function.
 */

public class Prog6 {
	
	static int binarySearch(int[] arr, int l, int r, int x) {
  
        if(r >= l && l <= arr.length - 1) {
            int mid = l + (r - l) / 2;
 
            if(arr[mid] == x)
                return mid;

            if (arr[mid] > x)
                return binarySearch(arr, l, mid - 1, x);
 
            return binarySearch(arr, mid + 1, r, x);
        }
 
        return -1;
    }

	public static void main(String[] args) {
		
		int array[] = {2, 4, 5, 6, 9};
		int n = 5;
		int size = array.length;
		
		int res = binarySearch(array, 0, size - 1, n);
		
		if(res == -1)
			System.out.println("Element not found");
		
		else
			System.out.println("Element found at index " + res);
	}
}
