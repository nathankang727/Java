/*
Name: Nathan Kang
Grade: 7
Date: January 24, 2019
Start Time: 6:45
End Time: 7:15
*/
package ACSL18_19;
import java.util.*;
import java.io.*;
public class Contest2Jr_Nathan {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1819c2jr.in"));
		String sentence = br.readLine();
		Set<Character> letters = new HashSet<Character>();
		for(int i = 0; i < sentence.length(); i++)
			if(sentence.substring(i, i + 1).toUpperCase().charAt(0) >= 'A' && sentence.substring(i, i + 1).toUpperCase().charAt(0) <= 'Z')
				letters.add(sentence.substring(i, i + 1).toUpperCase().charAt(0));
		System.out.println(letters.size());
		int count = 0;
		for(int i = 0; i < sentence.length(); i++) {
			if(sentence.charAt(i) == 'A' || sentence.charAt(i) == 'E' || sentence.charAt(i) == 'I'
				|| sentence.charAt(i) == 'O' || sentence.charAt(i) == 'U' || sentence.charAt(i) == 'a' || sentence.charAt(i) == 'e'
				|| sentence.charAt(i) == 'i' || sentence.charAt(i) == 'o' || sentence.charAt(i) == 'u')
				count++;
		}
		System.out.println(count);
		String sentence2 = sentence.toUpperCase();
		int countUpper = 0;
		for(int i = 0; i < sentence.length(); i++)
			if(sentence.charAt(i) == sentence2.charAt(i) && sentence2.charAt(i) <= 'Z' && sentence2.charAt(i) >= 'A')
				countUpper++;
		System.out.println(countUpper);
		int[] countL = new int[26];
		for(int i = 0; i < sentence2.length(); i++)
			if(sentence2.charAt(i) >= 'A' && sentence2.charAt(i) <= 'Z')
				countL[sentence2.charAt(i) - 'A']++;
		Arrays.sort(countL);
		System.out.println(countL[countL.length - 1]);
		sentence = sentence.replaceAll("[^A-Z^a-z^ ]", "");
		String[] s = sentence.split(" ");
		Arrays.sort(s);
		int[] intt = new int[s.length];
		for(int i = 0; i < s.length; i++)
			intt[i] = s[i].length();
		Arrays.sort(intt);
		int longestLen = intt[intt.length - 1];
		for(int i = 0; i < s.length; i++) {
			if(s[i].length() == longestLen) {
				System.out.println(s[i]);
				break;
			}
		}
		br.close();
	}
}