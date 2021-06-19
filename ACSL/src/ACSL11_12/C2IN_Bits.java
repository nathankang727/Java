package ACSL11_12;
import java.io.*;
import java.util.*;
public class C2IN_Bits {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1112C2In.in"));
		for(int i = 0; i < 5; i++) {
			String small = in.next();
			String[] choices = new String[in.nextInt()];
			String result = "";
			for(int j = 0; j < choices.length; j++)
				choices[j] = in.next();
			boolean c = true;
			for(int j = 0; j < choices.length; j++) {
				for(int k = 0; k < small.length(); k++) {
					c = true;
					if(small.charAt(k) == '*')
						continue;
					if(small.charAt(k) != choices[j].charAt(k)) {
						c = false;
						break;
					}
				}
				if(c == true)
					result += choices[j] + " ";
			}
			if(result.length() == 0)
				result = "NONE";
			System.out.println(result);
		}
		in.close();
	}
}