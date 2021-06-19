package ACSL17_18;
import java.util.*;
import java.io.*;
public class AllStar3_HexGridWalk {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1718AllStar3.in")));
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String token1 = st.nextToken();
			char letter = token1.charAt(0);
			int position = Integer.parseInt(token1.substring(1));
			String token2 = st.nextToken();
			for(int j = 0; j < token2.length(); j++) {
				int movement = Integer.parseInt(token2.substring(j, j + 1));
				char ogLetter = letter;
				int ogPosition = position;
				if(movement == 1)
					++position;
				else if(movement == 2) {
					letter = (char)(letter + 1);
					position = (letter - 'A') % 2 == 0 ? position : position + 1;
				}
				else if(movement == 3) {
					letter = (char)(letter + 1);
					position = (letter - 'A') % 2 == 1 ? position : position - 1;
				}
				else if(movement == 4)
					--position;
				else if(movement == 5) {
					letter = (char)(letter - 1);
					position = (letter - 'A') % 2 == 1 ? position : position - 1;
				}
				else {
					letter = (char)(letter - 1);
					position = (letter - 'A') % 2 == 0 ? position : position + 1;
				}
				if(letter - 'A' > 25 || letter - 'A' < 0 || position < 1) {
					letter = ogLetter;
					position = ogPosition; 
				}
			}
			System.out.println(letter + "" + position);
		}
		br.close();
	}
}