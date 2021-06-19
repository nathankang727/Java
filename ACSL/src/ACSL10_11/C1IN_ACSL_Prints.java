package ACSL10_11;
import java.util.*;
import java.io.*;
public class C1IN_ACSL_Prints {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1011C1In.in"));
		for(int i = 0; i < 8; i++) {
			int sum1 = 1;
			int sum2 = 1;
			String system = sc.next();
			ArrayList<Integer> finger = new ArrayList<Integer>();
			while(sc.hasNextInt())
				finger.add(sc.nextInt());
			finger.remove(finger.size() - 1);
			if(system.equals("H")) {
				for(int j = 0; j < finger.size(); j++) {
					if(finger.get(j) % 2 == 0)
						sum1 += convert(finger.get(j));
					else
						sum2 += convert(finger.get(j));
				}
			}
			else {
				for(int j = 0; j < finger.size(); j++) {
					if(finger.get(j) >= 1 && finger.get(j) <= 5)
						sum1 += convert2(finger.get(j));
					else
						sum2 += convert2(finger.get(j));
				}
			}
			System.out.println(sum1 + " / " + sum2);
		}
		sc.close();
	}
	public static int convert(int n) {
		if(n == 1 || n == 2)
			return 16;
		else if(n == 3 || n == 4)
			return 8;
		else if(n == 5 || n == 6)
			return 4;
		else if(n == 7 || n == 8)
			return 2;
		else
			return 1;
	}
	public static int convert2(int n) {
		if(n == 1 || n == 6)
			return 16;
		else if(n == 2 || n == 7)
			return 8;
		else if(n == 3 || n == 8)
			return 4;
		else if(n == 4 || n == 9)
			return 2;
		else
			return 1;
	}
}