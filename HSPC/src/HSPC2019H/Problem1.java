package HSPC2019H;
import java.io.*;
public class Problem1 {
	static char[][] canvas;
	static int h;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		h = Integer.parseInt(br.readLine());
		canvas = new char[h][];
		for(int i = 0; i < h; i++) {
			String[] s = br.readLine().split("");
			canvas[i] = new char[s.length];
			for(int j = 0; j < s.length; j++)
				canvas[i][j] = s[j].charAt(0);
		}
		int cnt = 0;
		for(int i = 0; i < h; i++) {
			for(int j = 0; j < canvas[i].length; j++) {
				if(canvas[i][j] != ' ') {
					dfs(i, j, canvas[i][j]);
					++cnt;
				}
			}
		}
		System.out.println(cnt);
	}
	public static void dfs(int x, int y, char c) {
		if(x < 0 || y < 0 || x >= h || y >= canvas[x].length || canvas[x][y] != c)
			return;
		canvas[x][y] = ' ';
		dfs(x - 1, y, c);
		dfs(x + 1, y, c);
		dfs(x, y - 1, c);
		dfs(x, y + 1, c);
	}
}