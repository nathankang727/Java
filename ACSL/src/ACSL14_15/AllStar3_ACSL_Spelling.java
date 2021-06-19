package ACSL14_15;
import java.util.*;
import java.io.*;
public class AllStar3_ACSL_Spelling {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1415AllStar3.in")));
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 5; j++) {
				String word = br.readLine();
				char end1 = word.charAt(word.length() - 1);
				char end2 = word.charAt(word.length() - 2);
				String end = word.substring(word.length() - 2);
				if(end.equals("ch") || end.equals("sh") || end1 == 's' || end1 == 'x' || end1 == 'z')
					word += "es";
				else if(end1 == 'y' && end2 != 'a' && end2 != 'e' && end2 != 'i' && end2 != 'o' && end2 != 'u')
					word = word.substring(0, word.length() - 1) + "ies";
				else if(end1 == 'f')
					word = word.substring(0, word.length() - 1) + "ves";
				else if(end.equals("fe"))
					word = word.substring(0, word.length() - 2) + "ves";
				else if(end1 == 'o' && end2 != 'a' && end2 != 'e' && end2 != 'i' && end2 != 'o' && end2 != 'u')
					word += "es";
				else
					word += "s";
				System.out.println(word);
			}
			for(int j = 0; j < 5; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String word = st.nextToken();
				String suffix = st.nextToken();
				char firstS = suffix.charAt(0);
				char lastW1 = word.charAt(word.length() - 1);
				char lastW2 = word.charAt(word.length() - 2);
				char lastW3 = word.charAt(word.length() - 3);
				if(lastW1 == 'y' && firstS != 'i')
					word = word.substring(0, word.length() - 1) + "i" + suffix;
				else if((firstS == 'a' || firstS == 'e' || firstS == 'i' || firstS == 'o' || firstS == 'u') && lastW1 == 'e')
						word = word.substring(0, word.length() - 1) + suffix;
				else if(lastW1 != 'a' && lastW1 != 'e' && lastW1 != 'i' && lastW1 != 'o' && lastW1 != 'u' && (lastW2 == 'a'
						|| lastW2 == 'e' || lastW2 == 'i' || lastW2 == 'o' || lastW2 == 'u') && lastW3 != 'a' && 
						lastW3 != 'e' && lastW3 != 'i' && lastW3 != 'o' && lastW3 != 'u' && (firstS == 'a' || firstS == 'e'
						|| firstS == 'i' || firstS == 'o' || firstS == 'u' && lastW1 == 'e')) {
							word = word + lastW1 + suffix;
				}
				else
					word += suffix;
				System.out.println(word);
			}
		}
		br.close();
	}
}