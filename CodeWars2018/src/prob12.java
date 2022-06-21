import java.util.*;
import java.io.*;
public class prob12 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		String[] c = new String[Integer.parseInt(br.readLine())];
		for(int i = 0; i < c.length; i++)
			c[i] = br.readLine();
		Arrays.sort(c);
		String[] p = new String[Integer.parseInt(br.readLine())];
		for(int i = 0; i < p.length; i++)
			p[i] = br.readLine();
		int[][] cCount = new int[c.length][26];
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[i].length(); j++) {
				if(c[i].charAt(j) == ' ')
					continue;
				++cCount[i][c[i].charAt(j) - 'A'];
			}
		}
		for(int i = 0; i < p.length; i++) {
			int[] pCount = new int[26];
			for(int j = 0; j < p[i].length(); j++) {
				if(p[i].charAt(j) == ' ')
					continue;
				++pCount[p[i].charAt(j) - 'A'];
			}
			boolean didBreak = false;
			for(int j = 0; j < c.length; j++) {
				if(Arrays.toString(cCount[j]).equals(Arrays.toString(pCount))) {
					System.out.println("Yes: " + c[j]);
					didBreak = true;
					break;
				}
			}
			if(!didBreak)
				System.out.println("No: No matching case");
		}
	}
}