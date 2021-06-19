import java.util.*;
import java.io.*;
public class prob21 {
	static ArrayList<ArrayList<Long>> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int t = Integer.parseInt(br.readLine());
		for(int i = 1; i <= t; i++) {
			list = new ArrayList<ArrayList<Long>>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			long[] planets = new long[p];
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < planets.length; j++)
				planets[j] = Long.parseLong(st.nextToken());
			Arrays.sort(planets);
			long[] temp = new long[r];
			recursion(planets, temp, 0, p - 1, 0, r);
			long ans = 0;
			long planetEnd = planets[planets.length - 1];
			for(int j = 0; j < list.size(); j++) {
				long min = list.get(j).get(0);
				for(int k = 1; k < list.get(j).size(); k++) {
					min = Math.min(min, list.get(j).get(k) - list.get(j).get(k - 1));
				}
				min = Math.min(min, planetEnd - list.get(j).get(list.get(j).size() - 1));
				ans = Math.max(ans, min);
			}
			System.out.println(i + ": " + ans);
		}
		br.close();
	}
	public static void recursion(long[] planets, long[] temp, int start, int end, int index, int r) {
		if(index == r) {
			list.add(new ArrayList<Long>());
			for(int i = 0; i < r; i++)
				list.get(list.size() - 1).add(temp[i]);
			return;
		}
		for(int i = start; i <= end && end - i + 1 >= r - index; i++) {
			temp[index] = planets[i];
			recursion(planets, temp, i + 1, end, index + 1, r);
		}
	}
}