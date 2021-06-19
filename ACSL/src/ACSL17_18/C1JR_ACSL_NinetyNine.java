package ACSL17_18;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_NinetyNine {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1718C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			int points = sc.nextInt();
			int[] player = new int[7];
			int[] dealer = new int[3];
			player[0] = sc.nextInt();
			player[1] = sc.nextInt();
			player[2] = sc.nextInt();
			for(int j = 0; j < 3; j++) {
				player[j + 3] = sc.nextInt();
				dealer[j] = sc.nextInt();
			}
			player[6] = sc.nextInt();
			boolean dealerWins = false;
			int n = 0;
			while(points <= 99) {
				if(player[n] == 0 && points + 11 <= 99)
					points += 11;
				else if(player[n] == 0 && points + 11 > 99)
					points += 1;
				else if(player[n] == 9)
					points += 0;
				else if(player[n] == 4)
					points -= 10;
				else
					points += player[n];
				if(points > 99) {
					dealerWins = true;
					break;
				}
				if(dealer[n] == 0 && points + 11 <= 99)
					points += 11;
				else if(dealer[n] == 0 && points + 11 > 99)
					points += 1;
				else if(dealer[n] == 9)
					points += 0;
				else if(dealer[n] == 4)
					points -= 10;
				else
					points += dealer[n];
				n++;
			}
			if(dealerWins)
				System.out.println(points + ", dealer");
			else
				System.out.println(points + ", player");
		}
		sc.close();
	}
}