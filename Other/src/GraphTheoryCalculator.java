import java.util.*;
import java.io.*;
public class GraphTheoryCalculator {
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[][] G = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				G[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int[][] res = new int[N][N];
		power(G, res, k);
		int cnt = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(res[i][j] + " ");
				cnt += res[i][j];
			}
			System.out.println("");
		}
		System.out.println("Total: " + cnt);
	}
	static void multiply(int a[][], int b[][], int res[][]) {
	    int[][] mul = new int[N][N];
	    for(int i = 0; i < N; i++) {
	        for(int j = 0; j < N; j++) {
	            mul[i][j] = 0;
	            for(int k = 0; k < N; k++)
	            	mul[i][j] += a[i][k] * b[k][j];
	        }
	    }
	    for(int i = 0; i < N; i++)
	        for(int j = 0; j < N; j++)
	        	res[i][j] = mul[i][j];
	}
	static void power(int G[][], int res[][], int n) {
	    if (n == 1) {
	        for(int i = 0; i < N; i++)
	            for(int j = 0; j < N; j++)
	            	res[i][j] = G[i][j];
	        return;
	    }
	    power(G, res, n / 2);
	    multiply(G, G, res);
	    if (n % 2 != 0)
	        multiply(res, G, res);
	}
}