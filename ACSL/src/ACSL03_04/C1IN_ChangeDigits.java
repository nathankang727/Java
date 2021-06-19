package ACSL03_04;
import java.util.*;
import java.io.*;
public class C1IN_ChangeDigits {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("0304C1IN.in"));
		for(int i = 0; i < 10; i++) {
			String number = br.readLine();
			int[] sorted = new int[number.length()];
			String[] newNumber = new String[number.length()];
			for(int j = 0; j < number.length(); j++) {
				sorted[j] = Integer.parseInt(number.substring(j, j + 1));
				newNumber[j] = number.substring(j, j + 1);
			}
			Arrays.sort(sorted);
			int sum = 0;
			int largest = sorted[sorted.length - 1];
			int smallest = sorted[0];
			int mean = 0;
			int closest = 0;
			int index = 0;
			for(int j = 0; j < number.length(); j++)
				sum += Integer.parseInt(number.substring(j, j + 1));
			mean = sum / number.length();
			for(int j = number.length() - 1; j >= 0; j--) {
				int n = Integer.parseInt(number.substring(j, j + 1));
				if(n <= mean && n >= closest) {
					closest = n;
					index = j;
				}
			}
			if(closest == 0 || closest == 1 || closest == 2)
				closest = largest;
			else if(closest == 3 || closest == 4 || closest == 5)
				closest = smallest;
			else if(closest == 6 || closest == 7 || closest == 8) {
				String n = String.valueOf(sum);
				closest = Integer.parseInt(n.substring(n.length() - 1));
			}
			else
				closest = 0;
			newNumber[index] = String.valueOf(closest);
			String res = "";
			for(int j = 0; j < newNumber.length; j++)
				res += newNumber[j];
			System.out.println(Integer.parseInt(res));
		}
		br.close();
	}
}