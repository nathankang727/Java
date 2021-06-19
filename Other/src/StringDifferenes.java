import java.util.*;
public class StringDifferenes {
	public static void main(String[]args) {
		Scanner in = new Scanner(System.in);
		String first = in.next();
		String second = in.next();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		sb1.append(first);
		sb2.append(second);
		for(int i = 0; i < first.length()-1; i++) {
			if(first.charAt(i) == first.charAt(i+1)) {
				sb1.deleteCharAt(i);
				i--;
				first = sb1.toString();
			}
		}
		for(int i = 1; i < first.length(); i++) {
			if(first.charAt(i) == 'A' || first.charAt(i) == 'E' || 
					first.charAt(i) == 'I' || first.charAt(i) == 'U' || 
					first.charAt(i) == 'O') {
				sb1.deleteCharAt(i);
				i--;
				first = sb1.toString();
			}
		}
		for(int i = 0; i < second.length()-1; i++) {
			if(second.charAt(i) == second.charAt(i+1)) {
				sb2.deleteCharAt(i);
				i--;
				second = sb2.toString();
			}
		}
		for(int i = 1; i < second.length(); i++) {
			if(second.charAt(i) == 'A' || second.charAt(i) == 'E' || 
					second.charAt(i) == 'I' || second.charAt(i) == 'U' || 
					second.charAt(i) == 'O') {
				sb2.deleteCharAt(i);
				i--;
				second = sb2.toString();
			}
		}
		first = sb1.toString();
		second = sb2.toString();
		char [] arr1 = new char[first.length()-1];
		char [] arr2 = new char[second.length()-1];
		for(int i = 0; i < first.length()-1; i++) {
			arr1[i] = first.charAt(i);
		}
		for(int i = 0; i < second.length()-1; i++) {
			arr2[i] = second.charAt(i);
		}
		int length = Math.min(first.length()-1, second.length()-1);
		for(int i = 0; i < length; i++) {
			if(first.charAt(i) == second.charAt(i)) {
				sb1.deleteCharAt(i);
				sb2.deleteCharAt(i);
				i--;
				first = sb1.toString();
				second = sb2.toString();
				length--;
			}
		}
		first = sb1.toString();
		second = sb2.toString();
		int firstlength = first.length()-1;
		int secondlength = second.length()-1;
		length = Math.min(first.length(), second.length());
		for(int i = 0; i < length - 1; i++) {
			if(firstlength < i)
				firstlength = i;
			if(secondlength < i)
				secondlength = i;
			if(first.charAt(firstlength - i) == second.charAt(secondlength - i)) {
				sb1.deleteCharAt(firstlength - i);
				sb2.deleteCharAt(secondlength - i);
				firstlength--;
				secondlength--;
				i--;
				first = sb1.toString();
				second = sb2.toString();
			}
		}
		first = sb1.toString();
		second = sb2.toString();
		if(first.length() < second.length())
			System.out.println(first);
		else if(second.length() < first.length())
			System.out.println(second);
		else {
			if(first.compareTo(second) <= 0)
				System.out.println(first);
			else
				System.out.println(second);
		}
		in.close();
	}
}