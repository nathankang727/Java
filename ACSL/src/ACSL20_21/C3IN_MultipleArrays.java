package ACSL20_21;
import java.util.*;
import java.io.*;

public class C3IN_MultipleArrays {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String rows_cols = br.readLine();
		String arr1 = br.readLine();
		String arr2 = br.readLine();
		String arr3 = br.readLine();
		System.out.println(sumSmallestInVisitedCells(rows_cols, arr1, arr2, arr3));
		br.close();
	}

	public static int sumSmallestInVisitedCells(String rows_cols, String array1, String array2, String array3) {
		StringTokenizer st = new StringTokenizer(rows_cols);
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(array1);
		int[][] arr1 = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				arr1[i][j] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(array2);
		int[][] arr2 = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				arr2[i][j] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(array3);
		int[][] arr3 = new int[r][c];
		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				arr3[i][j] = Integer.parseInt(st.nextToken());
		int x = 0;
		int y = 0;
		int minSum = 0;
		while (x < r - 1 && y < c - 1) {
			minSum += Math.min(arr1[x][y], Math.min(arr2[x][y], arr3[x][y]));
			int[] compare = { arr1[x + 1][y], arr1[x][y + 1], arr2[x + 1][y], arr2[x][y + 1], arr3[x + 1][y],
					arr3[x][y + 1] };
			int max = Math.max(compare[0],
					Math.max(compare[1], Math.max(compare[2], Math.max(compare[3], Math.max(compare[4], compare[5])))));
			int count = 0;
			int index = 0;
			for (int i = 0; i < 6; i++) {
				if (compare[i] == max) {
					++count;
					index = i;
				}
			}
			if (count > 1) {
				++x;
				++y;
			} 
			else {
				if (index % 2 == 0)
					++x;
				else
					++y;
			}
		}
		minSum += Math.min(arr1[x][y], Math.min(arr2[x][y], arr3[x][y]));
		return minSum;
	}
}