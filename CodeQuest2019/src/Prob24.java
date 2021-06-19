import java.io.*;
public class Prob24 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob24.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	int[][] sudoku = new int[9][9];
        	for(int j = 0; j < 9; j++) {
        		String input = br.readLine();
        		for(int k = 0; k < 9; k++)
        			if(!input.substring(k, k + 1).equals("_"))
        				sudoku[j][k] = Integer.parseInt(input.substring(k, k + 1));
        	}
        	solve(sudoku, 0, 0);
        	for(int j = 0; j < 9; j++) {
                for (int k = 0; k < 9; k++)
                    pw.print(sudoku[j][k]);
                pw.println();
            }
        }
        br.close();
        pw.close();
        Check.check("Prob24.out.txt");
	}
	public static boolean solve(int grid[][], int r, int c) {
		if(r == 8 && c == 9)
			return true;
		if (c == 9) {
			++r;
			c = 0;
		}
		if (grid[r][c] != 0)
			return solve(grid, r, c + 1);
		for(int i = 1; i < 10; i++) {
			if(check(grid, r, c, i)) {
				grid[r][c] = i;
				if(solve(grid, r, c + 1))
					return true;
			}
			grid[r][c] = 0;
		}
		return false;
	}
	public static boolean check(int[][] grid, int r, int c, int n) {
		for(int i = 0; i < 9; i++)
			if(grid[r][i] == n)
				return false;
		for(int i = 0; i < 9; i++)
			if(grid[i][c] == n)
				return false;
		int startR = r - r % 3; 
		int startC = c - c % 3;
		for(int i = 0; i < 3; i++)
			for(int j = 0; j < 3; j++)
				if(grid[i + startR][j + startC] == n)
					return false;
		return true;
	}
}