import java.io.*;
public class Prob17 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob172.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	int x = Integer.parseInt(br.readLine());
        	int[][] grid = new int[10][10];
        	int[][] grid2 = new int[10][10];
        	for(int j = 0; j < 10; j++) {
        		String input = br.readLine();
        		for(int k = 0; k < 10; k++) {
        			grid[j][k] = Integer.parseInt(input.substring(k, k + 1));
        			grid2[j][k] = Integer.parseInt(input.substring(k, k + 1));
        		}
        	}
        	for(int a = 0; a < x; a++) {
        		for(int j = 0; j < 10; j++) {
        			for(int k = 0; k < 10; k++) {
        				int cnt = 0;
            			if(j - 1 >= 0 && grid[j - 1][k] == 1)
            				++cnt;
            			if(k - 1 >= 0 && grid[j][k - 1] == 1)
            				++cnt;
            			if(j + 1 < 10 && grid[j + 1][k] == 1)
            				++cnt;
            			if(k + 1 < 10 && grid[j][k + 1] == 1)
            				++cnt;
            			if(j - 1 >= 0 && k - 1 >= 0 && grid[j - 1][k - 1] == 1)
            				++cnt;
            			if(j - 1 >= 0 && k + 1 < 10 && grid[j - 1][k + 1] == 1)
            				++cnt;
            			if(j + 1 < 10 && k - 1 >= 0 && grid[j + 1][k - 1] == 1)
            				++cnt;
            			if(j + 1 < 10 && k + 1 < 10 && grid[j + 1][k + 1] == 1)
            				++cnt;
            			if(grid[j][k] == 1 && (cnt < 2 || cnt >= 4))
            				grid2[j][k] = 0;
            			if(grid[j][k] == 0 && cnt == 3)
            				grid2[j][k] = 1;
        			}
        		}
        		for(int j = 0; j < 10; j++)
        			for(int k = 0; k < 10; k++)
        				grid[j][k] = grid2[j][k];
        	}
        	for(int j = 0; j < 10; j++) {
        		for(int k = 0; k < 10; k++)
        			pw.print(grid[j][k]);
        		pw.println();
        	}
        }
        br.close();
        pw.close();
        Check.check("Prob172.out.txt");
	}
}