package BaseConversion;
import java.util.*;
public class Practice8 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		for(int i = a; i <= b; i++) {
			if(i < 2 || ((i % 2 == 0 || i % 3 == 0 || i % 5 == 0 || i % 7 == 0) && (i != 2 && i != 3 && i != 5 && i != 7)))
				continue;
			else
				System.out.println(i);
		}
		in.close();
	}
}