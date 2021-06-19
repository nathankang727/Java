/*
Start time: 5:35
End time: 
*/
package ACSL01_02;
import java.io.*;
public class C1JR_WrapAroundCode {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader("0102C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			char letter = br.readLine().charAt(0);
			char[] alphabet = {'#', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'h', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q',
			'R', 'S', 'T', 'U', 'v', 'W', 'X', 'Y', 'Z'};
			int num = letter - 'A' + 1;
			if(num >= 1 && num <= 5)
				num *= 2;
			else if(num >= 6 && num <= 10) {
				num %= 3;
				num *= 5;
			}
			else if(num >= 11 && num <= 15) {
				num /= 4;
				num *= 8;
			}
			else if(num >= 16 && num <= 20) {
				String a = String.valueOf(num);
				int b = Integer.parseInt(a.substring(0, 1)) + Integer.parseInt(a.substring(1, 2));
				num = b * 10;
			}
			else if(num >= 21 && num <= 26) {
				if(num == 21)
					num = 7;
				else if(num == 22)
					num = 11;
				else if(num == 23)
					num = 1;
				else if(num == 24)
					num = 12;
				else if(num == 25)
					num = 5;
				else if(num == 26)
					num = 13;
				num *= 12;
			}
			if(num > 26) {
				num %= 26;
				if(num == 0)
					num = 26;
			}
			System.out.println(alphabet[num]);
		}
		br.close();
	}
}