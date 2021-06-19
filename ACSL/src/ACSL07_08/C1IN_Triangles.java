package ACSL07_08;
import java.util.*;
import java.io.*;
public class C1IN_Triangles {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0708C1In.in"));
		for(int i = 0; i < 10; i++) {
			double[] triangle = new double[3];
			double[] triangle2 = new double[3];
			for(int j = 0; j < 3; j++)
				triangle[j] = sc.nextDouble();
			for(int j = 0; j < 3; j++)
				triangle2[j] = sc.nextDouble();
			double sum = triangle[0] + triangle[1] + triangle[2];
			double sum2 = triangle2[0] + triangle2[1] + triangle2[2];
			if(sum != sum2)
				System.out.println("NONE");
			else if(triangle[0] == triangle2[0] && triangle[1] == triangle2[1] && triangle[2] == triangle2[2])
				System.out.println("DEF");
			else if(triangle[0] == triangle2[2] && triangle[1] == triangle2[1] && triangle[2] == triangle2[0])
				System.out.println("DFE");
			else if(triangle[0] == triangle2[1] && triangle[1] == triangle2[0] && triangle[2] == triangle2[2])
				System.out.println("FED");
			else if(triangle[0] == triangle2[2] && triangle[1] == triangle2[0] && triangle[2] == triangle2[1])
				System.out.println("FDE");
			else if(triangle[0] == triangle2[0] && triangle[1] == triangle2[2] && triangle[2] == triangle2[1])
				System.out.println("EDF");
			else
				System.out.println("EFD");
		}
		sc.close();
	}
}