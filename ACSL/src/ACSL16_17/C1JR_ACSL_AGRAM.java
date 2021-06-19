package ACSL16_17;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_AGRAM {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1617C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			int opponentRank = sc.nextInt();
			String opponentSuit = sc.next();
			int[] ranks = new int[5];
			String[] suits = new String[5];
			for(int j = 0; j < 5; j++) {
				ranks[j] = sc.nextInt();
				suits[j] = sc.next();
			}
			int lowestRank = 0;
			boolean isSuit = false;
			for(int j = 0; j < 5; j++) {
				if(suits[j].equals(opponentSuit) && ranks[j] > opponentRank) {
					System.out.println(ranks[j] + " " + suits[j]);
					isSuit = true;
					break;
				}
				else if(suits[j].equals(opponentSuit) && ranks[j] <= opponentRank && !isSuit) {
					lowestRank = ranks[j];
				}
			}
			if(lowestRank != 0 && !isSuit)
				System.out.println(lowestRank + " " + opponentSuit);
			else if(lowestRank == 0 && !isSuit)
				System.out.println("NONE");
		}
		sc.close();
	}
}