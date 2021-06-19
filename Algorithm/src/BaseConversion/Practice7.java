package BaseConversion;
import java.util.*;
public class Practice7 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		int[] numbers = new int[num];
		int res = 0;
		for(int i = 0; i < num; i++)
			numbers[i] = in.nextInt();
		for(int i = 0; i < num; i++) {
			if(numbers[i] == 3 || numbers[i] == 5 || numbers[i] == 2 || numbers[i] == 7)
				res++;
			else if(numbers[i] < 2 || numbers[i] % 2 == 0 || numbers[i] % 3 == 0 || numbers[i] % 5 == 0 || numbers[i] % 7 == 0)
				continue;
			else
				res++;
		}
		System.out.println(res);
		in.close();
	}
}