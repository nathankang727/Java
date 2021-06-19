package CodeQuest2018;
import java.io.*;
public class Prob17 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob17.in.txt")));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			char res = ' ';
			if(s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2))
				res = s.charAt(0);
			else if(s.charAt(3) == s.charAt(4) && s.charAt(4) == s.charAt(5))
				res = s.charAt(3);
			else if(s.charAt(6) == s.charAt(7) && s.charAt(7) == s.charAt(8))
				res = s.charAt(6);
			else if(s.charAt(0) == s.charAt(4) && s.charAt(4) == s.charAt(8))
				res = s.charAt(0);
			else if(s.charAt(2) == s.charAt(4) && s.charAt(4) == s.charAt(6))
				res = s.charAt(2);
			else if(s.charAt(0) == s.charAt(3) && s.charAt(3) == s.charAt(6))
				res = s.charAt(0);
			else if(s.charAt(1) == s.charAt(4) && s.charAt(4) == s.charAt(7))
				res = s.charAt(1);
			else if(s.charAt(2) == s.charAt(5) && s.charAt(5) == s.charAt(8))
				res = s.charAt(2);
			if(res == 'X')
				System.out.println(s + " = X WINS");
			else if(res == 'O')
				System.out.println(s + " = O WINS");
			else
				System.out.println(s + " = TIE");
		}
		br.close();
	}
}