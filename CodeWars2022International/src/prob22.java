import java.util.*;
import java.io.*;
public class prob22 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < t; i++) {
			int h = sc.nextInt();
			int w = sc.nextInt();
			int c = sc.nextInt();
			sc.nextLine();
			char[][] map = new char[h][w];
			Point[] coor = new Point[c + 1];
			for(int j = 0; j < h; j++)
				for(int k = 0; k < w; k++)
					map[j][k] = ' ';
			for(int j = 0; j < h; j++) {
				String input = sc.nextLine();
				for(int k = 0; k < input.length(); k++) {
					map[j][k] = input.charAt(k);
					if(input.charAt(k) != '#' && input.charAt(k) != ' ')
						coor[Integer.parseInt(input.substring(k, k + 1))] = new Point(j, k);
				}
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j = 1; j <= c; j++) {
				int rise = coor[j].r - coor[0].r;
				int run = coor[j].c - coor[0].c;
				int gcd = gcf(rise, run);
				rise /= gcd;
				run /= gcd;
				int y = coor[0].r;
				int x = coor[0].c;
				boolean didBreak = false;
				System.out.println(rise + " " + run + " " + gcd);
				while(y != coor[j].r || x != coor[j].c) {
					for(int k = 0; k < rise; k++) {
						++y;
						if(map[y][x] == '#') {
							didBreak = true;
							break;
						}
						for(int l = 0; l < run; l++) {
							++x;
							if(map[y][x] == '#') {
								didBreak = true;
								break;
							}
						}
					}					
				}
				if(!didBreak)
					list.add(j);
			}
			if(list.size() == 0)
				System.out.println("No viable locations");
			else {
				System.out.print(list.get(0));
				for(int j = 1; j < list.size(); j++)
					System.out.print(" " + list.get(j));
				System.out.println();
			}
		}
		sc.close();
	}
	public static int gcf(int n1, int n2) {
		if(n1 == 0)
			return Math.abs(n2);
		if(n2 == 0)
			return Math.abs(n1);
		int max = 1;
		for(int i = 1; i <= Math.min(Math.abs(n1), Math.abs(n2)); i++)
			if(Math.abs(n1) % i == 0 && Math.abs(n2) % i == 0)
				max = i;
		return max;
	}
	static class Point {
		public int r;
		public int c;
		public Point(int row, int col) {
			r = row;
			c = col;
		}
	}
}