/*
Start Time: 1:38
End Time: 2:00
*/
package ACSL06_07;
import java.util.*;
import java.io.*;
public class C1JR_Probability {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0607C1Jr.in"));
		for(int i = 0; i < 8; i++) {
			int n = sc.nextInt();
			int[] balls = new int[2];
			balls[0] = sc.nextInt();
			balls[1] = sc.nextInt();
			int ballCount = balls[0] + balls[1];
			if(n == 1) {
				String a = sc.next();
				if(a.equals("R"))
					System.out.println(balls[0] + "/" + ballCount);
				else
					System.out.println(balls[1] + "/" + ballCount);
			}
			else {
				String a = sc.next();
				String[] pick = new String[2];
				pick[0] = sc.next();
				pick[1] = sc.next();
				if(a.equals("Y")) {
					int numerator = 1;
					for(int j = 0; j < 2; j++) {
						if(pick[j].equals("R"))
							numerator *= balls[0];
						else
							numerator *= balls[1];
					}
					System.out.println(numerator + "/" + (ballCount * ballCount));
				}
				else {
					int numerator = 1;
					for(int j = 0; j < 2; j++) {
						if(pick[j].equals("R")) {
							numerator *= balls[0];
							balls[0]--;
						}
						else {
							numerator *= balls[1];
							balls[1]--;
						}
					}
					System.out.println(numerator + "/" + (ballCount * (ballCount - 1)));
				}
			}
		}
		sc.close();
	}
}