import java.io.*;
public class ProbA {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	System.out.println(br.readLine());
        }
        br.close();
	}
}