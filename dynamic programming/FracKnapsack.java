package greedyANDdp;

/*
 * 5. Write a program to implement Fractional knapsack.
 */

import java.util.*;

class Item {
  int value, weight;
  
  Item(int x, int y) {
    this.value = x;
    this.weight = y;
  }
}

class itemComparator implements Comparator<Item> {
    @Override
    public int compare(Item a, Item b) {
        double r1 = (double)(a.value) / (double)(a.weight);
        double r2 = (double)(b.value) / (double)(b.weight);
        if(r1 < r2)
        	return 1;
        
        else if(r1 > r2)
        	return -1;
        
        else
        	return 0;
    }
}

public class FracKnapsack {
	
    static double fractionalKnapsack(int W, Item arr[], int n) {
        Arrays.sort(arr, new itemComparator());
        
        int curW = 0;
        double finalV = 0.0;
        
        for(int i = 0; i < n; i++) {
            if((curW + arr[i].weight) <= W) {
                curW += arr[i].weight;
                finalV += arr[i].value;
            }
     
            else {
                int r = W - curW;
                finalV += ((double)arr[i].value / (double)arr[i].weight) * (double)r;
                break;
            }
        }
     
        return finalV;
    }
    
    public static void main(String args[]) {
        int n = 3, weight = 50;
        Item arr[] = {new Item (100,20),new Item(60,10),new Item(120,30)};
        double ans = fractionalKnapsack(weight, arr, n);
        System.out.println("The maximum value is "+ans);
    }
}