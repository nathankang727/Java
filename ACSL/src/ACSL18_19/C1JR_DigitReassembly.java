package ACSL18_19;
import java.io.*;
public class C1JR_DigitReassembly {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1819C2Jr.in")));
		String s1 = br.readLine();
		System.out.println(s1.length());
		String s2 = br.readLine();
		int res2 = 0;
		for(int i = 0; i < s2.length(); i++)
			res2 += Integer.parseInt(s2.substring(i, i + 1));
		System.out.println(res2);
		String s3 = br.readLine();
		int res3 = 0;
		for(int i = 0; i < s3.length(); i += 2)
			res3 += Integer.parseInt(s3.substring(i, i + 1));
		System.out.println(res3);
		String s4 = br.readLine();
		int res4 = 0;
		for(int i = 0; i < s4.length(); i++)
			if(s4.charAt(i) == '4')
				res4++;
		System.out.println(res4);
		String s5 = br.readLine();
		if(s5.length() % 2 == 0)
			s5 = " " + s5;
		System.out.println(s5.charAt(s5.length() / 2));
		br.close();
	}
}