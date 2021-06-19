package ACSL02_03;
import java.util.*;
import java.io.*;
public class C3JR_StringsAndThings {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0203C3Jr.in"));
		Map<String, Integer> map = new HashMap<String, Integer>();
		int c = 0;
		int c2 = 0;
		int longestLength = 0;
		Map<Character, Integer> alphabet = new HashMap<Character, Integer>();
		while(sc.hasNext()) {
			String s = sc.next();
			if(map.containsKey(s))
				map.put(s, map.get(s) + 1);
			else
				map.put(s, 1);
			c++;
			if(s.length() > longestLength)
				longestLength = s.length();
			for(int i = 0; i < s.length(); i++) {
				if(alphabet.containsKey(s.charAt(i)))
					alphabet.put(s.charAt(i), alphabet.get(s.charAt(i)) + 1);
				else
					alphabet.put(s.charAt(i), 1);
			}
		}
		System.out.println(c);
		for(String s: map.keySet())
			if(longestLength == s.length())
				System.out.print(s + " ");
		System.out.println();
		for(char C: alphabet.keySet())
			if(alphabet.get(C) > 0)
				c2++;
		System.out.println(c2);
		int max = 0;
		char cha = ' ';
		for(char ch: alphabet.keySet()) {
			if(max < alphabet.get(ch)) {
				cha = ch;
				max = alphabet.get(ch);
			}
		}
		System.out.println(cha);
		int max2 = 0;
		String str = "";
		for(String s: map.keySet()) {
			if(max2 < map.get(s) && !(s.equals("THE"))) {
				str = s;
				max2 = map.get(s);
			}
		}
		System.out.println(str);
		sc.close();
	}
}