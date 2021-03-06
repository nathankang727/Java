package DataStructures;
import java.io.*;
public class Problem1String {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] alphabet = new int[26];
		String word = br.readLine();
		for(int i = 0; i < word.length(); i++)
			alphabet[word.charAt(i) - 'a']++;
		for(int i = 0; i < 25; i++)
			System.out.print(alphabet[i] + " ");
		System.out.print(alphabet[alphabet.length - 1]);
	}
}