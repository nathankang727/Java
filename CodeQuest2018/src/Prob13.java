import java.util.*;
import java.io.*;
public class Prob13 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob13.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	int n = Integer.parseInt(br.readLine());
        	String[] input = br.readLine().replace("[", "").replace("]", "").replace(",", " ").split(" ");
        	String[][] input2 = new String[n][6];
        	Map<String, Integer> map = new HashMap<String, Integer>();
        	int index = 0;
        	for(int j = 0; j < 6; j++) {
        		for(int k = 0; k < n; k++) {
        			if(j == 0)
        				map.put(input[index], k);
        			input2[k][j] = input[index];
        			++index;
        		}
        	}
        	for(int j = 0; j < n; j++) {
        		String s = br.readLine();
        		int index2 = map.get(s);
        		pw.println("Name: " + input2[index2][0]);
        		pw.println("Age: " + input2[index2][1]);
        		pw.println("Instagram: " + input2[index2][2]);
        		pw.println("Twitter: " + input2[index2][3]);
        		pw.println("Phone: " + input2[index2][4]);
        		pw.println("Email: " + input2[index2][5]);
        	}
        }
        br.close();
        pw.close();
        Check.check("Prob13.out.txt");
	}
}