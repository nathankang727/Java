package HSPC2018;
import java.io.*;
public class Problem3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String e = br.readLine();
		int[] sFreq = new int[26];
		int[] eFreq = new int[26];
		for(int i = 0; i < s.length(); i++)
			++sFreq[s.charAt(i) - 'a'];
		for(int i = 0; i < e.length(); i++)
			++eFreq[e.charAt(i) - 'a'];
		int answer = 0;
		for(int i = 0; i < 26; i++)
			if(sFreq[i] - eFreq[i] > 0)
				answer += choosing(sFreq[i], eFreq[i]);
		System.out.println(answer);
	}
	public static int choosing(int n1, int n2) {
		int numerator = 1;
		int denominator1 = 1;
		int denominator2 = 1;
		for(int i = 1; i <= n1; i++)
			numerator *= i;
		for(int i = 1; i <= n2; i++)
			denominator1 *= i;
		for(int i = 1; i <= n1 - n2; i++)
			denominator2 *= i;
		return numerator / (denominator1 * denominator2);
	}
}