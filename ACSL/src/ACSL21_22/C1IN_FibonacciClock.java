package ACSL21_22;
import java.io.*;
public class C1IN_FibonacciClock {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] input = new char[5];
		for(int i = 0; i < 5; i++)
			input[i] = br.readLine().charAt(0);
		System.out.println(findTime(input[0], input[1], input[2], input[3], input[4]));
		br.close();
	}
	public static String findTime(char c1, char c2, char c3, char c4, char c5) {
		char[] c = {c1, c2, c3, c4, c5};
		int[] fibonacci = {1, 1, 2, 3, 5};
		int hours = 0;
		for(int i = 0; i < 5; i++)
			if(c[i] == 'R' || c[i] == 'B')
				hours += fibonacci[i];
		int minutes = 0;
		for(int i = 0; i < 5; i++)
			if(c[i] == 'G' || c[i] == 'B')
				minutes += fibonacci[i];
		minutes *= 5;
		if(minutes == 60)
			++hours;
		minutes %= 60;
		hours %= 12;
		String hourPortion = hours < 10 ? "0" + hours : hours + "";
		String minutePortion = minutes < 10 ? "0" + minutes : minutes + "";
		return hourPortion + ":" + minutePortion;
	}
}