package array;

/*
 * 4. Write class SparseMatrix to give a compressed storage representation of a sparse matrix and
also find the transpose of the sparse matrix (from the compressed representation).
 */

public class SparseMatrix {
    private final int rows;
    private final int columns;
	private int non_zero_values;

    public SparseMatrix(int rows, int columns, int non_zero_values) {
        this.rows=rows;
        this.columns=columns;
        this.non_zero_values=non_zero_values;
    }
    
    static boolean isSparseMatrix(int a[][]) {
		int nz = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] != 0)
					nz++;
			}
		}
		if(nz*3 < a.length * a[0].length)
			return true;
		else
			return false;
	}
    
    static void toSparseMatrix(int a[][]) {
		SparseMatrix[] r = new SparseMatrix[a.length * a[0].length];
		System.out.println("\nCompressed matrix: ");
		int count = 0;
		System.out.println("Row\t\tColumn\t\tNon-Zero Value");
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a[i].length; j++) {
				if(a[i][j] != 0) {
					r[count] = new SparseMatrix(i, j, a[i][j]);
					count++;
				}
			}
		}
		
		for(SparseMatrix temp : r)
			if(temp != null)
				System.out.println(temp.rows + "\t\t" + temp.columns + "\t\t" + temp.non_zero_values);
		
		
		System.out.println("\nTranspose: ");

		for(int i=0;i<r.length;i++) {
			for(int j=i;j<r.length-i-1;j++) {
				if(r[i]!=null && r[j]!=null && r[i].columns>r[j].columns ) {
					SparseMatrix temp=r[i];
					r[i]=r[j];
					r[j]=temp;
					temp=null;
				}
			}
		}
		
		for(SparseMatrix temp:r)
			if(temp!=null)
				System.out.println(temp.rows+"  "+temp.columns+"  "+temp.non_zero_values);
		
	}

    public static void main(String[] args) {
        int[][] matrix={
                {0,0,3,0,4},
                {0,0,5,7,0},
                {0,0,0,0,0},
                {0,2,6,0,0}
        };
        
        System.out.println("Matrix: ");
        for(int i=0;i<matrix.length;i++) {
        	for(int j=0;j<matrix[i].length;j++) {
        		System.out.print(matrix[i][j]+" ");
        	}
        	System.out.println();
        }
        
        if(isSparseMatrix(matrix))
			toSparseMatrix(matrix);
		else
			System.out.println("Not SPARSE");
    }
}
