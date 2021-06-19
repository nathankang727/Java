package ACSL15_16;
import java.util.*;
import java.io.*;
public class AllStar3_ACSL_Egyptian_Multiplication {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1516AllStar3.in"));
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			if(n1 < n2) {
				int n3 = n1;
				n1 = n2;
				n2 = n3;
			}
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int j = 30; j >= 0; j--) {
				if(Math.pow(2, j) <= n1) {
					list.add((int)(Math.pow(2, j)));
					n1 -= Math.pow(2, j);
				}
			}
			for(int j = 0; j < list.size() - 1; j++)
				System.out.print(list.get(j) * n2 + " ");
			System.out.print(list.get(list.size() - 1) * n2 + "\n");
		}
		br.close();
	}
}