package ACSL20_21;
import java.util.*;
import java.io.*;
public class C2JR_LexStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		s = s.toLowerCase();
        s = s.replaceAll("[^a-z]", "");
        String ans = "";
        Map<Character, Integer> map = new TreeMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++) {
            if(!map.containsKey(s.charAt(i)))
                map.put(s.charAt(i), 1);
            else
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
        }
        while(!map.isEmpty()) {
        	for(char c : map.keySet()) {
        		map.put(c, map.get(c) - 1);
        		ans += c + "";
        	}
        	String alphabet = "abcdefghijklmnopqrstuvwxyz";
        	for(int i = 0; i < 26; i++) {
        		if(map.containsKey(alphabet.charAt(i)) && map.get(alphabet.charAt(i)) == 0)
        			map.remove(alphabet.charAt(i));
        	}
        }
        String[] arr = ans.split("");
        for(int i = 0; i < arr.length - 1; i++)
        	if(arr[i].equals(arr[i + 1]))
        		arr[i] = "";
        ans = "";
        for(int i = 0; i < arr.length; i++)
        	ans += arr[i];
        System.out.println(ans);
		br.close();
	}
}