package ACSL11_12;
import java.io.*;
public class AllStar3_FactorTrees {
	static int[] factors;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1112AllStar3.in")));
		for(int i = 0; i < 20; i++) {
			int n = Integer.parseInt(br.readLine());
			System.out.println(n);
			factors = new int[n + 1];
			while(true) {
				boolean foundFactor = false;
				for(int j = 2; j < n; j++) {
					if(n % j == 0) {
						n /= j;
						++factors[j];
						foundFactor = true;
						answer(n);
						break;
					}
				}
				if(!foundFactor)
					break;
			}
			++factors[n];
			finalAnswer();
			System.out.println();
		}
		br.close();
	}
	public static void answer(int n) {
		String ans = n + "";
		for(int i = factors.length - 1; i >= 0; i--)
			for(int j = 0; j < factors[i]; j++)
				ans += " X " + i;
		System.out.println(ans);
	}
	public static void finalAnswer() {
		String ans = "";
		int count = 0;
		for(int i = factors.length - 1; i >= 0; i--) {
			if(factors[i] > 0) {
				if(count > 0)
					ans += " X ";
				ans += i;
				if(factors[i] > 1)
					ans += " ^ " + factors[i];
				++count;
			}
		}
		System.out.println(ans);
	}
}