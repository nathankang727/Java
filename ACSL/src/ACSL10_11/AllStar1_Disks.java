package ACSL10_11;
import java.util.*;
import java.io.*;
public class AllStar1_Disks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1011AllStar1.in"));
		for(int i = 0; i < 7; i++) {
			int disk1 = sc.nextInt();
			int disk2 = sc.nextInt();
			int pre = disk1;
			int sum = disk2;
			int c = 0;
			while((c == 0 && pre == disk1 && sum == disk2) || (pre != disk1 || sum != disk2)) {
				int n = pre;
				pre = sum;
				sum += n;
				sum %= 10;
				c++;
			}
			System.out.println(c + 2);
		}
		sc.close();
	}
}