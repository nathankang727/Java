import java.util.*;
import java.io.*;
public class Prob14 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new FileReader(new File("Prob14.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(sc.nextLine()); 
        for(int i = 0; i < t; i++) {
        	int u = Integer.parseInt(sc.nextLine());
        	int[] uLen = new int[u];
        	StringTokenizer st = new StringTokenizer(sc.nextLine());
        	for(int j = 0; j < u; j++)
        		uLen[j] = Integer.parseInt(st.nextToken());
        	int l = Integer.parseInt(sc.nextLine());
        	int[] lLen = new int[l];
        	st = new StringTokenizer(sc.nextLine());
        	for(int j = 0; j < l; j++)
        		lLen[j] = Integer.parseInt(st.nextToken());
        	String s = "";
        	while(sc.hasNextLine()) {
        		s += sc.nextLine();
        	}
        	String upper = "";
        	String lower = "";
        	String uAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZ-";
        	int uCapacity = 0;
        	int lCapacity = 0;
        	int uIndex = 0;
        	int lIndex = 0;
        	for(int j = 0; j < s.length(); j++) {
        		String c = s.substring(j, j + 1);
        		if(uAlpha.contains(c)) {
        			upper += c;
        			++uCapacity;
        			if(uCapacity == uLen[uIndex]) {
        				uCapacity = 0;
        				upper += "\n";
        				++uIndex;
        			}
        		}
        		else {
        			lower += c;
        			++lCapacity;
        			if(lCapacity == lLen[lIndex]) {
        				lCapacity = 0;
        				lower += "\n";
        				++lIndex;
        			}
        		}
        	}
        	pw.println(upper.replace("-", " "));
        	pw.print(lower.replace("=", " "));
        }
        sc.close();
        pw.close();
        Check.check("Prob14.out.txt");
	}
}