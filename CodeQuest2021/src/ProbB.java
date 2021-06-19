import java.util.*;
import java.io.*;
public class ProbB {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine().replace(":", " "));
        	double d1 = Double.parseDouble(st.nextToken());
        	double d2 = Double.parseDouble(st.nextToken());
        	double d3 = d2 / d1;
        	System.out.println(d3);
        	if(d3 <= 1)
        		System.out.println("SWERVE");
        	else if(d3 <= 5)
        		System.out.println("BRAKE");
        	else
        		System.out.println("SAFE");
        }
        br.close();
	}
}