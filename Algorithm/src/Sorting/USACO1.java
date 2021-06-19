package Sorting;
import java.util.*;
import java.io.*;
public class USACO1 {
	static class point implements Comparable<point> {
		int x;
		int y;
		public point(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int compareTo(point that) {
			if(this.y > that.y)
				return 1;
			else
				return -1;
		}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("Whatever.txt"));
		int a = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < a; i++) {
			String b = sc.nextLine();
			System.out.println(b + ":");
			int c = Integer.parseInt(sc.nextLine());
			point[] d = new point[c];
			for(int j = 0; j < c; j++) {
				d[j] = new point((int)sc.nextDouble(), sc.nextInt());
			}
			Arrays.sort(d);
			for(int j = 0; j < c; j++) {
				if(d[j].x % 1000 >= 500)
					d[j].x += 1000;
				d[j].x /= 1000;
			}
			for(int j = 0; j < c; j++) {
				System.out.print(d[j].y + " ");
				for(int k = 0; k < d[j].x; k++)
					System.out.print("*");
				System.out.println();
			}
		}
		sc.close();
	}
}