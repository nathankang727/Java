import java.io.*;
public class prob23 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i = 0; i < n; i++) {
			String s = br.readLine();
			s = s.toLowerCase().replaceAll("[^a-z ]", "");
			String[] str = s.split("");
			for(int j = 0; j < str.length; j++) {
				if(str[j].equals("a"))
					str[j] = "e";
				else if(str[j].equals("e"))
					str[j] = "a";
				else if(str[j].equals("b"))
					str[j] = "q";
				else if(str[j].equals("q"))
					str[j] = "b";
				else if(str[j].equals("d"))
					str[j] = "p";
				else if(str[j].equals("p"))
					str[j] = "d";
				else if(str[j].equals("h"))
					str[j] = "y";
				else if(str[j].equals("y"))
					str[j] = "h";
				else if(str[j].equals("m"))
					str[j] = "w";
				else if(str[j].equals("w"))
					str[j] = "m";
				else if(str[j].equals("n"))
					str[j] = "u";
				else if(str[j].equals("u"))
					str[j] = "n";
			}
			String ans = "";
			for(int j = str.length - 1; j >= 0; j--)
				ans += str[j];
			System.out.println(s + " (" + (s.replace(" ", "").equals(ans.replace(" ", "")) ? "is" : "not") + ") " + ans);
		}
	}
}