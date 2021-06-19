package Sorting;
import java.util.*;
public class Practice4 {
	static class point implements Comparable<point> {
		int x;
		String y;
		public point(int x, String y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(point that) {
			if(this.x < that.x)
				return -1;
			else if(this.x > that.x)
				return 1;
			else
				return 0;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		point[] a = new point[n];
		for(int i = 0; i < n; i++)
			a[i] = new point(in.nextInt(), in.nextLine());
		Arrays.sort(a);
		for(int i = 0; i < n; i++)
			System.out.println(a[i].x + a[i].y);
		in.close();
	}
}