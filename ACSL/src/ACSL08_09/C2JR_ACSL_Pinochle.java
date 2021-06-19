package ACSL08_09;
import java.util.*;
import java.io.*;
public class C2JR_ACSL_Pinochle {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0809C2Jr.in"));
		for(int i = 0; i < 9; i++) {
			String[] cards = new String[4];
			int points = 0;
			for(int j = 0; j < 4; j++)
				cards[j] = sc.next();
			int[][] suits = new int[4][4];
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < cards[j].length(); k++) {
					if(cards[j].charAt(k) == 'A')
						suits[j][0]++;
					else if(cards[j].charAt(k) == 'K')
						suits[j][1]++;
					else if(cards[j].charAt(k) == 'Q')
						suits[j][2]++;
					else if(cards[j].charAt(k) == 'J')
						suits[j][3]++;
				}
			}
			if(suits[0][3] >= 2 && suits[2][2] >= 2)
				points += 34;
			if(suits[0][3] >= 1 && suits[2][2] >= 1)
				points += 4;
			if(suits[0][0] >= 1 && suits[1][0] >= 1 && suits[2][0] >= 1 && suits[3][0] >= 1)
				points += 10;
			if(suits[0][0] >= 2 && suits[1][0] >= 2 && suits[2][0] >= 2 && suits[3][0] >= 2)
				points += 100;
			if(suits[0][1] >= 1 && suits[1][1] >= 1 && suits[2][1] >= 1 && suits[3][1] >= 1)
				points += 8;
			if(suits[0][1] >= 2 && suits[1][1] >= 2 && suits[2][1] >= 2 && suits[3][1] >= 2)
				points += 80;
			if(suits[0][2] >= 1 && suits[1][2] >= 1 && suits[2][2] >= 1 && suits[3][2] >= 1)
				points += 6; 
			if(suits[0][2] >= 2 && suits[1][2] >= 2 && suits[2][2] >= 2 && suits[3][2] >= 2)
				points += 60;
			if(suits[0][3] >= 1 && suits[1][3] >= 1 && suits[2][3] >= 1 && suits[3][3] >= 1)
				points += 4;
			if(suits[0][3] >= 2 && suits[1][3] >= 2 && suits[2][3] >= 2 && suits[3][3] >= 2)
				points += 44;
			System.out.println(points);
		}
		sc.close();
	}
}