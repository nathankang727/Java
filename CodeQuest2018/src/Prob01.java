import java.io.*;
public class Prob01 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File("Prob01.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int n = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < n; i++) {
        	int grade = Integer.parseInt(br.readLine());
        	pw.println(grade >= 70 ? "PASS" : "FAIL");
        }
        br.close();
        pw.close();
        Check.check("Prob01.out.txt");
    }
}