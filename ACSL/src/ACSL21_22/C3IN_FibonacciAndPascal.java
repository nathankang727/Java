package ACSL21_22;
import java.util.*;
import java.io.*;
public class C3IN_FibonacciAndPascal {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(findOddEvenMax(n));
		br.close();
	}
	public static String findOddEvenMax(int fibNumber) {
		int arrSize = 2;
		int n1 = 1;
		int n2 = 1;
		while(n2 < fibNumber) {
			++arrSize;
			int temp = n1 + n2;
			n1 = n2;
			n2 = temp;
		}
		int[][] triangle = new int[arrSize][arrSize];
		for(int i = 0; i < arrSize; i++) {
			triangle[i][0] = 1;
			for(int j = 1; j < i; j++)
				triangle[i][j] = triangle[i - 1][j - 1] + triangle[i - 1][j];
			triangle[i][i] = 1;
		}
		int x = arrSize - 1;
		int y = 0;
		ArrayList<Integer> diagonal = new ArrayList<Integer>();
		while(x >= 0 && y < arrSize && triangle[x][y] != 0) {
			diagonal.add(triangle[x][y]);
			--x;
			++y;
		}
		Collections.sort(diagonal);
		int odd = 0;
		int even = 0;
		for(int i = 0; i < diagonal.size(); i++) {
			if(diagonal.get(i) % 2 == 0)
				++even;
			else
				++odd;
		}
		return odd + " " + even + " " + diagonal.get(diagonal.size() - 1);
    }
}