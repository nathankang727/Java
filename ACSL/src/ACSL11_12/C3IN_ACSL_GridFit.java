package ACSL11_12;
import java.util.*;
import java.io.*;
public class C3IN_ACSL_GridFit {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1112C3In.in"));
		for(int i = 0; i < 2; i++) {
			int len = sc.nextInt();
			boolean[] filled = new boolean[26];
			for(int j = 0; j < len; j++)
				filled[sc.nextInt()] = true;
			for(int j = 1; j <= 5; j++) {
				int n = sc.nextInt();
				int res = 0;
				if(n == 1) {
					for(int k = 1; k <= 25; k++) {
						if(!(filled[k])) {
							res = k;
							filled[k] = true;
							break;
						}
					}
				}
				else if(n == 2) {
					for(int k = 1; k <= 20; k++) {
						if(!(filled[k]) && !(filled[k + 5])) {
							res = k;
							filled[k] = true;
							filled[k + 5] = true;
							break;
						}
					}
				}
				else if(n == 3) {
					for(int k = 1; k <= 24; k++) {
						if(k % 5 != 0 && !(filled[k]) && !(filled[k + 1])) {
							res = k;
							filled[k] = true;
							filled[k + 1] = true;
							break;
						}
					}
				}
				else if(n == 4) {
					for(int k = 6; k <= 24; k++) {
						if(k % 5 != 0 && !(filled[k]) && !(filled[k + 5]) && !(filled[k + 6])) {
							res = k;
							filled[k] = true;
							filled[k + 5] = true;
							filled[k + 6] = true;
							break;
						}
					}
				}
				else {
					for(int k = 1; k <= 19; k++) {
						if(k % 5 != 0 && !(filled[k]) && !(filled[k + 5]) && !(filled[k + 1])) {
							res = k;
							filled[k] = true;
							filled[k + 5] = true;
							filled[k + 1] = true;
							break;
						}
					}
				}
				System.out.println((res != 0) ? res : "NONE");
			}
		}
		sc.close();
	}
}