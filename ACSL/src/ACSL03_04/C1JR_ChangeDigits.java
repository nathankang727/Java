/*
Start Time: 9:50
End Time: 
*/
package ACSL03_04;
import java.util.*;
import java.io.*;
public class C1JR_ChangeDigits {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("0304C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			String n = br.readLine();
			String ans = "";
			int number = 0;
			int index = 0;
			int[] a = new int[n.length()];
			int[] res = new int[n.length()];
			for(int j = 0; j < n.length(); j++) {
				res[j] = Integer.parseInt(n.substring(j, j + 1));
				a[j] = Integer.parseInt(n.substring(j, j + 1));
			}
			Arrays.sort(a);
			number = a[a.length - 1];
			index = n.indexOf(String.valueOf(number));
			if(res[index] % 2 == 0 && res[index] + 4 >= 10)
				res[index] = (res[index] + 4) % 10;
			else if(res[index] % 2 == 0 && res[index] + 4 < 10)
				res[index] += 4;
			else
				res[index] = 0;
			for(int j = 0; j < res.length; j++)
				ans += String.valueOf(res[j]);
			System.out.println(Integer.parseInt(ans));
		}
		br.close();
	}
}