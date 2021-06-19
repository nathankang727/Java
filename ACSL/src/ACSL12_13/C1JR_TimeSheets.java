/*
Start Time: 7:56
End Time: 816
*/
package ACSL12_13;
import java.util.*;
import java.io.*;
public class C1JR_TimeSheets {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1213C1Jr.in"));
		for(int i = 0; i < 2; i++) {
			int[] locations = new int[4];
			int[] startTime = new int[4];
			int[] endTime = new int[4];
			int sum = 0;
			for(int j = 0; j < 4; j++) {
				locations[j] = sc.nextInt();
				startTime[j] = sc.nextInt();
				String a = sc.next();
				if(a.equals("A"))
					a = "10";
				else if(a.equals("B"))
					a = "11";
				else if(a.equals("C"))
					a = "12";
				else if(a.equals("D"))
					a = "13";
				else if(a.equals("E"))
					a = "14";
				else if(a.equals("F"))
					a = "15";
				else if(a.equals("G"))
					a = "16";
				else if(a.equals("H"))
					a = "17";
				endTime[j] = Integer.parseInt(a);
			}
			for(int j = 0; j < 4; j++) {
				int money = 0;
				if(locations[j] <= 9)
					for(int k = 0; k < endTime[j] - startTime[j]; k++)
						money += 5;
				else if(locations[j] >= 10 && locations[j] <= 19) {
					for(int k = 0; k < endTime[j] - startTime[j]; k++) {
						if(k >= 8)
							money += 6;
						else
							money += 4;
					}
				}
				else {
					for(int k = 0; k < endTime[j] - startTime[j]; k++) {
						if(k >= 8)
							money += 12;
						else
							money += 6;
					}
				}
				sum += money;
				System.out.println("$" + money + ".00");
			}
			System.out.println("$" + sum + ".00");
		}
		sc.close();
	}
}