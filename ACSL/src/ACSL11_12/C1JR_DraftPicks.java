/*
Start Time: 12:40
End Time: 1:20
*/
package ACSL11_12;
import java.util.*;
import java.io.*;
public class C1JR_DraftPicks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1112C1Jr.in"));
		for(int i = 0; i < 2; i++) {
			int[] years  = new int[5];
			double[] simpleSalary = new double[5];
			double[] salary = new double[5];
			for(int j = 0; j < 5; j++) {
				years[j] = sc.nextInt();
				simpleSalary[j] = sc.nextDouble();
			}
			for(int j = 0; j < 5; j++) {
				double a = simpleSalary[j] * 1000000;
				salary[j] = (long)a / years[j];
			}
			int count = 0;
			int average = 0;
			for(int j = 0; j < 5; j++) {
				if(salary[j] > 10000000)
					count++;
				average += salary[j];
			}
			average /= 5;
			System.out.println(count);
			System.out.println(average);
			Arrays.sort(salary);
			double lowest = salary[0];
			double highest = salary[4];
			lowest /= 16;
			highest /= 18;
			System.out.println(Math.round(lowest));
			System.out.println(Math.round(highest));
			int average2 = 0;
			int average3 = 0;
			for(int j = 0; j < 5; j++) {
				average2 += (int)Math.round(salary[j] / 16);
				average3 +=(int)Math.round(salary[j] / 18);
			}
			average2 /= 5;
			average3 /= 5;
			System.out.println(Math.abs(average3 - average2));
		}
		sc.close();
	}
}