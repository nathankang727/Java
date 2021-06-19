package ACSL06_07;
import java.util.*;
import java.io.*;
public class C2JR_ACSL_TheNextGeneration {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0607C2Jr.in"));
		for(int i = 0; i < 10; i++) {
			int num = sc.nextInt();
			String[] cells = new String[num + 2];
			String[] duplicateCells = new String[num + 2];
			cells[0] = "D";
			duplicateCells[0] = "D";
			cells[cells.length - 1] = "D";
			duplicateCells[duplicateCells.length - 1] = "D";
			for(int j = 1; j <= num; j++) {
				String a = sc.next();
				duplicateCells[j] = a;
				cells[j] = a;
			}
			int gen = sc.nextInt();
			for(int j = 0; j < gen; j++) {
				for(int k = 1; k <= num; k++) {
					if(cells[k - 1].equals("A") && cells[k + 1].equals("D") || cells[k - 1].equals("D") && cells[k + 1].equals("A"))
						duplicateCells[k] = "A";
					else
						duplicateCells[k] = "D";
				}
				for(int k = 1; k <= num; k++)
					cells[k] = duplicateCells[k];
			}
			for(int j = 1; j <= num; j++)
				System.out.print(cells[j]);
			System.out.println();
		}
		sc.close();
	}
}