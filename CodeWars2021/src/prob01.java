import java.io.*;
public class prob01 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		System.out.println(br.readLine() + ", the needs of the many outweigh the needs of the few, or the one; live long and prosper.");
		br.close();
	}
}