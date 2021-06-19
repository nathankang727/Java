/*
Nathan Kang, 6th Grade
acobot
ACSL 2017-2018 4th Contest
Thursday, April 5, 2018
*/
package ACSL17_18;
import java.util.*;
import java.io.*;
public class C4JR_Duplicates {
	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("1718C4Jr.in"));
		for(int i = 0; i < 5; i++) {
			int index = in.nextInt() - 1;
			int result = 0;
			String word = in.nextLine().toUpperCase().replace(" ", "");
		    String[] a = new String[word.length()];
	    	Arrays.fill(a, "a");
		    for(int j = 0; j < word.length(); j++) {
		    	String z = a[index];
		    	a[j] = word.substring(j, j + 1);
		    	Arrays.sort(a);
		    	if(!a[index].equals(z))
		    		result++;
		    }
		    System.out.println(result);
		}
		in.close();
	}
}