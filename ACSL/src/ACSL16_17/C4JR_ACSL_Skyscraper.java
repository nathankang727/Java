package ACSL16_17;
import java.util.*;
import java.io.*;
public class C4JR_ACSL_Skyscraper {
	static ArrayList<String> sky;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1617C4Jr.in"));
		String str = "12345";
		sky = new ArrayList<String>();
		permutation(str, 0, str.length() - 1);
		for(int i = 0; i < 10; i++) {
			int lc = sc.nextInt();
			int rc = sc.nextInt();
			int res = 0;
			for(int j = 0; j < sky.size(); j++) {
				String s = sky.get(j);
				int l = Integer.parseInt(s.substring(0, 1));
				int r = Integer.parseInt(s.substring(4));
				int lcount = 0;
				int rcount = 0;
				for(int k = 0; k < 5; k++) {
					if(Integer.parseInt(s.substring(k, k + 1)) >= l) {
						lcount++;
						l = Integer.parseInt(s.substring(k, k + 1));
					}
				}
				for(int k = 4; k >= 0; k--) {
					if(Integer.parseInt(s.substring(k, k + 1)) >= r) {
						rcount++;
						r = Integer.parseInt(s.substring(k, k + 1));
					}
				}
				if(lcount == lc && rcount == rc)
					res++;
			}
			System.out.println(res);
		}
		sc.close();
	}
	static void permutation(String str, int l, int r) {
		if(l == r)
			sky.add(str);
		else {
			for(int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permutation(str, l + 1, r);
			}
		}
	}
	static String swap(String a, int i, int j) {
		char temp;
		char[] c = a.toCharArray();
		temp = c[i];
		c[i] = c[j];
		c[j] = temp;
		return String.valueOf(c);
	}
}