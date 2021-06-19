package ACSL16_17;
import java.util.*;
import java.io.*;
public class C1IN_ACSL_Agram {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1617C1In.in"));
		for(int i = 0; i < 10; i++) {
			String opponentCard = sc.next();
			int opponentRank = convert(opponentCard.charAt(0));
			String opponentSuit = opponentCard.substring(1);
			int[] playerRank = new int[5];
			String[] playerSuit = new String[5];
			for(int j = 0; j < 5; j++) {
				String playerCard = sc.next();
				playerRank[j] = convert(playerCard.charAt(0));
				playerSuit[j] = playerCard.substring(1);
			}
			int min = 14;
			int min2 = 14;
			int max = 14;
			int[] index = new int[3];
			for(int j = 0; j < 5; j++) {
				if(playerRank[j] > opponentRank && playerRank[j] < max && playerSuit[j].equals(opponentSuit)) {
					index[0] = j;
					max = playerRank[j];
				}
				if(playerRank[j] < min2 && playerSuit[j].equals(opponentSuit)) {
					index[1] = j;
					min2 = playerRank[j];
				}
				if(playerRank[j] < min) {
					index[2] = j;
					min = playerRank[j];
				}
			}
			if(max != 14)
				System.out.println(convertBack(max) + playerSuit[index[0]]);
			else if(max == 14 && min2 != 14)
				System.out.println(convertBack(min2) + playerSuit[index[1]]);
			else
				System.out.println(convertBack(min) + playerSuit[index[2]]);
		}
		sc.close();
	}
	public static int convert(char c) {
		if(c == 'A')
			return 1;
		else if(c == 'T')
			return 10;
		else if(c == 'J')
			return 11;
		else if(c == 'Q')
			return 12;
		else if(c == 'K')
			return 13;
		else
			return Character.getNumericValue(c);
	}
	public static char convertBack(int c) {
		if(c == 1)
			return 'A';
		else if(c == 10)
			return 'T';
		else if(c == 11)
			return 'J';
		else if(c == 12)
			return 'Q';
		else if(c == 13)
			return 'K';
		else
			return String.valueOf(c).charAt(0);
	}
}