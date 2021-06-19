package ACSL16_17;
import java.util.*;
import java.io.*;
public class AllStar3_Puzzle {
	static boolean[][] b;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1617AllStar3.in")));
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sortingPieces[] sp = new sortingPieces[10];
			for(int j = 0; j < 10; j++) {
				int dimens = Integer.parseInt(st.nextToken());
				String dimens2 = String.valueOf(dimens);
				if(dimens < 100) {
					int area = Integer.parseInt(dimens2.substring(0, 1)) * Integer.parseInt(dimens2.substring(1, 2));
					sp[j] = new sortingPieces(dimens, area);
				}
				else {
					int area = Integer.parseInt(dimens2.substring(0, 1)) + (Integer.parseInt(dimens2.substring(1, 2)) - 1) * 
							Integer.parseInt(dimens2.substring(2));
					sp[j] = new sortingPieces(dimens, area);
				}
			}
			Arrays.sort(sp, Collections.reverseOrder());
			for(int j = 0; j < 10; j++) {
				st = new StringTokenizer(br.readLine());
				int width = Integer.parseInt(st.nextToken());
				int height = Integer.parseInt(st.nextToken());
				ArrayList<Integer> answers = new ArrayList<Integer>();
				b = new boolean[height][width];
				for(int k = 0; k < 10; k++) {
					int w = Integer.parseInt(String.valueOf(sp[k].getDimensions()).substring(0, 1));
					int h = Integer.parseInt(String.valueOf(sp[k].getDimensions()).substring(1, 2));
					boolean changed = false;
					if(j < 5 && sp[k].getDimensions() > 99 || w == width && h == height && sp[k].getDimensions() < 100)
						continue;
					else if(sp[k].getDimensions() < 100)
						changed = change(w, h, 0);
					else
						changed = change(w, h, Integer.parseInt(String.valueOf(sp[k].getDimensions()).substring(2)));
					if(changed)
						answers.add(sp[k].getDimensions());
				}
				if(containsFalse(b))
					System.out.print("NONE");
				else
					for(int k = 0; k < answers.size(); k++)
						System.out.print(answers.get(k) + " ");
				System.out.println();
			}
		}
		br.close();
	}
	public static boolean change(int width, int height, int width2) {
		int startX = -1;
		int startY = -1;
		boolean didBreak = false;
		for(int i = 0; i < b.length; i++) {
			for(int j = 0; j < b[0].length; j++) {
				if(!b[i][j] && i + height - 1 < b.length && j + width - 1 < b[0].length && !b[i + height - 1][j] &&
						!b[i][j + width - 1]) {
					startX = i;
					startY = j;
					didBreak = true;
					break;
				}
			}
			if(didBreak)
				break;
		}
		if(startX == -1 || startY == -1)
			return false;
		if(width2 == 0) {
			for(int i = startX; i < startX + height; i++)
				for(int j = startY; j < startY + width; j++)
					b[i][j] = true;
		}
		else {
			for(int i = startY; i < startY + width; i++)
				b[startX][i] = true;
			for(int i = startX; i < startX + height; i++)
				for(int j = startY; j < startY + width2; j++)
					b[i][j] = true;
		}
		return true;
	}
	public static boolean containsFalse(boolean[][] b) {
		for(int i = 0; i < b.length; i++)
			for(int j = 0; j < b[0].length; j++)
				if(!b[i][j])
					return true;
		return false;
	}
}
class sortingPieces implements Comparable<sortingPieces> {
	private int dimensions;
	private int areas;
	public int compareTo(sortingPieces sp) {
		return this.areas == sp.areas ? Integer.parseInt(String.valueOf(this.dimensions).substring(0, 1)) - 
				Integer.parseInt(String.valueOf(sp.dimensions).substring(0, 1)) : this.areas - sp.areas;
	}
	public sortingPieces(int dm, int as) {
		this.dimensions = dm;
		this.areas = as;
	}
	public int getDimensions() {
		return dimensions;
	}
	public int getAreas() {
		return areas;
	}
}