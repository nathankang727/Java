import java.util.*;
import java.io.*;
public class StationNames {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i = 0; i < n; i++) {
			int vowelcount = 0;
			String s = br.readLine().toLowerCase();
			for(int j = 0; j < s.length(); j++)
				if(s.charAt(j) == 'a' || s.charAt(j) == 'e' || s.charAt(j) == 'i' || s.charAt(j) == 'o' || s.charAt(j) == 'u')
					vowelcount++;
			if(vowelcount <= k)
				++ans;
		}
		System.out.println(ans);
		br.close();
	}
}