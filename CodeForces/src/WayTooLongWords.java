import java.io.*;
public class WayTooLongWords {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			if(s.length() < 11)
				System.out.println(s);
			else
				System.out.println(s.substring(0, 1) + String.valueOf(s.length() - 2) + s.substring(s.length() - 1));
		}
		br.close();
	}
}