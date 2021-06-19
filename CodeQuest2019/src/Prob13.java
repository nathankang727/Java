import java.util.*;
import java.io.*;
public class Prob13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	int r = Integer.parseInt(st.nextToken());
        	int c = Integer.parseInt(st.nextToken());
        	int b = Integer.parseInt(st.nextToken());
        	int[][] grid = new int[r][c];
        	for(int j = 0; j < r; j++)
        		for(int k = 0; k < c; k++)
        			grid[j][k] = -1;
        	for(int j = 0; j < b; j++) {
        		st = new StringTokenizer(br.readLine());
        		int x = Integer.parseInt(st.nextToken());
        		int y = Integer.parseInt(st.nextToken());
        		grid[x][y] = 9;
        	}
        	for(int j = 0; j < r; j++) {
        		for(int k = 0; k < c; k++) {
        			if(grid[j][k] == 9)
        				continue;
        			int cnt = 0;
        			if(j - 1 >= 0 && grid[j - 1][k] == 9)
        				++cnt;
        			if(k - 1 >= 0 && grid[j][k - 1] == 9)
        				++cnt;
        			if(j + 1 < r && grid[j + 1][k] == 9)
        				++cnt;
        			if(k + 1 < c && grid[j][k + 1] == 9)
        				++cnt;
        			if(j - 1 >= 0 && k - 1 >= 0 && grid[j - 1][k - 1] == 9)
        				++cnt;
        			if(j - 1 >= 0 && k + 1 < c && grid[j - 1][k + 1] == 9)
        				++cnt;
        			if(j + 1 < r && k - 1 >= 0 && grid[j + 1][k - 1] == 9)
        				++cnt;
        			if(j + 1 < r && k + 1 < c && grid[j + 1][k + 1] == 9)
        				++cnt;
        			grid[j][k] = cnt;
        		}
        	}
        	for(int j = 0; j < r; j++) {
        		for(int k = 0; k < c; k++) {
        			if(grid[j][k] < 9)
        				System.out.print(grid[j][k]);
        			else
        				System.out.print("*");
        		}
        		System.out.println();
        	}
        }
        br.close();
        //Check.check("Prob13.out.txt");
	}
}