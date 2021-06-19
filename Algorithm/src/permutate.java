public class permutate {
	public static void main(String[] args) {
		String str = "ABC";
		int n = str.length();
		permutation(str, 0, n - 1);
	}
	static void permutation(String str, int l, int r) {
		if(l == r)
			System.out.println(str);
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