import java.io.*;
public class prob14 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int f0 = Integer.parseInt(br.readLine());
		int f1 = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		System.out.print(f0 + "," + f1);
		for(int i = 0; i < n - 2; i++) {
			int f2 = f0 + f1;
			System.out.print("," + f2);
			f0 = f1;
			f1 = f2;
		}
		br.close();
	}
}