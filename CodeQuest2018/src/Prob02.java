import java.io.*;
public class Prob02 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new FileReader(new File("Prob02.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int n = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < n; i++) {
        	String input = br.readLine();
        	int cnt = 0;
        	for(int j = 0; j < input.length(); j++)
        		if(input.charAt(j) == 'a' || input.charAt(j) == 'e' || input.charAt(j) == 'i' || input.charAt(j) == 'o' ||
        		input.charAt(j) == 'u')
        			++cnt;
        	pw.println(cnt);
        }
        br.close();
        pw.close();
        Check.check("Prob02.out.txt");
    }
}