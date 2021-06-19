package ACSL12_13;
import java.util.*;
import java.io.*;
public class AllStar3_AllStarCells {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1213AllStar3.in")));
		for(int i = 0; i < 2; i++) {
			String[] strings = new String[3];
			for(int j = 0; j < 3; j++)
				strings[j] = br.readLine();
			for(int j = 0; j < 10; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				ArrayList<String> list = new ArrayList<String>();
				while(st.hasMoreTokens()) {
					String s = st.nextToken();
					list.add(s.length() == 1 ? strings[s.charAt(0) - 'X'] : s);
				}
				while(list.size() > 1) {
					for(int k = list.size() - 1; k >= 0; k--) {
						if(list.get(k).length() > 7)
							continue;
						else {
							String s = list.get(k);
							if(s.equals("DIV"))
								list.set(k, divide(list.remove(k + 1)));
							else if(s.substring(0, 3).equals("ADD"))
								list.set(k, add(Integer.parseInt(s.substring(3)), list.remove(k + 1)));
							else if(s.substring(0, 3).equals("SUB"))
								list.set(k, subtract(Integer.parseInt(s.substring(3)), list.remove(k + 1)));
							else if(s.equals("UNI"))
								list.set(k, union(list.remove(k + 1), list.remove(k + 1)));
							else if(s.equals("INT"))
								list.set(k, intersect(list.remove(k + 1), list.remove(k + 1)));
							else
								list.set(k, align(list.remove(k + 1)));
							break;
						}
					}
				}
				System.out.println(list.get(0));
			}
		}
		br.close();
	}
	public static String divide(String s) {
		String sub1 = s.substring(0, 4) + s.substring(0, 4);
		String sub2 = s.substring(4) + s.substring(4);
		return sub1 + " and " + sub2;
	}
	public static String add(int n, String s) {
		if(n == 0)
			return s;
		else if(n == 4)
			return s.substring(0, 4) + s.substring(0, 4);
		return s.substring(0, n) + s.substring(0, n) + s.substring(n, n + (4 - n) * 2);
	}
	public static String subtract(int n, String s) {
		if(n == 0)
			return s;
		String res = s.substring(n);
		String[] arr = s.substring(8 - n).split("");
		Arrays.sort(arr);
		for(int i = 0; i < arr.length; i++)
			res += arr[i];
		return res;
	}
	public static String union(String s1, String s2) {
		String sub1 = s1.substring(4);
		String sub2 = s2.substring(0, 4);
		String[] arr1 = sub1.split("");
		String[] arr2 = sub2.split("");
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		String res = "";
		for(int i = 0; i < 4; i++)
			res += arr1[i];
		for(int i = 0; i < 4; i++)
			res += arr2[i];
		return res;
	}
	public static String intersect(String s1, String s2) {
		String sub1 = s1.substring(0, 2) + s1.substring(6);
		String sub2 = s2.substring(0, 2) + s2.substring(6);
		String[] arr1 = sub1.split("");
		String[] arr2 = sub2.split("");
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		String res = "";
		for(int i = 0; i < 4; i++)
			res += arr1[i];
		for(int i = 0; i < 4; i++)
			res += arr2[i];
		return res;
	}
	public static String align(String s) {
		String[] arr = s.split("");
		Arrays.sort(arr);
		String reverse = "";
		for(int i = arr.length - 1; i >= 0; i--)
			reverse += arr[i];
		return reverse;
	}
}