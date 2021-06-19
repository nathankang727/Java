/*
Start Time: 8:23
End Time: 8:57
*/
package ACSL13_14;
import java.io.*;
public class C1JR_ACSL_Scrabble {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1314C1Jr.in"));
		for(int i = 0; i < 2; i++) {
			String[] word = br.readLine().split(" ");
			int[] wordValue = new int[4];
			for(int j = 0; j < 4; j++) {
				String a = word[j];
				if(a.equals("A") || a.equals("E"))
					a = "1";
				else if(a.equals("D") || a.equals("R"))
					a = "2";
				else if(a.equals("B") || a.equals("M"))
					a = "3";
				else if(a.equals("V") || a.equals("Y"))
					a = "4";
				else if(a.equals("J") || a.equals("X"))
					a = "8";
				wordValue[j] = Integer.parseInt(a);
			}
			for(int j = 0; j < 5; j++) {
				int n = Integer.parseInt(br.readLine());
				int totalPoints = 0;
				boolean doubleWord = false, tripleWord = false;
				int[] tiles = new int[4];
				for(int k = n, l = 0; k < n + 4; k++) {
					tiles[l] = k;
					l++;
				}
				for(int k = 0; k < 4; k++) {
					int a = wordValue[k];
					if(tiles[k] % 3 == 0 && tiles[k] % 2 != 0)
						a *= 2;
					else if(tiles[k] % 5 == 0)
						a *= 3;
					else if(tiles[k] % 7 == 0)
						doubleWord = true;
					else if(tiles[k] % 8 == 0)
						tripleWord = true;
					totalPoints += a;
				}
				if(doubleWord)
					totalPoints *= 2;
				else if(tripleWord)
					totalPoints *= 3;
				System.out.println(totalPoints);
			}
		}
		br.close();
	}
}