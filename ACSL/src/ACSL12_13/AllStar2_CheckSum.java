package ACSL12_13;
import java.io.*;
public class AllStar2_CheckSum {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1213AllStar2.in")));
		for(int i = 0; i < 10; i++) {
			String num = br.readLine();
			int checkSum = Integer.parseInt(num.substring(num.length() - 1));
			int[] digits = new int[num.length() - 1];
			for(int j = 0; j < num.length() - 1; j++)
				digits[j] = Integer.parseInt(num.substring(j, j + 1));
			int n = algorithm(digits);
			if(n == checkSum)
				System.out.println("VALID");
			else {
				for(int j = 0; j < digits.length; j++) {
					int temp = digits[j];
					int a = digits[j] + 1;
					int b = digits[j] - 1;
					if(b == -1)
						b = 9;
					if(a == 10)
						a = 0;
					digits[j] = a;
					int n1 = algorithm(digits);
					if(n1 == checkSum)
						break;
					digits[j] = b;
					n1 = algorithm(digits);
					if(n1 == checkSum)
						break;
					digits[j] = temp;
				}
				String res = "";
				for(int j = 0; j < digits.length; j++)
					res += String.valueOf(digits[j]);
				System.out.println(res + checkSum);
			}
		}
		br.close();
	}
	public static int algorithm(int[] digits) {
		int[] copy = new int[digits.length];
		int sum = 0;
		for(int i = 0; i < digits.length; i++)
			copy[i] = digits[i];
		for(int i = digits.length - 1; i >= 0; i -= 2) {
			copy[i] = copy[i] * 2;
			if(copy[i] > 9)
				copy[i] = sumOfDigits(copy[i]);
		}
		for(int i = 0; i < digits.length; i++)
			sum += copy[i];
		sum = (sum * 9);
		sum = sum % 10;
		return sum;
	}
	public static int sumOfDigits(int n) {
		String s = String.valueOf(n);
		int sum = 0;
		for(int i = 0; i < s.length(); i++)
			sum += Integer.parseInt(s.substring(i, i + 1));
		return sum;
	}
}