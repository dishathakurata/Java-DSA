package array;

import java.util.Scanner;

/*
 * 1. Create a Class Search within that implement two Generic method LinearSearch(),
BinarySearch(). Test your program for different data.
 */

class Search<T extends Comparable<T>> {

	public boolean linearSearch(T[] array,T ele) {
		for(int i=0;i<array.length;i++) {
			if(array[i].compareTo(ele)==0) {
				return true;
			}
		}
		return false;
	}
	
	public boolean binarySearch(T[] array,T ele) {
		int l=0;
		int r=array.length-1;
		
		while(l<=r) {
			int mid=(l+r)/2;
			
			if(array[mid].compareTo(ele)==0) {
				return true;
			}
			else {
				if(array[mid].compareTo(ele)<0)
					l=mid+1;
				else if(array[mid].compareTo(ele)>0)
					r=mid-1;
			}
		}
		return false;
	}
	
	public static void Search(String[] args) {
		System.out.println("1. Linear Search"+"\n2. Binary Search"+"\nEnter your choice: ");
		Scanner sc=new Scanner(System.in);
		int ch=sc.nextInt();
		switch(ch) {
		case 1:
			System.out.println("1. Integer"+"\n2. String"+"\nEnter you choice: ");
			int chf=sc.nextInt();
			switch(chf) {
			case 1:
				Search<Integer> intSearch=new Search<>();
				
		        Integer[] intArrayLinear={4,6,2,8,5,1,9};
		        int intElementLinear=5;
		        System.out.println("Linear Search - Integer:");
		        if(intSearch.linearSearch(intArrayLinear,intElementLinear))
		        	System.out.println("Element found");
		        else
		        	System.out.println("Element not found");
		        break;
		        
			case 2:
				Search<String> stringSearch = new Search<>();
		        
		        String[] stringArrayLinear={"B","C","A","D"};
		        String stringElementLinear="A";
		        System.out.println("Linear Search - String:");
		        if(stringSearch.linearSearch(stringArrayLinear,stringElementLinear))
		        	System.out.println("Element found");
		        else
		        	System.out.println("Element not found");
		        break;
			}
			break;
			
		case 2:
			System.out.println("1. Integer"+"\n2. String"+"\nEnter you choice: ");
			int chs=sc.nextInt();
			switch(chs) {
			case 1:
				Search<Integer> intSearch=new Search<>();
				
				Integer[] intArrayBinary={1,2,3,4,5,6,7,8,9};
		        int intElementBinary=8;
		        System.out.println("Binary Search - Integer:");
		        if(intSearch.binarySearch(intArrayBinary,intElementBinary))
		        	System.out.println("Element found");
		        else
		        	System.out.println("Element not found");
		        break;
		        
			case 2:
				Search<String> stringSearch = new Search<>();
				
				String[] stringArrayBinary={"A","B","C","D"};
		        String stringElementBinary="C";
		        System.out.println("Binary Search - String:");
		        if(stringSearch.binarySearch(stringArrayBinary,stringElementBinary))
		        	System.out.println("Element found");
		        else
		        	System.out.println("Element not found");
		        break;
			}
			break;
			
		default: System.out.println("Enter valid choice");
		}
	}
}