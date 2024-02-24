package array;

/*
 * 5. Write a Class CheckTriangular within that implement methods to check whether a matrix is
i) Lower triangular ii) Upper triangular iii) Diagonal iv) Identity v) Tridiagonal.
 */

class CheckTriangular {
	
	static boolean isLowerTriangle(int[][] tri) {
		
		for(int i=0; i<tri.length; i++) {
			for(int j=0; j<tri[i].length;j++) {
				if(i>=j && tri[i][j]!=0) {
					continue;
				}
				else if(i<j && tri[i][j]==0) {
					continue;
				}
				else
					return false;
			}
		}
		return true;
	}	
	
	static boolean isUpperTriangle(int[][] tri) {
		
		for(int i=0; i<tri.length; i++) {
			for(int j=0; j<tri[i].length;j++) {
				if(i<=j && tri[i][j]!=0) {
					continue;
				}
				else if(i>j && tri[i][j]==0) {
					continue;
				}
				else
					return false;
			}
		}
		return true;
	}	
	
	static boolean isDiagonal(int[][] tri) {
		
		for(int i=0; i<tri.length; i++) {
			for(int j=0; j<tri[i].length;j++) {
				if(i==j && tri[i][j]!=0) {
					continue;
				}
				else if(i!=j && tri[i][j]==0) {
					continue;
				}
				else
					return false;
			}
		}
		return true;
	}	
	
	static boolean isIdentity(int[][] tri) {
		
		for(int i=0; i<tri.length; i++) {
			for(int j=0; j<tri[i].length;j++) {
				if(i==j && tri[i][j]==1) {
					continue;
				}
				else if(i!=j && tri[i][j]==0) {
					continue;
				}
				else
					return false;
			}
		}
		return true;
	}	
	
	static boolean isTridiagonal(int[][] tri) {
		
		for(int i=0; i<tri.length; i++) {
			for(int j=0; j<tri[i].length;j++) {
				if(Math.abs(i-j) <=1 && tri[i][j]!=0) {
					continue;
				}
				else if(Math.abs(i-j) > 1 && tri[i][j]==0) {
					continue;
				}
				else
					return false;
			}
		}
		return true;
	}	
}

public class Prog5 {

	public static void main(String[] args) {
		int[][] arr1 = {{1,0,0},{2,3,0},{4,5,6}};
		
		if(CheckTriangular.isLowerTriangle(arr1))
			System.out.println("Lower triangle");
		else
			System.out.println("Not lower triangle");
		
		int[][] arr2 = {{1,2,3},{0,4,5},{0,0,6}};
		
		if(CheckTriangular.isUpperTriangle(arr2))
			System.out.println("Upper triangle");
		else
			System.out.println("Not upper triangle");
		
		int[][] arr3 = {{1,0,0},{0,2,0},{0,0,3}};
		
		if(CheckTriangular.isDiagonal(arr3))
			System.out.println("Diagonal");
		else
			System.out.println("Not diagonal");
		
		int[][] arr4 = {{1,0,0},{0,1,0},{0,0,1}};
		
		if(CheckTriangular.isDiagonal(arr3))
			System.out.println("Identity");
		else
			System.out.println("Not identity");
		
		int[][] arr5 = {{1,2,0},{3,4,5},{0,6,7}};
		
		if(CheckTriangular.isDiagonal(arr3))
			System.out.println("Tridiagonal");
		else
			System.out.println("Not tridiagonal");
	}
}
