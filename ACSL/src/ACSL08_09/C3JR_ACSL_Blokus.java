package ACSL08_09;
import java.util.*;
import java.io.*;
public class C3JR_ACSL_Blokus {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0809C3Jr.in"));
		for(int i = 0; i < 10; i++) {
			String s = sc.next();
			int start1 = 'J' - s.charAt(0);
			int start2 = Integer.parseInt(s.substring(1)) - 1;
			int r = start1;
			int c = start2;
			int st = sc.nextInt();
			if(st == 2)
				c++;
			int tile = sc.nextInt();
			String res = "";
			if(tile == 1 && st == 2 && ((r + 1 < 10 && c + 2 < 10) || (r - 1 > -1 && c + 2 < 10)))
				res += "A ";
			if(tile == 2 && st == 1 && ((r + 1 < 10 && c - 2 > -1) || (r - 1 > -1 && c - 2 > -1)))
				res += "A ";
			if((tile == 2 && st == 1 && r + 2 < 10 && c - 2 > -1) || (tile == 1 && st == 2 && 
					(r + 2 < 10 && c + 2 < 10) || (r - 1 > -1 && c + 2 < 10)) && tile != st)
				res += "B ";
			if(tile == 1 && ((st == 1 && r + 2 < 10 && c - 2 > -1) || (st == 2 && r + 2 < 10 && c + 2 < 10)))
				res += "C ";
			if(tile == 2 && st == tile && ((r - 2 > -1 && c + 3 < 10) || (r + 1 < 10 && c + 3 < 10)))
				res += "C ";
			if(tile == 1 && ((st == 1 && r + 3 < 10 && c - 2 > -1) || (st == 2 && r + 3 < 10 && c + 1 < 10)))
				res += "D ";
			if(tile == 2 && st == 2 && r + 2 < 10 && r + 2 < 10)
				res += "D";
			System.out.println((res.length() > 0) ? res : "NONE");
		}
		sc.close();
	}
}