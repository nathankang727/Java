package ACSL06_07;
import java.util.*;
import java.io.*;
public class C2IN_TheNextGeneration {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0607C2In.in"));
		for(int i = 0; i < 2; i++) {
			int[][] cells = new int[8][8];
			int liveCells = sc.nextInt();
			for(int j = 0; j < liveCells; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				cells[x][y] = 1;
			}
			int ways = sc.nextInt();
			int[] birthWays = new int[ways];
			for(int j = 0; j < ways; j++)
				birthWays[j] = sc.nextInt();
			int ways2 = sc.nextInt();
			int[] survivalWays = new int[ways2];
			for(int j = 0; j < ways2; j++)
				survivalWays[j] = sc.nextInt();
			for(int j = 0; j < 5; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				String initialStatus = "D";
				int nLiveCells = 0;
				String status = "D";
				if(cells[x][y] == 1)
					initialStatus = "A";
				if(x + 1 < 8 && cells[x + 1][y] == 1)
					nLiveCells++;
				if(x - 1 > 0 && cells[x - 1][y] == 1)
					nLiveCells++;
				if(y + 1 < 8 && cells[x][y + 1] == 1)
					nLiveCells++;
				if(y - 1 > 0 && cells[x][y - 1] == 1)
					nLiveCells++;
				if(x + 1 < 8 && y + 1 < 8 && cells[x + 1][y + 1] == 1)
					nLiveCells++;
				if(x + 1 < 8 && y - 1 > 0 && cells[x + 1][y - 1] == 1)
					nLiveCells++;
				if(x - 1 > 0 && y + 1 < 8 && cells[x - 1][y + 1] == 1)
					nLiveCells++;
				if(x - 1 > 0 && y - 1 > 0 && cells[x - 1][y - 1] == 1)
					nLiveCells++;
				if(initialStatus.equals("D")) {
					for(int k = 0; k < ways; k++) {
						if(birthWays[k] == nLiveCells) {
							status = "A";
							break;
						}
					}
				}
				else {
					for(int k = 0; k < ways2; k++) {
						if(survivalWays[k] == nLiveCells) {
							status = "A";
							break;
						}
					}
				}
				System.out.println(initialStatus + " " + nLiveCells + " " + status);
			}
		}
		sc.close();
	}
}