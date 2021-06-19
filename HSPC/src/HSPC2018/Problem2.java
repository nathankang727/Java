package HSPC2018;
import java.util.*;
import java.io.*;
public class Problem2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		for(int i = 0; i < n; i++)
			nums[i] = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		int[] answer = new int[n - s + 1];
		for(int i = 0; i <= n - s; i++) {
			int min = nums[i];
			for(int j = i + 1; j < i + s; j++) {
				if(min > nums[j]) {
					min = nums[j];
				}
			}
			answer[i] = min;
		}
		System.out.println(Arrays.toString(answer));
	}
}