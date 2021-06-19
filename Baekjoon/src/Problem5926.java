import java.util.*;
import java.io.*;
public class Problem5926 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Photos[] p = new Photos[n];
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			p[i] = new Photos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			map.put(p[i].b, 0);
		}
		Arrays.sort(p);
		int left = 0;
		int right = 0;
		map.put(p[0].b, 1);
		int min = Integer.MAX_VALUE;
		while(left >= 0 && right < p.length) {
			if(map.containsValue(0)) {
				++right;
				if(right < p.length)
					map.put(p[right].b, map.get(p[right].b) + 1);
			}
			else {
				min = Math.min(min, p[right].p - p[left].p);
				map.put(p[left].b, map.get(p[left].b) - 1);
				++left;
			}
		}
		System.out.println(min);
		br.close();
	}
	static class Photos implements Comparable<Photos> {
		public int p, b;
		public int compareTo(Photos pho) {
			return this.p - pho.p;
		}
		public Photos(int position, int breed) {
			this.p = position;
			this.b = breed;
		}
	}
}