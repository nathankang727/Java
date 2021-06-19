import java.io.*;
public class Prob15 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob15.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	String s = br.readLine();
        	String s2 = "";
        	String alpha = " ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        	for(int j = 0; j < s.length(); j++) {
        		char c = s.charAt(j);
        		int c2 = 0;
        		if(c >= 'A' && c <= 'E')
        			c2 = alpha.indexOf(String.valueOf(c)) + 6;
        		else if(c >= 'F' && c <= 'J')
        			c2 = alpha.indexOf(String.valueOf(c)) * alpha.indexOf(String.valueOf(c));
        		else if(c >= 'K' && c <= 'O')
        			c2 = alpha.indexOf(String.valueOf(c)) % 3 * 5 + 1;
        		else if(c >= 'P' && c <= 'T')
        			c2 = sum(alpha.indexOf(String.valueOf(c))) * 8;
        		else
        			c2 = factor(alpha.indexOf(String.valueOf(c))) * 2;
        		if(c2 == 26)
        			s2 += "Z";
        		else {
        			c2 %= 26;
        			if(c2 == 0)
        				s2 += String.valueOf(c);
        			else
        				s2 += alpha.substring(c2, c2 + 1);
        		}
        	}
        	pw.println(s2);
        }
        br.close();
        pw.close();
        Check.check("Prob15.out.txt");
	}
	public static int sum(int n) {
		String s = String.valueOf(n);
		int ret = 0;
		for(int i = 0; i < s.length(); i++)
			ret += Integer.parseInt(s.substring(i, i + 1));
		return ret;
	}
	public static int factor(int n) {
		for(int i = 2; i <= n; i++) {
			if(n % i == 0)
				return n / i;
		}
		return 1;
	}
}