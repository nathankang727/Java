package ACSL07_08;
import java.util.*;
import java.io.*;
public class C2JR_DataCompression {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0708C2Jr.in"));
		for(int i = 0; i < 9; i++) {
			String s = sc.nextLine();
			int howManyChanges = 1;
			for(int j = 0; j < s.length() - 1; j++)
				if(s.charAt(j + 1) != s.charAt(j))
					howManyChanges++;
			char[] characters = new char[howManyChanges];
			int[] numbers = new int[howManyChanges];
			char a = s.charAt(0);
			for(int j = 0, k = 0; j < s.length(); j++) {
				if(a != s.charAt(j))
					k++;
				characters[k] = s.charAt(j);
				numbers[k]++;
				a = s.charAt(j);
			}
			for(int j = 0; j < numbers.length; j++)
				System.out.print(numbers[j] + String.valueOf(characters[j]));
			System.out.println();
		}
		sc.close();
	}
}