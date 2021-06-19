package ACSL12_13;
import java.util.*;
import java.io.*;
public class C2JR_Cells {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1213C2Jr.in"));
		for(int i = 0; i < 10; i++) {
			String operation = sc.next();
			String s = sc.next();
			if(operation.equals("DIVIDE")) {
				String s1 = s.substring(0, 4);
				String s2 = s.substring(4, 8);
				s1 += s1;
				s2 += s2;
				System.out.println(s1 + " and " + s2);
			}
			else if(operation.substring(0, 3).equals("ADD")) {
				int n = Integer.parseInt(operation.substring(3, 4));
				String newString = "";
				if(n != 0)
					newString = s.substring(0, n);
				for(int j = 0; j < s.length() - n; j++)
					newString += s.substring(j, j + 1);
				System.out.println(newString);
			}
			else {
				int n = Integer.parseInt(operation.substring(8, 9));
				String ns = "";
				String newString = "";
				if(n != 0)
					ns = s.substring(s.length() - n, s.length());
				for(int j = n; j < s.length(); j++)
					newString += s.substring(j, j + 1);
				newString += ns;
				System.out.println(newString);
			}
		}
		sc.close();
	}
}