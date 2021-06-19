import java.io.*;
public class prob02 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		String s = br.readLine();
		StringBuilder sb = new StringBuilder();
		sb.append(s);
		sb.reverse();
		System.out.println(sb.toString());
		br.close();
	}
}