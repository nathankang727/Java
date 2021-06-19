package ACSL17_18;
import java.util.*;
import java.io.*;
public class AllStar2_CompressedArrays {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1718AllStar2.in")));
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			int f = Integer.parseInt(st.nextToken());
			String count = "";
			ArrayList<CA> list = new ArrayList<CA>();
			int[] freq = new int[26];
			for(int j = 0; j < s.length(); j++)
				++freq[s.charAt(j) - 'A'];
			for(int j = 0; j < freq.length; j++) {
				if(freq[j] > 0)
					list.add(new CA(freq[j], String.valueOf((char)('A' + j))));
				if(freq[j] == f)
					count += (char)('A' + j);
			}
			Collections.sort(list);
			while(list.size() > 1) {
				String s1 = list.get(0).getString();
				String s2 = list.get(1).getString();
				int n1 = list.get(0).getNum();
				int n2 = list.get(1).getNum();
				list.remove(0);
				list.remove(0);
				if(n1 + n2 == f)
					count += s1 + s2;
				list.add(new CA(n1 + n2, stringSort(s1 + s2)));
				Collections.sort(list);
			}
			System.out.println(count.length() > 0 ? stringSort(count) : "NONE");
		}
		br.close();
	}
	public static String stringSort(String s) {
		Set<Character> set = new TreeSet<Character>();
		for(int i = 0; i < s.length(); i++)
			set.add(s.charAt(i));
		String newStr = "";
		for(char c : set)
			newStr += c;
		return newStr;
	}
}
class CA implements Comparable<CA> {
    private int n;
    private String s; 
    public int compareTo(CA ca) {
        if(this.n != ca.n)
        	return this.n - ca.n;
        return this.s.compareTo(ca.s);
    }
    public CA(int n1, String s1) {
        this.n = n1;
        this.s = s1;
    }
    public int getNum() {
    	return n;
    }
    public String getString() {
    	return s;
    }
} 