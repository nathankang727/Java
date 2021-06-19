package ACSL10_11;
import java.util.*;
import java.io.*;
import java.text.DecimalFormat;
public class AllStar2_Equations {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1011AllStar2.in"));
		DecimalFormat round = new DecimalFormat("#.#");
		for(int i = 0; i < 2; i++) {
			double[][] grid = new double[3][4];
			for(int j = 0; j < 3; j++)
				for(int k = 0; k < 4; k++)
					grid[j][k] = sc.nextDouble();
			for(int j = 0; j < 5; j++) {
				double[] use = new double[4];
				int n1 = sc.nextInt() - 1;
				for(int k = 0; k < 4; k++)
					use[k] = grid[n1][k];
				double n2 = sc.nextDouble();
				for(int k = 0; k < 4; k++)
					use[k] *= n2;
				String[] s = {round.format(use[0]), round.format(use[1]), round.format(use[2]), round.format(use[3])};
				for(int k = 0; k < 4; k++)
					use[k] = Double.parseDouble(s[k]);
				int n3 = sc.nextInt() - 1;
				if(n3 >= 0) {
					for(int k = 0; k < 4; k++)
						use[k] += grid[n3][k];
					for(int k = 0; k < 4; k++)
						s[k] = round.format(use[k]);
					for(int k = 0; k < 4; k++)
						use[k] = Double.parseDouble(s[k]);
				}
				int n4 = sc.nextInt() - 1;
				for(int k = 0; k < 4; k++)
					grid[n4][k] = use[k];
				for(int k = 0; k < 4; k++)
					System.out.print((int)(use[k]) + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}