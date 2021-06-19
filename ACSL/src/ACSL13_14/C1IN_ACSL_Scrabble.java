/*
Start Time: 1:53
End Time: 2:14
*/
package ACSL13_14;
import java.util.*;
import java.io.*;
public class C1IN_ACSL_Scrabble {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1314C1IN.in"));
		String word = sc.nextLine();
		int[] wordValue = new int[4];
		for(int i = 0, j = 0; i <= 6; i += 2) {
			if(word.substring(i, i + 1).equals("A") || word.substring(i, i + 1).equals("E"))
				wordValue[j] = 1;
			else if(word.substring(i, i + 1).equals("D") || word.substring(i, i + 1).equals("R"))
				wordValue[j] = 2;
			else if(word.substring(i, i + 1).equals("B") || word.substring(i, i + 1).equals("M"))
				wordValue[j] = 3;
			else if(word.substring(i, i + 1).equals("V") || word.substring(i, i + 1).equals("Y"))
				wordValue[j] = 4;
			else if(word.substring(i, i + 1).equals("J") || word.substring(i, i + 1).equals("X"))
				wordValue[j] = 8;
			j++;
		}
		for(int i = 0; i < 5; i++) {
			int n = sc.nextInt();
			int totalPoints = 0;
			boolean doubleWord = false, tripleWord = false;
			int[] tiles = new int[4];
			String direction = sc.next();
			if(direction.equals("H")) {
				for(int j = n, k = 0; j < n + 4; j++) {
					tiles[k] = j;
					k++;
				}
			}
			else {
				for(int j = n, k = 0; j < n + 40; j += 10) {
					tiles[k] = j;
					k++;
				}
			}
			for(int j = 0; j < 4; j++) {
				int a = wordValue[j];
				if(tiles[j] % 3 == 0 && tiles[j] % 2 != 0)
					a *= 2;
				else if(tiles[j] % 5 == 0)
					a *= 3;
				else if(tiles[j] % 7 == 0)
					doubleWord = true;
				else if(tiles[j] % 8 == 0)
					tripleWord = true;
				totalPoints += a;
			}
			if(doubleWord)
				totalPoints *= 2;
			else if(tripleWord)
				totalPoints *= 3;
			System.out.println(totalPoints);
		}
		sc.close();
	}
}