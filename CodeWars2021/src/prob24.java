import java.io.*;
public class prob24 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String encrypt = br.readLine();
		String key = br.readLine();
		String bitString = "";
		for(int i = 0; i < encrypt.length(); i++) {
			int c = key.indexOf(encrypt.charAt(i));
			c -= 8;
			String temp = Integer.toString(c, 2);
			int temp2 = temp.length();
			for(int j = 0; j < 6 - temp2; j++)
				temp = "0" + temp;
			bitString += temp;
		}
		String ans = "";
		for(int i = 0; i < bitString.length(); i += 8) {
			String temp = bitString.substring(i, i + 8);
			ans += (char)(Integer.parseInt(temp, 2)) + "";
		}
		System.out.println(ans);
		br.close();
	}
}