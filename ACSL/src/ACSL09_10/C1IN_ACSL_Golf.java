package ACSL09_10;
import java.util.*;
import java.io.*;
public class C1IN_ACSL_Golf {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0910C1In.in"));
		for(int i = 0; i < 2; i++) {
			int[] pars = new int[9];
			int[] p1 = new int[9];
			int[] p2 = new int[9];
			int totalPar = 0;
			int greatestHole = 0;
			int holeCount = 0;
			boolean better = true;
			int sum1 = 0;
			int sum2 = 0;
			for(int j = 0; j < 9; j++) {
				pars[j] = sc.nextInt();
				totalPar += pars[j];
				p1[j] = sc.nextInt();
				sum1 += p1[j];
				p2[j] = sc.nextInt();
				sum2 += p2[j];
			}
			System.out.println(Math.min(sum1, sum2) + " " + Math.max(sum1, sum2));
			if(Math.min(sum1, sum2) == sum2)
				better = false;
			for(int j = 0; j < 2; j++) {
				if(better == true) {
					if(totalPar == sum1)
						System.out.print("par");
					else if(totalPar > sum1)
						System.out.print(Math.abs(totalPar - sum1) + " under par");
					else
						System.out.print(Math.abs(totalPar - sum1) + " over par");
					System.out.println();
					better = false;
				}
				else {
					if(totalPar == sum2)
						System.out.print("par");
					else if(totalPar > sum2)
						System.out.print(Math.abs(totalPar - sum2) + " under par");
					else
						System.out.print(Math.abs(totalPar - sum2) + " over par");
					System.out.println();
					better = true;
				}
			}
			if(better = true) {
				for(int j = 0; j < 9; j++)
					if(p1[j] < p2[j])
						holeCount++;
			}
			else
				for(int j = 0; j < 9; j++)
					if(p2[j] < p1[j])
						holeCount++;
			System.out.println(holeCount);
			for(int j = 0; j < 9; j++) {
				int holePoints = p1[j] + p2[j];
				if(holePoints >= greatestHole)
					greatestHole = holePoints;
			}
			System.out.println(greatestHole);
		}
		sc.close();
	}
}