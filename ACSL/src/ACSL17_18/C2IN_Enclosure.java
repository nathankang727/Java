package ACSL17_18;
import java.util.*;
import java.io.*;
public class C2IN_Enclosure {
	public static void main(String[] args) throws IOException{
		Scanner in = new Scanner(new File("1718C2In.in"));
		for(int i = 0; i < 5; i++) {
			String equation = in.next();
			int index = equation.indexOf("(") + 1;
			int index2 = equation.indexOf(")") + 1;
			int index3 = equation.indexOf("[") + 1;
			if(index == 0) {
				for(int j = index2 - 3; j > index3; j = j - 2) {
					char a = equation.charAt(j - 2);
					System.out.println(j + " " + a);
					if(a != '+' || a != '-' || a != '*' || a != '/')
						j = j - 1;
				}
			}
			System.out.println();
		}
		in.close();
	}
}