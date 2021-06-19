package ACSL17_18;
import java.util.*;
import java.io.*;
public class C1IN_ACSL_NinetyNine {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1718C1In.in"));
		for(int i = 0; i < 10; i++) {
			int points = sc.nextInt();
			String[] pD = new String[7];
			String[] dD = new String[7];
			int[] playerDeck = new int[7];
			int[] dealerDeck = new int[3];
			pD[0] = sc.next();
			pD[1] = sc.next();
			pD[2] = sc.next();
			for(int j = 0; j < 3; j++) {
				pD[j + 3] = sc.next();
				dD[j] = sc.next();
			}
			pD[6] = sc.next();
			for(int j = 0; j < 7; j++)
				playerDeck[j] = Integer.parseInt(pD[j].replace("T", "10").replace("J", "11").replace("Q", "12").replace("K", "13").replace("A", "14"));
			for(int j = 0; j < 3; j++)
				dealerDeck[j] = Integer.parseInt(dD[j].replace("T", "10").replace("J", "11").replace("Q", "12").replace("K", "13").replace("A", "14"));
			int dIndex = 0;
			int pIndex = 2;
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			boolean dealerWins = false;
			while(points <= 99) {
				int max = 0;
				int ind = 0;
				for(int j = 0; j <= pIndex; j++) {
					if(max < playerDeck[j] && !(indexes.contains(j))) {
						max = playerDeck[j];
						ind = j;
					}
				}
				pIndex++;
				indexes.add(ind);
				if(max == 14 && points + 14 > 99)
					points++;
				else if(max == 9)
					points += 0;
				else if(max == 10)
					points -= 10;
				else
					points += max;
				if(points > 99) {
					dealerWins = true;
					break;
				}
				if(dealerDeck[dIndex] == 14 && points + 14 > 99)
					points++;
				else if(dealerDeck[dIndex] == 9)
					points += 0;
				else if(dealerDeck[dIndex] == 10)
					points -= 10;
				else
					points += dealerDeck[dIndex];
				dIndex++;
			}
			if(dealerWins)
				System.out.println(points + ", dealer");
			else
				System.out.println(points + ", player");
			
		}
		sc.close();
	}
}