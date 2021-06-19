package ACSL17_18;
import java.io.*;
public class C2JR_Enclosure {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1718C2Jr.in"));
		for(int i = 0; i < 10; i++) {
			String equation = br.readLine().replace(" ", "");
			int open = equation.indexOf("(");
			int end = equation.indexOf(")");
			if(open != -1)
				for(int j = open + 5; j <= equation.length() + 1; j += 2)
					System.out.print(j + " ");
			else
				for(int j = 1; j <= end - 2; j += 2)
					System.out.print(j + " ");
			System.out.println();
		}
		br.close();
	}
}