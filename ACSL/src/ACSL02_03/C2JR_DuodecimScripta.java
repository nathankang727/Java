package ACSL02_03;
import java.util.*;
import java.io.*;
public class C2JR_DuodecimScripta {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0203C2Jr.in"));
		for(int i = 0; i < 5; i++) {
			int fp = sc.nextInt();
			boolean w = true;
			int[] positions = new int[26];
			int[] res = new int[26];
			for(int j = 0; j < fp; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				positions[b] = a;
				res[b] = a;
			}
			int op = sc.nextInt();
			int[] positions2 = new int[26];
			for(int j = 0; j < op; j++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				positions2[b] = a;
			}
			int[] rolls = new int[3];
			for(int j = 0; j < 3; j++)
				rolls[j] = sc.nextInt();
			boolean[] canLand = {true, true, true};
			int count = 0;
			int[] twos = {rolls[0] + rolls[1], rolls[0] + rolls[2], rolls[1] + rolls[2]};
			for(int j = 0; j < 3; j++)
				if(positions[twos[j]] == 5 || positions2[twos[j]] > 1)
					twos[j] = 0;
			int sum = rolls[0] + rolls[1] + rolls[2];
			for(int j = 0; j < 3; j++) {
				if(positions[rolls[j]] == 5 || positions2[rolls[j]] > 1) {
					canLand[j] = false;
					count++;
				}
			}
			if(count == 0)
				for(int j = 0; j < 3; j++)
					res[rolls[j]]++;
			else {
				int a = 9;
				for(int j = 0; j < 3; j++) {
					if(canLand[j] == true) {
						res[rolls[j]]++;
						a = j;
					}
				}
				if(a == 0 || a == 1)
					twos[0] = 0;
				if(a == 0 || a == 2)
					twos[1] = 0;
				if(a == 1 || a == 2)
					twos[2] = 0;
				if(twos[1] == twos[2]) {
					twos[1] = 0;
					twos[2] = 0;
				}
				int c = 0;
				for(int j = 0; j < 3; j++) {
					if(twos[j] == 0)
						c++;
					else
						res[twos[j]]++;
				}
				if(c == 3) {
					if(positions[sum] == 5 || positions2[sum] > 1) {
						w = false;
						System.out.println("NONE");
					}
				else
					res[sum]++;
				}
			}
			for(int j = 0; j < res.length; j++)
				if(res[j] != 0 && w)
					System.out.print(res[j] + " " + j + " ");
			System.out.println();
		}
		sc.close();
	}
}