/*
Start Time: 11:05
End Time: 
*/
package ACSL05_06;
import java.util.*;
import java.io.*;
public class C1JR_ACSL_PostOffice {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0506C1Jr.in"));
		for(int i = 0; i < 10; i++) {
			double length = sc.nextDouble();
			double width = sc.nextDouble();
			double thickness = sc.nextDouble();
			if(length >= 3.5 && length <= 4.25 && width >= 3.5 && width <= 6 && thickness >= .007 && thickness <= .016)
				System.out.println("regular post card");
			else if(length >= 4.25 && length <= 6 && width >= 6 && width <= 11.5 && thickness >= .007 && thickness <= .016)
				System.out.println("large post card");
			else if(length >= 3.5 && length <= 6.125 && width >= 5 && width <= 11.5 && thickness >= .016 && thickness <= .25)
				System.out.println("envelope");
			else if(length >= 6.125 && length <= 24 && width >= 11 && width <= 18 && thickness >= .25 && thickness <= .5)
				System.out.println("large envelope");
			else if((length + width + thickness) * 2 <= 84 && (length > 24 || width > 18 || thickness > .5))
				System.out.println("package");
			else if((length + width + thickness) * 2 > 84 && (length + width + thickness) * 2 < 130)
				System.out.println("large package");
			else 
				System.out.println("unmailable");
 		}
		sc.close();
	}
}