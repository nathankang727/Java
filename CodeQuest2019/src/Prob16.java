import java.io.*;
public class Prob16 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob16.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	int n = Integer.parseInt(br.readLine());
        	String cipherText = br.readLine().toLowerCase();
        	for(int j = 0; j < n; j++) {
        		String key = br.readLine().toLowerCase();
        		String answer = "[";
        		for(int k = 0; k < key.length(); k += 2) {
        			String binary1 = convert(cipherText.charAt(k)) + convert(cipherText.charAt(k + 1));
        			String binary2 = convert(key.charAt(k)) + convert(key.charAt(k + 1));
        			boolean[] b1 = new boolean[8];
        			boolean[] b2 = new boolean[8];
        			boolean[] b3 = new boolean[8];
        			String binary3 = "";
        			for(int l = 0; l < 8; l++) {
        				if(binary1.charAt(l) == '1')
        					b1[l] = true;
        				if(binary2.charAt(l) == '1')
        					b2[l] = true;
        				b3[l] = b1[l] ^ b2[l];
        				binary3 += b3[l] ? "1" : "0";
        			}
        			int num = Integer.parseInt(binary3, 2);
        			answer += (char)(num);
        		}
        		pw.println(answer + "]");
        	}
        }
        br.close();
        pw.close();
        Check.check("Prob16.out.txt");
	}
	public static String convert(char c) {
		if(c == '0')
			return "0000";
		else if(c == '1')
			return "0001";
		else if(c == '2')
			return "0010";
		else if(c == '3')
			return "0011";
		else if(c == '4')
			return "0100";
		else if(c == '5')
			return "0101";
		else if(c == '6')
			return "0110";
		else if(c == '7')
			return "0111";
		else if(c == '8')
			return "1000";
		else if(c == '9')
			return "1001";
		else if(c == 'a')
			return "1010";
		else if(c == 'b')
			return "1011";
		else if(c == 'c')
			return "1100";
		else if(c == 'd')
			return "1101";
		else if(c == 'e')
			return "1110";
		else
			return "1111";
	}
}