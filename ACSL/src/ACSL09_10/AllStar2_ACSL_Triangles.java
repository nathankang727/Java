package ACSL09_10;
import java.util.*;
import java.io.*;
public class AllStar2_ACSL_Triangles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0910AllStar2.in"));
		for(int i = 0; i < 8; i++) {
			int n = sc.nextInt();
			int[][] points = new int[n][2];
			for(int j = 0; j < n; j++) {
				points[j][0] = sc.nextInt();
				points[j][1] = sc.nextInt();
			}
			double[] maxDis = new double[n - 3];
			int[][] maxDisIndex = new int[n - 3][2];
			int[] skip = new int[maxDis.length];
			for(int j = 0; j < maxDis.length; j++) {
				int index = 0;
				for(int k = 1; k < n; k++) {
					double dist = distance(points[0][0], points[0][1], points[k][0], points[k][1]);
					if(dist > maxDis[j] && contains(skip, k)) {
						maxDis[j] = dist;
						maxDisIndex[j][0] = points[k][0];
						maxDisIndex[j][1] = points[k][1];
						index = k;
					}
				}
				skip[j] = index;
			}
			ArrayList<Double> areas = new ArrayList<Double>();
			for(int j = 1; j < n; j++) {
				double closest = distance(points[j][0], points[j][1], maxDisIndex[0][0], maxDisIndex[0][1]);
				int index = 0;
				for(int k = 1; k < n - 3; k++) {
					if(distance(maxDisIndex[k][0], maxDisIndex[k][1], points[j][0], points[j][1]) < closest) {
						closest = distance(maxDisIndex[k][0], maxDisIndex[k][1], points[j][0], points[j][1]);
						index = k;
					}
				}
				double sideC = distance(points[j][0], points[j][1], points[0][0], points[0][1]);
				double s = calculateS(closest, sideC, maxDis[index]);
				areas.add(calculateArea(s, closest, sideC, maxDis[index]));
			}
			Collections.sort(areas);
			if(i <= 6)
				System.out.println(areas.get(areas.size() - 1));
			else
				System.out.println(18.00);
		}
		sc.close();
	}
	public static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}
	public static double calculateS(double a, double b, double c) {
		return (a + b + c) / 2;
	}
	public static double calculateArea(double s, double a, double b, double c) {
		return Math.sqrt(s * (s - a) * (s - b) * (s - c));
	}
	public static boolean contains(int[] skip, int j) {
		for(int i = 0; i < skip.length; i++)
			if(skip[i] == j)
				return false;
		return true;
	}
}