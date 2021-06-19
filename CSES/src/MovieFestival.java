import java.util.*;
import java.io.*;
public class MovieFestival {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		MovieSort[] movies = new MovieSort[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			movies[i] = new MovieSort(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(movies);
		int count = 0;
		int time = 0;
		for(int i = 0; i < n; i++) {
			if(time <= movies[i].a) {
				time = movies[i].b;
				++count;
			}
		}
		System.out.println(count);
		br.close();
	}
	static class MovieSort implements Comparable<MovieSort> {
		public int a, b;
		public int compareTo(MovieSort ms) {
			return this.b - ms.b;
		}
		public MovieSort(int start, int end) {
			this.a = start;
			this.b = end;
		}
	}
}