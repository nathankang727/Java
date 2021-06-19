package ACSL09_10;
import java.util.*;
import java.io.*;
public class AllStar3_ACSL_Krypto {
	static ArrayList<String> ops;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("0910AllStar3.in")));
		String[] ops = {"+-*/", "+-/*", "+*-/", "+*/-", "+/-*", "+/*-", "-+*/", "-+/*", "-*+/", "-*/+", "-/+*", "-/*+", 
				"*+-/", "*+/-", "*-+/", "*-/+", "*/+-", "*/-+", "/+-*", "/+*-", "/-+*", "/-*+", "/*+-", "/*-+"};
		for(int i = 0; i < 12; i++) {
			int[] n = new int[5];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
				n[j] = Integer.parseInt(st.nextToken());
			int sum = Integer.parseInt(st.nextToken());
			for(int j = 0; j < 24; j++) {
				int res = 0;
				for(int k = 0; k < 4; k++) {
					char c = ops[j].charAt(k);
					if(k == 0)
						res = n[0];
					if(c == '+')
						res += n[k + 1];
					else if(c == '-')
						res -= n[k + 1];
					else if(c == '*')
						res *= n[k + 1];
					else if(c == '/')
						res /= n[k + 1];
				}
				if(res == sum) {
					System.out.println(n[0] + " " + ops[j].charAt(0) + " " + n[1] + " " + ops[j].charAt(1)
							+ " " + n[2] + " " + ops[j].charAt(2) + " " + n[3] + " " + ops[j].charAt(3) + " "
							+ n[4] + " = " + sum);
					break;
				}
			}
		}
		br.close();
	}
}