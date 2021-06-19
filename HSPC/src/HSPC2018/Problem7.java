package HSPC2018;
import java.io.*;
public class Problem7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		int g = Integer.parseInt(br.readLine());
		int h = Integer.parseInt(br.readLine());
		boolean eBetweenAC = e >= a && e <= c;
		boolean hBetweenBD = h >= b && h <= d;
		int i = eBetweenAC ? e : a;
		int j = hBetweenBD ? b : f;
		int k = eBetweenAC ? c : g;
		int l = hBetweenBD ? h : d;
		int intersection = Math.abs(i - k) * Math.abs(j - l);
		System.out.println(intersection);
		System.out.println(Math.abs(a - c) * Math.abs(b - d) + Math.abs(e - g) * Math.abs(f - h) - intersection);
	}
}