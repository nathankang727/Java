package ACSL20_21;
import java.util.*;
import java.io.*;
public class C2IN_LexStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());
		System.out.println(rearrangeString(s, n));
		br.close();
	}
	public static String rearrangeString(String s, int n) {
		ArrayList<Data> list = new ArrayList<Data>();
		String ans = "";
		char temp = s.charAt(0);
		int cnt = 0;
		for(int i = 0; i < s.length(); i++) {
			if(temp == s.charAt(i))
				++cnt;
			else {
				list.add(new Data(temp, cnt));
				cnt = 1;
				temp = s.charAt(i);
			}
		}
		list.add(new Data(temp, cnt));
		Collections.sort(list);
		ArrayList<Character> ansList = new ArrayList<Character>();
		for(int i = 0; i < list.size(); i++)
			for(int j = 0; j < list.get(i).n; j++)
				ansList.add(list.get(i).c);
		temp = ansList.get(0);
		cnt = 1;
		ans += ansList.get(0);
		for(int i = 1; i < ansList.size(); i++) {
			if(ansList.get(i) != temp) {
				temp = ansList.get(i);
				cnt = 1;
				ans += ansList.get(i);
			}
			else if(ansList.get(i) == temp && cnt >= n)
				continue;
			else {
				ans += ansList.get(i);
				++cnt;
			}
		}
		return ans;
	}
	static class Data implements Comparable<Data> {
		public char c;
		public int n;
		public int compareTo(Data d) {
			return this.n != d.n ? d.n - this.n : this.c - d.c;
		}
		public Data(char cc, int nn) {
			this.c = cc;
			this.n = nn;
		}
	}
}