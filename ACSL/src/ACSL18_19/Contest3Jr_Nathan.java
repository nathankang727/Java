/*
Nathan 7
2018-2019 ACSL Contest 3 Junior Division
ABCobot
*/
package ACSL18_19;
import java.util.*;
import java.io.*;
public class Contest3Jr_Nathan {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1819c3jr.in"));
		for(int i = 0; i < 5; i++) {
			String res = "";
			int r = sc.nextInt();
			int c = sc.nextInt();
			int s = sc.nextInt();
			int num = sc.nextInt();
			boolean[] n = new boolean[(r * c) + 1];
			for(int j = 1; j <= num; j++)
				n[sc.nextInt()] = true;
			int count = 0;
			while(s % c != 0 && s <= r * c) {
				if(count % 3 == 0) {
					if(!n[s + 1] && !n[s + 2] && !n[s + 3] && s % c <= c - 3) {
						n[s + 1] = true;
						n[s + 2] = true;
						if(count != 0) {
							n[s + 3] = true;
							s = s + 3;
						}
						else
							s = s + 2;
						res += "A";
					}
				}
				else if(count % 3 == 1) {
					if(s + c + 2 <= r * c && (!n[s + 1] && !n[s + c + 1] && !n[s + c + 2])) {
						n[s + 1] = true;
						n[s + c + 1] = true;
						n[s + c + 2] = true;
						s = s + c + 2;
						res += "B";
					}
				}
				else {
					if(s + c + c + 2 <= r * c && (!n[s + 1] && !n[s + 2] && !n[s + c + 2] && !n[s + c + c + 2])) {
						n[s + 1] = true;
						n[s + 2] = true;
						n[s + c + 2] = true;
						n[s + c + c + 2] = true;
						s = s + c + c + 2;
						res += "C";
					}
				}
				count++;
				if(s % c > c - 3 && s + r > r * c)
					break;
			}
			System.out.println(res);
		}
		sc.close();
	}
}