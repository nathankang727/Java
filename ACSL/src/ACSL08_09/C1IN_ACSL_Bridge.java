package ACSL08_09;
import java.util.*;
import java.io.*;
public class C1IN_ACSL_Bridge {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0809C1IN.in"));
		for(int i = 0; i < 10; i++) {
			int undertrick = 0;
			int overtrick = 0;
			int bid = sc.nextInt() + 6;
			int tricks = sc.nextInt();
			char suit = sc.next().charAt(0);
			char vulnerable = sc.next().charAt(0);
			if(tricks < bid) {
				for(int j = 0; j < bid - tricks; j++) {
					if(vulnerable == 'V')
						overtrick += 100;
					else
						overtrick += 50;
				}
			}
			else {
				for(int j = 0; j < tricks - bid; j++) {
					if(suit == 'T' || suit == 'H' || suit == 'S')
						overtrick += 30;
					else
						overtrick += 20;
				}
				for(int j = 0; j < bid - 6; j++) {
					if(suit == 'T' && j == 0)
						undertrick += 40;
					else if(suit == 'T' && j != 0 || suit == 'H' || suit == 'S')
						undertrick += 30;
					else
						undertrick += 20;
				}
			}
			System.out.println(undertrick + " " + overtrick);
		}
		sc.close();
	}
}