import java.io.*;
public class ProbTemplate {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob00.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	
        }
        br.close();
        pw.close();
        Check.check("Prob00.out.txt");
	}
}