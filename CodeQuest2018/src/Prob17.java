import java.util.*;
import java.io.*;
public class Prob17 {
	public static void main(String[] args) throws IOException {
		String file = "Prob17";
		Scanner in = new Scanner(new File(file + ".in.txt"));
		PrintWriter out = new PrintWriter(new File("out.txt"));
		int n = Integer.parseInt(in.nextLine());
		for (int i = 0; i < n; i++) {
			String s = in.nextLine();
			char res = ' ';
			if (s.charAt(0) == s.charAt(1) && s.charAt(1) == s.charAt(2))
				res = s.charAt(0);
			else if (s.charAt(6) == s.charAt(7) && s.charAt(7) == s.charAt(8))
				res = s.charAt(6);
			else if (s.charAt(3) == s.charAt(4) && s.charAt(4) == s.charAt(5))
				res = s.charAt(3);
			else if (s.charAt(6) == s.charAt(7) && s.charAt(7) == s.charAt(8))
				res = s.charAt(6);
			else if (s.charAt(0) == s.charAt(4) && s.charAt(4) == s.charAt(8))
				res = s.charAt(0);
			else if (s.charAt(2) == s.charAt(4) && s.charAt(4) == s.charAt(6))
				res = s.charAt(2);
			else if (s.charAt(0) == s.charAt(3) && s.charAt(3) == s.charAt(6))
				res = s.charAt(0);
			else if (s.charAt(1) == s.charAt(4) && s.charAt(4) == s.charAt(7))
				res = s.charAt(1);
			else if (s.charAt(2) == s.charAt(5) && s.charAt(5) == s.charAt(8))
				res = s.charAt(2);
			if (res == 'X')
				out.println(s + " = X WINS");
			else if (res == 'O')
				out.println(s + " = O WINS");
			else
				out.println(s + " = TIE");
		}
		in.close();
		out.close();
		Check.check(file + ".out.txt");
	}
}
