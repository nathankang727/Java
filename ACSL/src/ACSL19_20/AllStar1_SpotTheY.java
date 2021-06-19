package ACSL19_20;
import java.util.*;
import java.io.*;
public class AllStar1_SpotTheY {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	for(int i = 0; i < 13; i++) {
    		String line = br.readLine();
    		int result = spot_the_y(line);
    		System.out.println(result);
    	}
    	br.close();
    }
    public static int spot_the_y(String line) {
    	StringTokenizer st = new StringTokenizer(line);
    	int n = Integer.parseInt(st.nextToken());
    	int[][] grid = new int[n][n];
        boolean isCircleTurn = true;
        int ans = 0;
        while(st.hasMoreTokens()) {
        	int input = Integer.parseInt(st.nextToken()) - 1;
        	if(isCircleTurn && grid[input / n][input % n] == 0)
        		grid[input / n][input % n] = 1;
        	else if(!isCircleTurn && grid[input / n][input % n] == 0)
        		grid[input / n][input % n] = 2;
        	else
        		grid[input / n][input % n] = 0;
        	if(y1(n, grid) > 0)
        		return y1(n, grid);
        	else if(y2(n, grid) > 0)
        		return y2(n, grid);
        	else if(y3(n, grid) > 0)
        		return y3(n, grid);
        	else if(y4(n, grid) > 0)
        		return y4(n, grid);
        	isCircleTurn = !isCircleTurn;
        }
        return ans;
    }
    public static int y1(int n, int[][] g) {
    	for(int i = 0; i < n - 2; i++)
    		for(int j = 0; j < n - 2; j++)
    			if(g[i][j] != 0 && g[i][j] == g[i][j + 2] && g[i][j] == g[i + 1][j + 1] && g[i][j] == g[i + 2][j + 1])
    				return (i * n + j + 1) + (i * n + j + 3) + ((i + 1) * n + j + 2) + ((i + 2) * n + j + 2);
    	return 0;
    }
    public static int y2(int n, int[][] g) {
    	for(int i = 0; i < n - 2; i++)
    		for(int j = 0; j < n - 2; j++)
    			if(g[i][j] != 0 && g[i][j] == g[i + 2][j] && g[i][j] == g[i + 1][j + 1] && g[i][j] == g[i + 1][j + 2])
    				return (i * n + j + 1) + ((i + 2)* n + j + 1) + ((i + 1) * n + j + 2) + ((i + 1) * n + j + 3);
    	return 0;
    }
    public static int y3(int n, int[][] g) {
    	for(int i = 0; i < n - 2; i++)
    		for(int j = 0; j < n - 2; j++)
    			if(g[i + 1][j] != 0 && g[i + 1][j] == g[i][j + 2] && g[i + 1][j] == g[i + 2][j + 2] && g[i + 1][j] == g[i + 1][j + 1])
    				return ((i + 1) * n + j + 1) + (i * n + j + 3) + ((i + 2) * n + j + 3) + ((i + 1) * n + j + 2);
    	return 0;
    }
    public static int y4(int n, int[][] g) {
    	for(int i = 0; i < n - 2; i++)
    		for(int j = 0; j < n - 2; j++)
    			if(g[i][j + 1] != 0 && g[i][j + 1] == g[i + 2][j] && g[i][j + 1] == g[i + 1][j + 1] && g[i][j + 1] == g[i + 2][j + 2])
    				return (i * n + j + 2) + ((i + 2) * n + j + 1) + ((i + 1) * n + j + 2) + ((i + 2) * n + j + 3);
    	return 0;
    }
}