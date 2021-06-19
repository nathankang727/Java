package CodeQuest2016;
import java.io.*;
public class Prob15 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob15.in.txt")));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			Prob15 prob = new Prob15();
			int n = Integer.parseInt(br.readLine());
			System.out.println(n);
			prob.solve(n, "A", "B", "C");
		}
		br.close();
	}
	public void solve(int n, String start, String auxiliary, String end) {
		if(n == 1)
			System.out.println(start + " -> " + end);
		else {
			solve(n - 1, start, end, auxiliary);
			System.out.println(start + " -> " + end);
			solve(n - 1, auxiliary, start, end);
		}
	}
}