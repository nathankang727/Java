package ACSL22_23;
import java.util.*;
import java.io.*;
public class C4IN_Targets {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		String targets = br.readLine();
		System.out.println(targetsWithMostArrows(size, targets));
		br.close();
	}
	public static String targetsWithMostArrows(int size, String targets) {
		String[] rawInput = targets.split(" ");
		int[] xCoor = new int[rawInput.length];
		int[] yCoor = new int[rawInput.length];
		boolean[][] grid = new boolean[size][size];
		for(int i = 0; i < rawInput.length; i++) {
			xCoor[i] = Integer.parseInt(rawInput[i].substring(0, 1));
			yCoor[i] = Integer.parseInt(rawInput[i].substring(1));
			grid[xCoor[i]][yCoor[i]] = true;
		}
		int[] arrows = new int[rawInput.length];
		int max = 0;
		int[] directionX = {-1, -1, -1, 0, 0, 1, 1, 1};
		int[] directionY = {-1, 0, 1, -1, 1, -1, 0, 1};
		for(int i = 0; i < rawInput.length; i++) {
			for(int j = 0; j < 8; j++) {
				int x = xCoor[i];
				int y = yCoor[i];
				boolean didBreak = false;
				x += directionX[j];
				y += directionY[j];
				while(x >= 0 && y >= 0 && x < size && y < size) {
					if(grid[x][y]) {
						didBreak = true;
						break;
					}
					x += directionX[j];
					y += directionY[j];
				}
				if(!didBreak)
					++arrows[i];
			}
			if(arrows[i] > max)
				max = arrows[i];
		}
		ArrayList<String> results = new ArrayList<String>();
		for(int i = 0; i < rawInput.length; i++)
			if(arrows[i] == max)
				results.add(rawInput[i]);
		Collections.sort(results);
		String finalResult = results.get(0);
		for(int i = 1; i < results.size(); i++)
			finalResult += " " + results.get(i);
		return finalResult;
	}
}