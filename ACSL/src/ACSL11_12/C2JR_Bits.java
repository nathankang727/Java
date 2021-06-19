package ACSL11_12;
import java.util.*;
import java.io.*;
public class C2JR_Bits {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1112C2Jr.in"));
		for(int i = 0; i < 5; i++) {
			String a = in.next();
			String result = "";
			ArrayList<String> digits = new ArrayList<String>();
			for(int j = 0; j < 5; j++)
				digits.add(a.substring(j, j + 1));
			int b = a.indexOf("*");
			int c = a.lastIndexOf("*");
			if(b == -1) {
				for(int j = 0; j < 5; j++) {
					result = a;
				}
			}
			else if(b == c) {
				result = a.replace("*", "0") + " " + a.replace("*", "1");
			}
			else {
				result = a.replace("*", "0");
				result += " " + a.replace("*", "1");
				digits.set(b, "1");
				digits.set(c, "0");
				result += " ";
				for(int j = 0; j < 5; j++)
					result += digits.get(j);
				digits.set(b, "0");
				digits.set(c, "1");
				result += " ";
				for(int j = 0; j < 5; j++)
					result += digits.get(j);

			}
			System.out.println(result);
		}
		in.close();
	}
}