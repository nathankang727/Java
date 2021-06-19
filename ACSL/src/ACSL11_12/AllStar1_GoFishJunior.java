package ACSL11_12;
import java.util.*;
import java.io.*;
public class AllStar1_GoFishJunior {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1112AllStar1.in"));
		for(int a = 0; a < 2; a++) {
			ArrayList<Integer> opponent = new ArrayList<Integer>();
			ArrayList<Integer> player = new ArrayList<Integer>();
			ArrayList<Integer> deck = new ArrayList<Integer>();
			for(int i = 0; i < 7; i++)
				opponent.add(sc.nextInt());
			for(int i = 0; i < 7; i++)
				player.add(sc.nextInt());
			for(int i = 0; i < 5; i++)
				deck.add(sc.nextInt());
			for(int i = 0; i < 5; i++) {
				int n = sc.nextInt();
				int countRemovedNs = 0;
				for(int j = opponent.size() - 1; j > -1; j--) {
					if(opponent.get(j) == n) {
						countRemovedNs++;
						int o = opponent.remove(j);
						player.add(o);
					}
				}
				if(countRemovedNs == 0) {
					int d = deck.remove(0);
					player.add(d);
				}
				int count1s = 0;
				int count2s = 0;
				int count3s = 0;
				int count4s = 0;
				int count5s = 0;
				for(int j = 0; j < player.size(); j++) {
					if(player.get(j) == 1)
						count1s++;
					else if(player.get(j) == 2)
						count2s++;
					else if(player.get(j) == 3)
						count3s++;
					else if(player.get(j) == 4)
						count4s++;
					else
						count5s++;
				}
				for(int j = player.size() - 1; j >= 0; j--) {
					if(player.get(j) == 1 && count1s >= 4)
						player.remove(j);
					else if(player.get(j) == 2 && count2s >= 4)
						player.remove(j);
					else if(player.get(j) == 3 && count3s >= 4)
						player.remove(j);
					else if(player.get(j) == 4 && count4s >= 4)
						player.remove(j);
					else if(player.get(j) == 5 && count5s >= 4)
						player.remove(j);
				}
				int countNs = 0;
				for(int j = 0; j < player.size(); j++)
					if(player.get(j) == n)
						countNs++;
				System.out.println(countNs);
			}
		}
		sc.close();
	}
}