package GreedyAlgorithm;
import java.util.*;
import java.io.*;
public class Problem7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		long sum = 0L;
		for(int i = 0; i < a.length(); i++)
			sum += (long)a.charAt(i);
		if((a.contains("0")) && (sum % 3 == 0)) {
			StringBuilder sb = new StringBuilder();
			char[] d = a.toCharArray();
			Arrays.sort(d);
			for(int i = d.length - 1; i >= 0; i--)
                sb.append(d[i]);
			System.out.println(sb);
		}
		else
			System.out.println("-1");
	}
}