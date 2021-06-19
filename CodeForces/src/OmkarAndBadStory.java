import java.util.*;
import java.io.*;
public class OmkarAndBadStory {
	static int n, cnt;
	static ArrayList<Integer> a;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = new ArrayList<Integer>();
			for(int j = 0; j < n; j++)
				a.add(Integer.parseInt(st.nextToken()));
			cnt = 0;
			if(check()) {
				System.out.println("yes");
				System.out.println(a.size());
				System.out.print(a.get(0));
				for(int j = 1; j < a.size(); j++)
					System.out.print(" " + a.get(j));
				System.out.println();
			}
			else
				System.out.println("no");
		}
		br.close();
	}
	public static boolean check() {
		for(int i = 0; i < a.size() - 1; i++) {
			for(int j = i + 1; j < a.size(); j++) {
				if(!a.contains(Math.abs(a.get(i) - a.get(j)))) {
					a.add(Math.abs(a.get(i) - a.get(j)));
					++cnt;
				}
				if(a.size() > 300) {
					return false;
				}
			}
		}
		if(a.size() > 300)
			return false;
		return true;
	}
}