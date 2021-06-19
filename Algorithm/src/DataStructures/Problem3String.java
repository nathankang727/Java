package DataStructures;
import java.util.*;
import java.io.*;
public class Problem3String {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(System.in);
		ArrayList<String> words = new ArrayList<String>();
		while(in.hasNextLine()) {
			int[] res = new int[4];
			String a = in.nextLine();
			String b = "";
			for(int i = 0; i < a.length(); i++) {
				if(a.charAt(i) == ' ')
					res[3]++;
				else if(a.charAt(i) - 'A' < 0)
					res[2]++;
				else if(a.charAt(i) - 'a' < 0)
					res[1]++;
				else
					res[0]++;
			}
			for(int i = 0; i < 4; i++)
				b += res[i] + " ";
			words.add(b);
		}
		for(int i = 0; i < words.size(); i++)
			System.out.println(words.get(i));
		in.close();
	}
}