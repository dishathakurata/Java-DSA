package array;

import array.Pair;

/*
 * 3. Write a Generic method that computes the Second minimum and Second maximum elements
of an array of type T and returns a pair containing the minimum and maximum value.
 */

class arraySecondMinMax<T> {
	
	public static <T extends Comparable<T>> Pair<T,T> sort(T[] a) {
		T s_min,s_max;
		int i=0,j=0;
        for(i=0;i<a.length;i++) {
            for(j=0;j<a.length-1-i;j++) {
                if(a[j].compareTo(a[j+1])>0) {
                    T temp=a[j];
                    a[j]=a[j+1];
                    a[j+1]=temp;
                }
            }
        }
        s_min=a[1];
        s_max=a[a.length-2];
        return new Pair<>(s_min, s_max);
    }

    void display(T[] a) {
        for(T t:a) {
            System.out.print(t+" ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
    	
    	Integer[] a={1,200,11,22,167,23};
    	Pair<Integer,Integer> result=sort(a);
    	System.out.println("Pair of Second minimum and Second maximum elements: ");
    	System.out.println("("+result.getFirst()+","+result.getSecond()+")");
    }
}

class Pair<U, V> {
	private U first;
	private V second;
	
	public Pair(U first,V second) {
		this.first=first;
		this.second=second;
	}
	
	public U getFirst() {
		return first;
	}
	
	public V getSecond() {
		return second;
	}
}

/*
 * Output:
 * Pair of Second minimum and Second maximum elements: 
 * (11,167)
 */

