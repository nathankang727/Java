package DynamicProgramming;
import java.io.*;
public class Problem16 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());
		int[] triangles = new int[cases];
		for(int i = 0; i < cases; i++)
			triangles[i] = Integer.parseInt(br.readLine());
		int[] memo = new int[cases + 100];
		for(int i = 0; i < cases; i++)
			System.out.println(triangle(memo, triangles[i]));
	}
	public static int triangle(int[] m, int a) {
		if(a < 3)
			return 1;
		else
			return triangle(m, a - 1) + triangle(m, a - 5);
	}
}