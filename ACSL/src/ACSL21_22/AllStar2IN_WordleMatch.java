package ACSL21_22;
import java.util.*;
public class AllStar2IN_WordleMatch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(findMatch(sc.nextLine(), sc.nextLine()));
		sc.close();
	}
	public static String findMatch(String word, String guesses) {
        String[] str = guesses.split(" ");
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        Wordle[] words = new Wordle[str.length];
        int[] alphabets = new int[26];
        for(int i = 0; i < str.length; i++) {
            words[i] = new Wordle(str[i], 0, 0, 0, 0, 0);
            int[] alphaCount = new int[26];
            for(int j = 0; j < word.length(); j++)
                alphaCount[word.charAt(j) - 'a']++;
            boolean[] greenAlr = new boolean[5];
            for(int j = 0; j < str[i].length(); j++) {
                alphabets[str[i].charAt(j) - 'a']++;
                if(str[i].charAt(j) == word.charAt(j)) {
                    if(j == 0)
                        words[i].firstGreen = 1;
                    if(j == 4)
                        words[i].lastGreen = 1;
                    char c = str[i].charAt(j);
                    if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                        words[i].greenVowel++;
                    words[i].green++;
                    greenAlr[j] = true;
                    --alphaCount[word.charAt(j) - 'a'];
                }
            }
            for(int j = 0; j < str[i].length(); j++) {
                if(!greenAlr[j] && alphaCount[str[i].charAt(j) - 'a'] > 0) {
                    words[i].yellow++;
                    --alphaCount[str[i].charAt(j) - 'a'];
                }
            }
        }
        Arrays.sort(words);
        String ans = "";
        int cnt = 0;
        for(int i = 0; i < words.length; i++) {
            if(cnt == 6)
                break;
            if(words[i].green == 0 && words[i].yellow == 0) {
                ans = "";
                for(int j = 0; j < 26; j++)
                    if(alphabets[j] == 0)
                        ans += alphabet.charAt(j) + "";
                return ans;
            }
            if(ans.equals(""))
                ans += words[i].str;
            else
                ans += " " + words[i].str;
            ++cnt;
        }
        if(cnt < 6) {
            ans = "";
            for(int j = 0; j < 26; j++)
                if(alphabets[j] == 0)
                    ans += alphabet.charAt(j) + "";
            return ans;
        }
        return ans;
    }
    static class Wordle implements Comparable<Wordle> {
        public int green, yellow, greenVowel, firstGreen, lastGreen;
        public String str;
        public int compareTo(Wordle w) {
            if(this.green == w.green) {
                if(this.yellow == w.yellow) {
                    if(this.firstGreen == w.firstGreen) {
                        if(this.lastGreen == w.lastGreen) {
                            if(this.greenVowel == w.greenVowel) {
                                return this.str.compareTo(w.str);
                            }
                            return w.greenVowel - this.greenVowel;
                        }
                        return w.lastGreen - this.lastGreen;
                    }
                    return w.firstGreen - this.firstGreen;
                }
                return w.yellow - this.yellow;
            }
            return w.green - this.green;
        }
        public Wordle(String s, int g, int y, int gV, int fG, int lG) {
            this.str = s;
            this.green = g;
            this.yellow = y;
            this.greenVowel = gV;
            this.firstGreen = fG;
            this.lastGreen = lG;
        }
    }
}