package HSPC2017;
import java.io.*;
public class Problem6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alphabet = new int[26];
		String str = br.readLine();
		for(int i = 0; i < str.length(); i++)
			++alphabet[str.charAt(i) - 'a'];
		int oddCount = 0;
		for(int i = 0; i < 26; i++)
			if(alphabet[i] % 2 == 1)
				++oddCount;
		System.out.println(oddCount <= 1 ? "1" : "0");
	}
}