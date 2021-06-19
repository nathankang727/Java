package GreedyAlgorithm;
import java.io.*;
import java.util.*;
public class Problem5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int res = 0;
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());
		Arrays.sort(a);
		int j = 0;
		if(n == 1)
			res += a[0];
		else {
			if(n % 2 == 1)
				n++;
			for(int i = 0; i <= n; i += 2) {
				try {
					int g = a[i];
					int p = a[i + 1];
					if(((g < 0 && p < 0) && (g + p) < (g * p)) || ((g > 0 && p > 0) && (g + p) < (g * p)))
						b[j] = g * p;
					else if(g < 0 && p == 0)
						b[j] = 0;
					else {
						b[j] = g;
						b[j + 1] = p;
						j++;
					}
					j++;
				}
				catch(IndexOutOfBoundsException e) {
					break;
				}
			}
			for(int i = 0; i < n; i++) {
				try {
					res += b[i];
				}
				catch(IndexOutOfBoundsException e) {
					break;
				}
			}
		}
		System.out.println(res);
	}
}