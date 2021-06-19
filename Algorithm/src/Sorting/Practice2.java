package Sorting;
import java.util.*;
public class Practice2 {
	static class point implements Comparable<point> {
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(point that) {
			if(this.x < that.x)
				return -1;
			else if(this.x == that.x) {
				if(this.y < that.y)
					return -1;
				else if(this.y == that.y)
					return 0;
				else
					return 1;
			}
			else
				return 1;
		}
	}
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		point[] a = new point[n];
		for(int i = 0; i < n; i++)
			a[i] = new point(in.nextInt(), in.nextInt());
		Arrays.sort(a);
		for(int i = 0; i < a.length; i++)
			System.out.println(a[i].x + " " + a[i].y);
		in.close();
	}
}