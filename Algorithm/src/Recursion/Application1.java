package Recursion;
public class Application1 {
	private static int N = 8;
    private static int [] [] maze = {
            {0, 0, 0, 0, 0, 0, 0, 1},
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
    };
	public static void main(String[] args) {
		findPath(0, 0);
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println("");
		}
	}
	public static boolean findPath(int x, int y) {
		if(x >= N || x < 0 || y >= N || y < 0)
			return false;
		else if(maze[x][y] != 0)
			return false;
		else if(x == N - 1 && y == N - 1) {
			maze[x][y] = 3;
			return true;
		}
		else {
			maze[x][y] = 3;
			if(findPath(x, y + 1) || findPath(x + 1, y) || findPath(x - 1, y) || findPath(x, y - 1))
				return true;
			else {
				maze[x][y] = 2;
				return false;
			}
		}
	}
}