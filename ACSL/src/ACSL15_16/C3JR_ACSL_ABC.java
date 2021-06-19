package ACSL15_16;
import java.util.*;
import java.io.*;
public class C3JR_ACSL_ABC {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1516C3Jr.in"));
		for(int i = 0; i < 10; i++) {
			int filledSquares = sc.nextInt();
			String[] grid = {"D", "D", "D", "D", "D", "D", "D", "D", "D"};
			String[] possibleCases = {"ABCCABBCA", "ABCBCACAB", "ACBBACCBA", "ACBCBABAC", "BACACBCBA", "BACCBAACB", "BCACABABC", "BCAABCCAB", "CABBCAABC", "CABABCBCA", "CBABACACB", "CBAACBBAC"};
			for(int j = 0; j < filledSquares; j++)
				grid[sc.nextInt() - 1] = sc.next();
			int n = 0;
			int l = 0;
			for(int j = 0; j < 12; j++) {
				l = 0;
				for(int k = 0; k < 9; k++) {
					if(!(possibleCases[j].substring(k, k + 1).equals(grid[k])) && !(grid[k].equals("D")))
						continue;
					else
						l++;
				}
				if(l == 9) {
					n = j;
					break;
				}
			}
			System.out.println(possibleCases[n]);
		}
		sc.close();
	}
}