/*
Start Time: 2:33
End Time: 2:49
*/
package ACSL08_09;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_Bridge {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0809C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			int bid = sc.nextInt();
			int tricks = sc.nextInt() - 6;
			String suit = sc.next();
			int atl = tricks - bid;
			int upoints = 0;
			int apoints = 0;
			if(suit.equals("N")) {
				for(int j = 0; j < bid; j++) {
					if(j == 0)
						upoints += 40;
					else
						upoints += 30;
				}
				for(int j = 0; j < atl; j++)
					apoints += 30;
			}
			else if(suit.equals("H") || suit.equals("S")) {
				for(int j = 0; j < bid; j++)
					upoints += 30;
				for(int j = 0; j < atl; j++)
					apoints += 30;
			}
			else {
				for(int j = 0; j < bid; j++)
					upoints += 20;
				for(int j = 0; j < atl; j++)
					apoints += 20;
			}
			System.out.println(upoints + " " + apoints);
		}
		sc.close();
	}
}