package HSPC2018;
import java.util.*;
import java.io.*;
public class Problem6 {
	static String start, end;
	static int n;
	static char[][] mutation;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		start = br.readLine();
		end = br.readLine();
		n = Integer.parseInt(br.readLine());
		mutation = new char[n + 2][];
		mutation[0] = start.toCharArray();
		for(int i = 1; i < n + 1; i++)
			mutation[i] = br.readLine().toCharArray();
		mutation[n + 1] = end.toCharArray();
		ArrayList<String> list = new ArrayList<String>();
		for(int i = 0; i < n + 2; i++) {
			String str = "";
			for(int j = 0; j < n + 2; j++) {
				if(i == j)
					continue;
				int cnt = 0;
				for(int k = 0; k < start.length(); k++)
					if(mutation[i][k] != mutation[j][k])
						++cnt;
				if(cnt <= 1)
					str += j + 1;
			}
			list.add(str);
		}
		String s1 = list.get(0);
		for(int i = list.size() - 1; i > 0; i--) {
			String str = list.get(i);
			for(int j = 0; j < s1.length(); j++) {
				str = str.replace(s1.substring(j, j + 1), "1");
			}
			list.remove(i);
			list.add(1, str);
		}
		boolean works = false;
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).indexOf("1") > -1 && list.get(i).indexOf(String.valueOf(n + 2)) > -1) {
				works = true;
				break;
			}
		}
		if(works)
			System.out.println("True");
		else
			System.out.println("False");
	}
}