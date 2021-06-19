/*
Start Time: 10:45
End Time: 11:14
*/
package ACSL01_02;
import java.util.*;
import java.io.*;
public class C1IN_WrapAroundCode {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0102C1IN.in"));
		for(int i = 0; i < 5; i++) {
			ArrayList<String> letters = new ArrayList<String>();
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			String a = sc.next();
			while(!a.equals("$")) {
				 letters.add(a);
				 numbers.add(a.charAt(0) - 'A' + 1);
				 a = sc.next();
			}
			int res = 1;
			for(int j = 0; j < numbers.size(); j++) {
				if(numbers.get(j) >= 1 && numbers.get(j) <= 5)
					res += numbers.get(j) * 2;
				else if(numbers.get(j) >= 6 && numbers.get(j) <= 10)
					res += (numbers.get(j) % 3) * 5;
				else if(numbers.get(j) >= 11 && numbers.get(j) <= 15)
					res += (numbers.get(j) / 4) * 8;
				else if(numbers.get(j) >= 16 && numbers.get(j) <= 20) {
					String c = String.valueOf(numbers.get(j));
					int b = Integer.parseInt(c.substring(0, 1)) + Integer.parseInt(c.substring(1, 2));
					res += b * 10; 
				}
				else if(numbers.get(j) >= 21 && numbers.get(j) <= 26) {
					int c = getMaxFactor(numbers.get(j));
					c *= 12;
					res += c;
				}
				if(res > 26) {
					res %= 26;
					if(res == 0)
						res = 26;
				}
				System.out.print((char)(res + 'A' - 1) + " ");
			}
			System.out.println();
			sc.close();
		}
	}
	public static int getMaxFactor(int num) {
		if(num == 21)
			num = 7;
		else if(num == 22)
			num = 11;
		else if(num == 23)
			num = 1;
		else if(num == 24)
			num = 12;
		else if(num == 25)
			num = 5;
		else if(num == 26)
			num = 13;
		return num;
	}
}