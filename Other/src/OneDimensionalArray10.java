import java.util.*;
import java.io.*;
public class OneDimensionalArray10 {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("FILE.in"));
		int[][] a = new int[4][4];
		for(int i = 0; i < 4; i++) {
			int n = in.nextInt();
			for(int j = 3; j >= 0; j--) {
				a[i][j] = n % 10;
				n = n / 10;
			}
		}
		System.out.println(Arrays.deepToString(a));
		in.close();
	}
}