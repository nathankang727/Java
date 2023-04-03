package ACSL22_23;
import java.io.*;
public class C2IN_BinaryCounting {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(findLastBinary(br.readLine()));
		br.close();
	}
	public static int findLastBinary(String s) {
		int num = 0;
		String binaryNum = Integer.toString(num, 2);
		String binaryS = "";
		for(int i = 0; i < s.length(); i++) {
			String binaryCharacter = Integer.toString((int)(s.charAt(i)), 2);
			int len = binaryCharacter.length();
			for(int j = 0; j < 8 - len; j++)
				binaryCharacter = "0" + binaryCharacter;
			binaryS += binaryCharacter;
		}
		while(binaryS.indexOf(binaryNum) >= 0) {
			int start = binaryS.indexOf(binaryNum);
			int end = binaryS.lastIndexOf(binaryNum);
			if(start == end || start + binaryNum.length() >= end)
				binaryS = binaryS.substring(0, start) + binaryS.substring(start + binaryNum.length());
			else {
				binaryS = binaryS.substring(0, start) + binaryS.substring(start + binaryNum.length(), end) + 
						binaryS.substring(end + binaryNum.length());
			}
			++num;
			binaryNum = Integer.toString(num, 2);
		}
		return num - 1;
	}
}