package HSPC2018;
import java.io.*;
public class Problem1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ransom = br.readLine();
		int[] letterRansom = new int[26];
		String magazine = br.readLine();
		int[] letterMagazine = new int[26];
		for(int i = 0; i < ransom.length(); i++) {
			int n = ransom.charAt(i) - 'a';
			if(n >= 0 && n < 26)
				++letterRansom[n];
		}
		for(int i = 0; i < magazine.length(); i++) {
			int n = magazine.charAt(i) - 'a';
			if(n >= 0 && n < 26)
				++letterMagazine[n];
		}
		boolean works = true;
		for(int i = 0; i < 26; i++) {
			if(letterRansom[i] > letterMagazine[i]) {
				works = false;
				break;
			}
		}
		System.out.println(works ? "True" : "False");
	}
}