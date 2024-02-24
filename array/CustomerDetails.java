package array;

import java.util.*;

/*
 * 7. Create a program with multi-dimensional List to store customer details (customerId,
customerName, customerCity).
This program to search the customer based on the customerName from a given array.
Note: use Binary search and Insertion sort algorithm.
 Create a constructor to initialize size of customer details for five customers.
 Create customer method which takes the array of customer elements (sorted as a
customerName).
 Create a method to getCustomer(customerId) method which will return the customer
details as a List.
 Create a method to sortCustomer() method which will return the array in a sorted
order based on customer city.
 */

class Customer {
	private String customerID;
	private String customerName;
	private String customerCity;

	public Customer(String customerID, String customerName, String customerCity) {
		this.customerID=customerID;
		this.customerName=customerName;
		this.customerCity=customerCity;
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID=customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName=customerName;
	}

	public String getCustomerCity() {
		return customerCity;
	}

	public void setCustomerCity(String customerCity) {
		this.customerCity=customerCity;
	}

}

class Record {
	Customer[] record;

	Record(int size) {
		this.record=new Customer[size];
	}

	Record() {
		this.record=new Customer[5];

		record[0]=new Customer(null, null, null);
		record[0].setCustomerID("17");
		record[0].setCustomerName("Disha");
		record[0].setCustomerCity("Kolkata".toUpperCase());

		record[3]=new Customer(null, null, null);
		record[3].setCustomerID("58");
		record[3].setCustomerName("Nisha");
		record[3].setCustomerCity("Bengaluru".toUpperCase());

		record[4]=new Customer(null, null, null);
		record[4].setCustomerID("63");
		record[4].setCustomerName("Misha");
		record[4].setCustomerCity("Delhi".toUpperCase());

		record[1]=new Customer(null, null, null);
		record[1].setCustomerID("34");
		record[1].setCustomerName("Aisha");
		record[1].setCustomerCity("Mumbai".toUpperCase());

		record[2]=new Customer(null, null, null);
		record[2].setCustomerID("6");
		record[2].setCustomerName("Lisha");
		record[2].setCustomerCity("Chennai".toUpperCase());
	}

	boolean insertDetails() {

		Scanner sc=new Scanner(System.in);

		for(int i=0;i<record.length;i++) {
			System.out.println("Enter Customer ID: ");
			String id=sc.next();
			System.out.println("Enter Customer Name: ");
			String name=sc.next();
			System.out.println("Enter Customer City: ");
			String city=sc.next().toUpperCase();

			record[i]=new Customer(id,name,city);
		}

		return true;
	}

	void displayDetails(String msg) {
		System.out.println("\n"+msg+": ");
		System.out.print("CustomerID\t\tCustomerName\t\tCustomerCity\n");
		
		for(Customer ob:this.record) {
			System.out.print(
				ob.getCustomerID()+"\t\t\t"+ob.getCustomerName()+"\t\t\t"+ob.getCustomerCity()+"\n");
		}
	}

	void getCustomer(String key) {
		Integer first=0;
		Integer last=this.record.length;
		Integer mid=(first+last)/2;
		while(first<=last) {
			if(this.record[mid].getCustomerID().compareTo(key)== -1) {
				first=mid+1;
			}
			else if(this.record[mid].getCustomerID().compareTo(key)==0) {
				System.out.println("Found- "+this.record[mid].getCustomerID()+" "+this.record[mid].getCustomerName()+" "+this.record[mid].getCustomerCity());
				break;
			}
			else {
				last=mid-1;
			}
			mid=(first+last)/2;
		}

		if(first>last) {
			System.err.println("ID not found!");
		}
	}

	void sortByCustomerID() {
		int n=this.record.length;
		for(int j=1;j<n;j++) {
			Customer key=this.record[j];
			int i=j-1;
			while((i> -1) && (this.record[i].getCustomerID().compareTo(key.getCustomerID()))>0) {
				this.record[i+1]=this.record[i];
				i--;
			}
			this.record[i+1]=key;
		}
	}
	
	void sortByCustomerName() {

		int n=this.record.length;
		for(int j=1;j<n;j++) {
			Customer key=this.record[j];
			int i=j-1;
			while((i> -1) && (this.record[i].getCustomerName().compareTo(key.getCustomerName()))>0) {
				this.record[i+1]=this.record[i];
				i--;
			}
			this.record[i+1]=key;
		}
	}
	
	void sortByCustomerCity() {
		int n=this.record.length;
		for(int j=1;j<n;j++) {
			Customer key=this.record[j];
			int i=j-1;
			while((i> -1) && (this.record[i].getCustomerCity().compareTo(key.getCustomerCity()))>0) {
				this.record[i+1]=this.record[i];
				i--;
			}
			this.record[i+1]=key;
		}
	}
}

public class CustomerDetails {
	
	public static void main(String[] args) {

		Record cRecords=new Record();

		cRecords.displayDetails("Orignal Records");

		cRecords.sortByCustomerID();

		cRecords.displayDetails("Sorted Records by ID");

		System.out.println("\nDetails of ID 17: ");
		cRecords.getCustomer("17");
		
		System.out.println("\nDetails of ID 45: ");
		cRecords.getCustomer("45");

		cRecords.sortByCustomerName();

		cRecords.displayDetails("Sorted Records by NAME");
		
		cRecords.sortByCustomerCity();

		cRecords.displayDetails("Sorted Records by CITY");
	}
}
