package Recursion;
public class BlobCounting {
	private static int n = 8;
	private static int [] [] grid = {
	   {1, 0, 0, 0, 0, 0, 0, 1},
	   {0, 1, 1, 0, 0, 1, 0, 0},
	   {1, 1, 0, 0, 1, 0, 1, 0},
	   {0, 0, 0, 0, 0, 1, 0, 0},
	   {0, 1, 0, 1, 0, 1, 0, 0},
	   {0, 1, 0, 1, 0, 1, 0, 0},
	   {1, 0, 0, 0, 1, 0, 0, 1},
	   {0, 1, 1, 0, 0, 1, 1, 1}
	};
	public static void main(String[] args) {
		int max = 0;	
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int a = bc(i, j);
				if(a > 0 && max < a)
					max = a;
			}
		}
		System.out.println(max);
	}
	public static int bc(int x, int y) {
		if(x < 0 || y < 0 || x >= grid[0].length || y >= grid.length)
			return 0;
		else if(grid[x][y] != 1)
			return 0;
		else {
			grid[x][y] = 2;
			return 1 + bc(x, y + 1) + bc(x, y - 1) + bc(x + 1, y) + bc(x - 1, y) +
			bc(x - 1, y + 1) + bc(x + 1, y + 1) + bc(x - 1, y - 1) + bc(x + 1, y - 1);
		}
	}
}