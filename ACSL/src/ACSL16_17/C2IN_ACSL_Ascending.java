package ACSL16_17;
import java.util.*;
import java.io.*;
public class C2IN_ACSL_Ascending {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1617C2In.in")));
		for(int i = 0; i < 10; i++) {
			String sequence = br.readLine();
			int startlength = Integer.parseInt(sequence.substring(0, 1));
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			numbers.add(Integer.parseInt(sequence.substring(1, startlength + 1)));
			int previousNumber = numbers.get(0);
			int index = sequence.length() - 1;
			String s = "";
			while(index > startlength) {
				s += String.valueOf(sequence.charAt(index));
				if(Integer.parseInt(s) > previousNumber) {
					previousNumber = Integer.parseInt(s);
					numbers.add(Integer.parseInt(s));
					s = "";
				}
				index--;
			}
			for(int j = 0; j < numbers.size(); j++)
				System.out.print(numbers.get(j) + " ");
			System.out.println();
		}
		br.close();
	}
}