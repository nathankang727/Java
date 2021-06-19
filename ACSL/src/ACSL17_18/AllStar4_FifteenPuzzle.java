package ACSL17_18;
import java.util.*;
import java.io.*;
public class AllStar4_FifteenPuzzle {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1718AllStar4.in")));
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			int row = convertRow(index);
			int col = convertCol(index);
			String com = st.nextToken();
			ArrayList<Character> commands = new ArrayList<Character>();
			for(int j = 0; j < com.length(); j++)
				commands.add(com.charAt(j));
			while(commands.size() > 0) {
				char command = commands.remove(0);
				if(command == 'B')
					row++;
				else if(command == 'A')
					row--;
				else if(command == 'R')
					col++;
				else if(command == 'L')
					col--;
				if(col > 3)
					col = 3;
				else if(col < 0)
					col = 0;
				if(row > 3)
					row = 3;
				else if(row < 0)
					row = 0;
			}
			System.out.println(convertNum(row, col));
		}
		br.close();
	}
	public static int convertRow(int n) {
		if(n == 1 || n == 2 || n == 3 || n == 4)
			return 0;
		else if(n == 5 || n == 6 || n == 7 || n == 8)
			return 1;
		else if(n == 9 || n == 10 || n == 11 || n == 12)
			return 2;
		return 3;
	}
	public static int convertCol(int n) {
		if(n == 1 || n == 5 || n == 9 || n == 13)
			return 0;
		else if(n == 2 || n == 6 || n == 10 || n == 14)
			return 1;
		else if(n == 3 || n == 7 || n == 11 || n == 15)
			return 2;
		return 3;
	}
	public static int convertNum(int x, int y) {
		int[][] arr = new int[4][4];
		int n = 1;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
				arr[i][j] = n;
				n++;
			}
		}
		return arr[x][y];
	}
}