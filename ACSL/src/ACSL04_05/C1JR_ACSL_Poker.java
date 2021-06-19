/*
Start Time: 10:13
End Time: 10:36
*/
package ACSL04_05;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_Poker {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0405C1Jr.in"));
		for(int i = 0; i < 9; i++) {
			int[] cards = new int[5];
			int[] duplicates = {1, 1, 1, 1};
			int fours = 0;
			int threes = 0;
			int twos = 0;
			for(int j = 0; j < 5; j++) {
				cards[j] = sc.nextInt() % 13;
			}
			for(int j = 0; j < 5; j++)
				for(int k = j + 1; k < 5; k++)
					if(cards[j] == cards[k])
						duplicates[j]++;
			for(int j = 0; j < 4; j++) {
				if(duplicates[j] == 2)
					twos++;
				else if(duplicates[j] == 3)
					threes++;
				else if(duplicates[j] == 4)
					fours++;
			}
			if(twos == 1 && threes == 0)
				System.out.println("PAIR");
			else if(threes == 1 && twos == 2)
				System.out.println("FULL HOUSE");
			else if(threes == 1 && twos == 1 && fours == 0)
				System.out.println("THREE OF A KIND");
			else if(fours == 1)
				System.out.println("FOUR OF A KIND");
			else
				System.out.println("NONE");
		}
		sc.close();
	}
}