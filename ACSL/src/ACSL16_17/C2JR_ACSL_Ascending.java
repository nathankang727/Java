package ACSL16_17;
import java.io.*;
public class C2JR_ACSL_Ascending {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1617C2Jr.in"));
		for(int i = 0; i < 10; i++) {
			String s = br.readLine();
			String number = "";
			String pn = "";
			for(int j = 0; j < s.length(); j++) {
				if(j == 0)
					pn = s.substring(j, j + 1);
				else {
					number += s.charAt(j);
					while(Integer.parseInt(number) <= Integer.parseInt(pn) && j != s.length() - 1) {
						j++;
						number += s.substring(j, j + 1);
					}
					if(Integer.parseInt(pn) > Integer.parseInt(number))
						pn = "";
					else
						pn = number;
					number = "";
				}
				System.out.print(pn + " ");
			}
			System.out.println();
		}
		br.close();
	}
} 