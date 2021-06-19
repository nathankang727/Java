package ACSL09_10;
import java.io.*;
public class C2JR_ACSL_NYSIIS {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("0910C2Jr.in"));
		for(int i = 0; i < 10; i++) {
			String s = br.readLine();
			String[] word = s.split("");
			if(s.substring(0, 3).equals("MAC")) {
				word[0] = "M";
				word[1] = "C";
				word[2] = "";
			}
			if(s.substring(0, 2).equals("KN")) {
				word[0] = "N";
				word[1] = "";
			}
			if(s.substring(0, 1).equals("K") && word[0] != "N")
				word[0] = "C";
			if(s.substring(0, 2).equals("PH") || s.substring(0, 2).equals("PF")) {
				word[0] = "F";
				word[1] = "";
			}
			if(s.substring(0, 3).equals("SCH")) {
				word[0] = "S";
				word[1] = "";
				word[2] = "";
			}
			if(s.substring(s.length() - 2).equals("EE") || s.substring(s.length() - 2).equals("IE")) {
				word[word.length - 2] = "";
				word[word.length - 1] = "Y";
			}
			if(s.substring(s.length() - 2).equals("DT") || s.substring(s.length() - 2).equals("RT") || s.substring(s.length() - 2).equals("RD") || s.substring(s.length() - 2).equals("NT") || s.substring(s.length() - 2).equals("ND")) {
				word[word.length - 2] = "";
				word[word.length - 1] = "D";
			}
			for(int j = 1; j < word.length; j++)
				if(word[j].equals("A") || word[j].equals("E") || word[j].equals("I") || word[j].equals("O") || word[j].equals("U"))
					word[j] = "A";
			if(word[word.length - 1].equals("S"))
				word[word.length - 1] = "";
			String string = word[word.length - 2] + word[word.length - 1];
			if(string.equals("AY")) {
				word[word.length - 2] = "";
				word[word.length - 1] = "Y";
			}
			if(word[word.length - 1].equals("A"))
				word[word.length - 1] = "";
			for(int j = 1; j < word.length - 1; j++)
				if(word[j].equals(word[j + 1]))
					word[j + 1] = "";
			if(word.length <= 6)
				for(int j = 0; j < word.length; j++)
					System.out.print(word[j]);
			else {
				String res = "";
				for(int j = 0; j < word.length; j++)
					res += word[j];
				if(res.length() <= 6)
					System.out.print(res);
				else
					System.out.print(res.substring(0, 6));
			}
			System.out.println();
		}
		br.close();
	}
}