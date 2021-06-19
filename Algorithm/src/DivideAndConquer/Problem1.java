package DivideAndConquer;
import java.util.*;
public class Problem1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int mid = 0;
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int left = 0;
		int right = sc.nextInt();
		while(left <= right) {
			mid = (left + right) / 2;
			left++;
			right--;
		}
		System.out.println(a[mid]);
		sc.close();
	}
}