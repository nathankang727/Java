package ACSL04_05;
import java.util.*;
import java.io.*;
public class C3JR_TheSoundexIndexingSystem {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("0405C3Jr.in")));
		for(int i = 0; i < 7; i++) {
			String s = br.readLine();
			String result = s.charAt(0) + "";
			s = s.substring(1);
			s = s.replaceAll("[A, E, I, O, U, H, W, Y]", "");
			Map<String, Integer> m = new HashMap<String, Integer>();
			m.put("*", 0);
			m.put("B", 1);
			m.put("F", 1);
			m.put("P", 1);
			m.put("V", 1);
			m.put("C", 2);
			m.put("G", 2);
			m.put("J", 2);
			m.put("K", 2);
			m.put("Q", 2);
			m.put("S", 2);
			m.put("X", 2);
			m.put("Z", 2);
			m.put("D", 3);
			m.put("T", 3);
			m.put("L", 4);
			m.put("M", 5);
			m.put("N", 5);
			m.put("R", 6);
			if(s.length() < 3) {
				int n = s.length();
				for(int j = 1; j <= 3 - n; j++)
					s += "*";
			}
			String firstThree = s.substring(0, 3);
			for(int j = 0; j < 3; j++)
				result += String.valueOf(m.get(firstThree.substring(j, j + 1)));
			System.out.println(result);
		}
		br.close();
	}
}