package ACSL09_10;
import java.io.*;
public class AllStar1_ACSL_BridgeJR {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("0910AllStar1.in")));
		for(int i = 0; i < 10; i++) {
			String[] deck = br.readLine().split(" ");
			boolean[] hasEnough = new boolean[4];
			if(deck[0].length() >= 5)
				hasEnough[0] = true;
			if(deck[1].length() >= 5)
				hasEnough[1] = true;
			if(deck[2].length() >= 3)
				hasEnough[2] = true;
			if(deck[3].length() >= 3)
				hasEnough[3] = true;
			int points = 0;
			for(int j = 0; j < 4; j++) {
				for(int k = 0; k < deck[j].length(); k++) {
					if(deck[j].charAt(k) == 'A')
						points += 4;
					else if(deck[j].charAt(k) == 'K')
						points += 3;
					else if(deck[j].charAt(k) == 'Q')
						points += 2;
					else if(deck[j].charAt(k) == 'J')
						points += 1;
				}
			}
			if(points < 13)
				System.out.println(points + ", PASS");
			else {
				for(int j = 0; j < 4; j++) {
					if(hasEnough[j] && j == 0) {
						System.out.println(points + ", 1S");
						break;
					}
					else if(hasEnough[j] && j == 1) {
						System.out.println(points + ", 1H");
						break;
					}
					else if(hasEnough[j] && j == 2) {
						System.out.println(points + ", 1D");
						break;
					}
					else if(hasEnough[j] && j == 3) {
						System.out.println(points + ", 1C");
						break;
					}
				}
			}
		}
		br.close();
	}
}