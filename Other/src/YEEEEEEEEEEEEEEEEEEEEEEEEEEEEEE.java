import java.util.*;
public class YEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		//get data
		//process and output
		while (in.hasNextLine()) {
			String s = in.nextLine(); //1-800-CALL-NOW
			char[] a = new char[s.length()];
			for(int i = 0; i < s.length(); i++) {
				a[i] = s.charAt(i);
				if (a[i] == 'A' || a[i] == 'B' || a[i] == 'C') a[i] = '2';
				else if (a[i] == 'D' || a[i] == 'E' || a[i] == 'F') a[i] = '3';
				else if (a[i] == 'G' || a[i] == 'H' || a[i] == 'I') a[i] = '4';
				else if (a[i] == 'J' || a[i] == 'K' || a[i] == 'L') a[i] = '5';
				else if (a[i] == 'M' || a[i] == 'N' || a[i] == 'O') a[i] = '6';
				else if (a[i] == 'P' || a[i] == 'Q' || a[i] == 'R' || a[i] == 'S') a[i] = '7';
				else if (a[i] == 'T' || a[i] == 'U' || a[i] == 'V') a[i] = '8';
				else if (a[i] == 'W' || a[i] == 'X' || a[i] == 'Y' || a[i] == 'Z') a[i] = '9';
			}
			s = "";
			for(int y = 0; y < a.length; y++)
				s += a[y];
			System.out.println(s);
		}
		in.close();
	}
}