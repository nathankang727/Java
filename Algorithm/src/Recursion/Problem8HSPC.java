package Recursion;
import java.util.*;
public class Problem8HSPC {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) {
			int count = 0;
			int a = in.nextInt();in.nextLine();
			int b = in.nextInt();in.nextLine();
			int[][] map = new int[a][b];
			for(int i = 0; i < a; i++) {
				for(int j = 0; j < b; j++) {
					map[i][j] = in.nextInt();
				}
				in.nextLine();
			}
			for(int i = 0; i < a; i++) {
				for(int j = 0; j < b; j++) {
					int c = countIsland(map, i, j);
					if(c > 0)
						count++;
				}
			}
			System.out.println(count);
			in.close();
		}
	}
	public static int countIsland (int[][] map, int x, int y) {
		if(x < 0 || y < 0 || x >= map[0].length || y >= map.length)
			return 0;
		else if(map[x][y] != 1)
			return 0;
		else {
			map[x][y] = 2;
			return 1 + countIsland(map, x + 1, y) + countIsland(map, x, y + 1) + countIsland(map, x - 1, y) + countIsland(map, x, y - 1);
		}
	}
}