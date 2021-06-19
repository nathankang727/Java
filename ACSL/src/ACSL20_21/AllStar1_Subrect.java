package ACSL20_21;
import java.util.*;
import java.io.*;
public class AllStar1_Subrect {
	static int r, c, grid[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(find_max_sum_of_subrect(br.readLine()));
		br.close();
	}
    public static int find_max_sum_of_subrect(String values) {
        StringTokenizer st = new StringTokenizer(values);
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        grid = new int[r][c];
        int xIndex = 0;
        int yIndex = 0;
        while(st.hasMoreTokens()) {
            grid[xIndex][yIndex] = Integer.parseInt(st.nextToken());
            ++yIndex;
            if(yIndex == c) {
                yIndex = 0;
                ++xIndex;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 1; i <= r; i++)
            for(int j = 1; j <= c; j++)
                if(rectangleFinder(i, j) > max)
                    max = rectangleFinder(i, j);
        return max;
    }
    public static int rectangleFinder(int x, int y) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i <= r - x; i++) {
            for(int j = 0; j <= c - y; j++) {
                int sum = 0;
                for(int k = i; k < i + x; k++)
                    for(int l = j; l < j + y; l++)
                        sum += grid[k][l];
                if(sum > max)
                    max = sum;
            }
        }
        return max;
    }
}