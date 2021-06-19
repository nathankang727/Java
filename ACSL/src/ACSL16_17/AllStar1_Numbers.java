package ACSL16_17;
import java.util.*;
import java.io.*;
public class AllStar1_Numbers {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1617AllStar1.in")));
		for(int i = 0; i < 2; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long n = Long.parseLong(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String[] digits = String.valueOf(n).split("");
			Arrays.sort(digits);
			int[] digitsCount = new int[10];
			for(int j = 0; j < digits.length; j++)
				++digitsCount[Integer.parseInt(digits[j])];
			String ans1 = "";
			String ans2 = "";
			for(int j = 0; j < digits.length; j++) {
				ans1 += digits[j];
				ans2 = digits[j] + ans2;
			}
			System.out.println(Long.parseLong(ans1) + "\n" + Long.parseLong(ans2));
			long ans3 = 0;
			int countLargest = 0;
			long largest = Long.parseLong(ans2);
			long ans4 = 0;
			int countSmallest = 0;
			long smallest = Long.parseLong(ans1);
			while(countLargest < 50) {
				if(sameDigits(largest, digitsCount, digits.length)) {
					++countLargest;
					ans3 = largest;
				}
				--largest;
			}
			while(countSmallest < k) {
				if(sameDigits(smallest, digitsCount, digits.length)) {
					++countSmallest;
					ans4 = smallest;
				}
				++smallest;
			}
			System.out.println(ans3 + "\n" + ans4);
			long average = (ans3 + ans4) / 2;
			long upBound = average + 1;
			long downBound = average - 1;
			while(!sameDigits(upBound, digitsCount, digits.length))
				++upBound;
			while(!sameDigits(downBound, digitsCount, digits.length))
				--downBound;
			long ans5 = Math.abs(average - upBound) <= Math.abs(average - downBound) ? upBound : downBound;
			System.out.println(ans5);
		}
		br.close();
	}
	public static boolean sameDigits(long n, int[] digitsCount2, int len) {
		String nString = String.valueOf(n);
		int[] digitsCount1 = new int[10];
		for(int i = 0; i < nString.length(); i++)
			++digitsCount1[Integer.parseInt(nString.substring(i, i + 1))];
		for(int i = 0; i < len - nString.length(); i++)
			++digitsCount1[0];
		return Arrays.equals(digitsCount1, digitsCount2);
	}
}