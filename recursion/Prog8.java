package recursion;

/*
 * 8. Write a Program to calculate the length of the string using a recursive function.
 */

public class Prog8 {
	
	static int strLen(String str) {
 
        if (str.equals(""))
            return 0;
        else
            return strLen(str.substring(1)) + 1;
    }

	public static void main(String[] args) {
		String s = "Java Assignment";
		
		System.out.println("Length of string '" + s + "'= " + strLen(s));
	}
}
