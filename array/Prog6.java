package array;

/*
 * 6. Write a program to find whether a matrix is orthogonal or not. Also find the 1-norm of the
matrix.
 */

public class Prog6 {
	
	static boolean isOrthogonal(int[][] a) {
		//Identity matrix
		int[][] idenarr = {
				{1,0,0},
				{0,1,0},
				{0,0,1}
		};
		
		//Checking if a matrix is equal to identity matrix
		for(int i=0;i<a.length;i++) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j]==idenarr[i][j])
					continue;
				else
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[][] arr = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		
		int[][] marr = new int[3][3]; //Defining multiplication of a matrix
		
		int[][] tarr = new int[3][3]; //Defining transpose of a matrix
		
		//Transpose of a matrix
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				tarr[i][j]=arr[j][i];
			}
		}
		
		//Multiplication of a matrix with its transpose
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				marr[i][j]=0;
				for(int k=0;k<3;k++) {
					marr[i][j]+=arr[i][k]*tarr[k][i];
				}
			}
		}
		
		//Checking if the multiplied matrix is equal to identity matrix
		if(isOrthogonal(marr))
			System.out.println("Matrix is orthogonal");
		else
			System.out.println("Matrix is not orthogonal");
		
		int[] narr = new int[3]; //Defining 1-norm matrix
		
		//Calculating sum of each row and adding it to a matrix
		for(int i=0;i<3;i++) {
			narr[i]=arr[i][0];
			for(int j=1;j<3;j++) {
				narr[i]+=arr[i][j];
			}
		}
		
		//Finding maximum sum of a column in the matrix
		int max_narr=narr[0];
		for(int i=1;i<3;i++) {
			if(narr[i]>max_narr) {
				max_narr=narr[i];
			}
		}
		
		System.out.println("1-norm of the matrix="+max_narr);
	}
}
