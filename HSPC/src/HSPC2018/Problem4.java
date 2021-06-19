package HSPC2018;
import java.util.*;
import java.io.*;
public class Problem4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		boolean works = true;
		for(int i = 0; i < m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				if(Integer.parseInt(st.nextToken()) != 0 && i != j && i != j + 1 && i != j - 1) {
					works = false;
					break;
				}
			}
		}
		System.out.println(works ? "True" : "False");
	}
}