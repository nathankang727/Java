import java.io.*;
import java.util.*;
public class Prob16 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			ArrayList<equation> expression1 = new ArrayList<equation>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int index = 0;
			while(st.hasMoreTokens()) {
				expression1.add(new equation(Integer.parseInt(st.nextToken()), index));
				++index;
			}
			ArrayList<equation> expression2 = new ArrayList<equation>();
			st = new StringTokenizer(br.readLine());
			index = 0;
			while(st.hasMoreTokens()) {
				expression2.add(new equation(Integer.parseInt(st.nextToken()), index));
				++index;
			}
			Collections.sort(expression1);
			Collections.sort(expression2);
			ArrayList<equation> list = new ArrayList<equation>();
			ArrayList<Integer> exponents = new ArrayList<Integer>();
			for(int j = 0; j < expression1.size(); j++) {
				for(int k = 0; k < expression2.size(); k++) {
					int product = expression1.get(j).n * expression2.get(k).n;
					int newExponent = expression1.get(j).e + expression2.get(k).e;
					if(!exponents.contains(newExponent)) {
						list.add(new equation(product, newExponent));
						exponents.add(newExponent);
					}
					else {
						equation e = new equation(0, 0);
						for(int l = 0; l < list.size(); l++) {
							if(list.get(l).e == newExponent) {
								e = list.get(l);
								break;
							}
						}
						list.set(list.indexOf(e), new equation(product + list.get(list.indexOf(e)).n, newExponent));
					}
				}
			}
			Collections.sort(list);
			boolean yes = false;
			for(int j = 0; j < list.size(); j++) {
				int e = list.get(j).e;
				if(!yes) {
					if(list.get(j).n == 0)
						continue;
					if(e < 1)
						System.out.print(list.get(j).n);
					else if(e < 2) {
						if(list.get(j).n == 1)
							System.out.print("x");
						else if(list.get(j).n == -1)
							System.out.print("-x");
						else
							System.out.print(list.get(j).n + "x");
					}
					else {
						if(list.get(j).n == 1)
							System.out.print("x^" + e);
						else if(list.get(j).n == -1)
							System.out.print("-x^" + e);
						else
							System.out.print(list.get(j).n + "x^" + e);
					}
					yes = true;
				}
				else {
					if(list.get(j).n == 0)
						continue;
					if(e < 1)
						System.out.print((list.get(j).n > 0 ? "+" : "") + (list.get(j).n == 1 ? "" : list.get(j).n));
					else if(e < 2) {
						if(list.get(j).n == 1)
							System.out.print("+x");
						else if(list.get(j).n == -1)
							System.out.print("-x");
						else
							System.out.print((list.get(j).n > 0 ? "+" : "") + list.get(j).n + "x");
					}
					else {
						if(list.get(j).n == 1)
							System.out.print("+x^" + e);
						else if(list.get(j).n == -1)
							System.out.print("-x^" + e);
						else
							System.out.print((list.get(j).n > 0 ? "+" : "") + list.get(j).n + "x^" + e);
					}
				}
			}
			System.out.println();
		}
		br.close();
	}
	static class equation implements Comparable<equation>{
		public int n;
		public int e;
		public int compareTo(equation ee) {
			return this.e - ee.e;
		}
		public equation(int number, int exponent) {
			this.n = number;
			this.e = exponent;
		}
	}
}