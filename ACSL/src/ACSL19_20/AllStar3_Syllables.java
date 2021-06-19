package ACSL19_20;
import java.util.*;
import java.io.*;
public class AllStar3_Syllables {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 13; i++)
			System.out.println(syllables(br.readLine()));
		br.close();
	}
	public static int syllables(String word) {
		int sum = 0;
		String[] prefixArr = {"co", "de", "dis", "pre", "re", "un"};
		String[] suffixArr = {"age", "ful", "ing", "less", "ment"};
		char[] vowelArr = {'a', 'e', 'i', 'o', 'u'};
		ArrayList<String> prefixes = new ArrayList<String>();
		ArrayList<String> suffixes = new ArrayList<String>();
		ArrayList<Character> vowels = new ArrayList<Character>();
		for(int i = 0; i < 6; i++)
			prefixes.add(prefixArr[i]);
		for(int i = 0; i < 5; i++) {
			suffixes.add(suffixArr[i]);
			vowels.add(vowelArr[i]);
		}
		String syllableWord = "";
		String suffix = "";
		if(word.length() > 2 && prefixes.contains(word.substring(0, 3))) {
			syllableWord += word.substring(0, 3);
			word = word.substring(3);
		}
		else if(word.length() > 1 && prefixes.contains(word.substring(0, 2))) {
			syllableWord += word.substring(0, 2);
			word = word.substring(2);
		}
		if(word.length() > 3 && suffixes.contains(word.substring(word.length() - 4))) {
			suffix += "|" + word.substring(word.length() - 4);
			word = word.substring(0, word.length() - 4);
		}
		else if(word.length() > 2 && suffixes.contains(word.substring(word.length() - 3))) {
			suffix += "|" + word.substring(word.length() - 3);
			word = word.substring(0, word.length() - 3);
		}
		word = word.replace("ch", "0").replace("ck", "1").replace("ph", "2").replace("sh", "3").replace("th", "4").replace("wh", "5");
		word = word.replace("wr", "6");
		boolean hasVowel = false;
		String syllable = "|" + word.substring(0, 1);
		if(vowels.contains(word.charAt(0)))
			hasVowel = true;
		for(int i = 1; i < word.length() - 1; i++) {
			if(vowels.contains(word.charAt(i)))
				hasVowel = true;
			if(vowels.contains(word.charAt(i - 1)) && !vowels.contains(word.charAt(i)) && vowels.contains(word.charAt(i + 1))) {
				syllableWord += syllable;
				syllable = "|" + word.substring(i, i + 1);
				if(!hasVowel)
					syllable = syllable.substring(1);
				hasVowel = false;
				continue;
			}
			if(!vowels.contains(word.charAt(i)) && !vowels.contains(word.charAt(i + 1))) {
				syllableWord += syllable + word.substring(i, i + 1);
				syllable = "|";
				if(!hasVowel)
					syllable = "";
				hasVowel = false;
				continue;
			}
			syllable += word.substring(i, i + 1);
		}
		if(vowels.contains(word.charAt(word.length() - 1)))
			hasVowel = true;
		syllableWord += syllable + word.substring(word.length() - 1);
		if(!hasVowel)
			syllableWord = syllableWord.substring(0, syllableWord.length() - 2) + syllableWord.substring(syllableWord.length() - 1);
		syllableWord += suffix;
		if(syllableWord.charAt(0) == '|')
			syllableWord = syllableWord.substring(1);
		syllableWord = syllableWord.replace("0", "ch").replace("1", "ck").replace("2", "ph").replace("3", "sh").replace("4", "th");
		syllableWord = syllableWord.replace("5", "wh").replace("6", "wr");
		for(int i = 0; i < syllableWord.length(); i++)
			if(syllableWord.charAt(i) == '|')
				sum += i;
		return sum;
	}
}