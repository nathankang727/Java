package ACSL20_21;
import java.util.*;
import java.io.*;
public class C4IN_Graphs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(sumPathsOfLength2(input));
		br.close();
	}
	public static int sumPathsOfLength2(String edges) {
		int sum = 0;
		String[] allLen2 = new String[504];
		int permuteIndex = 0;
		for(int i = 1; i <= 9; i++) {
			for(int j = 1; j <= 9; j++) {
				if(i == j)
					continue;
				for(int k = 1; k <= 9; k++) {
					if(i == k || j == k)
						continue;
					allLen2[permuteIndex] = String.valueOf(i) + String.valueOf(j) + String.valueOf(k);
					++permuteIndex;
				}
			}
		}
		String[] input = edges.split(" ");
		ArrayList<String> graph = new ArrayList<String>();
		for(int i = 0; i < input.length; i++)
			graph.add(input[i]);
		for(int i = 0; i < 504; i++) {
			String a = allLen2[i].substring(0, 2);
			String b = allLen2[i].substring(1);
			if(graph.contains(a) && graph.contains(b))
				sum += Integer.parseInt(allLen2[i]);
		}
		return sum;
	}
}