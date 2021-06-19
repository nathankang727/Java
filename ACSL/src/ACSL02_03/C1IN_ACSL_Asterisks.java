package ACSL02_03;
import java.util.*;
import java.io.*;
public class C1IN_ACSL_Asterisks {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0203C1In.in"));
		for(int i = 0; i < 8; i++) {
			char type = sc.next().charAt(0);
			if(type == 'S') {
				int height = sc.nextInt();
				int number = sc.nextInt();
				for(int j = 0; j < height; j++) {
					for(int k = 0; k < number * (height - 1) + 1; k++)
						System.out.print("*");
					System.out.println();
				}
			}
			else if(type == 'B') {
				int length = sc.nextInt();
				int width = sc.nextInt();
				int number = sc.nextInt();
				for(int j = 0; j < width; j++) {
					System.out.print("**");
					for(int k = 0; k < length * (number - 1); k++)
						System.out.print("*");
					System.out.println();
				}
			}
			else if(type == 'T') {
				int height = sc.nextInt();
				int number = sc.nextInt();
				for(int j = 0; j < 2; j++) {
					System.out.print("  ");
					for(int k = 0; k < number - 1; k++)
						System.out.print("***   ");
					System.out.print("***  ");
					System.out.println();
				}
				System.out.print("*");
				for(int j = 0; j < number * height * 2; j++)
					System.out.print("*");
				System.out.println();
				System.out.print("  ");
				for(int j = 0; j < number - 1; j++)
					System.out.print("***   ");
				System.out.print("***  ");
				System.out.println();
				System.out.print("*");
				for(int j = 0; j < number * height * 2; j++)
					System.out.print("*");
				System.out.println();
				for(int j = 0; j < 2; j++) {
					System.out.print("  ");
					for(int k = 0; k < number - 1; k++)
						System.out.print("***   ");
					System.out.print("***  ");
					System.out.println();
				}
			}
			else if(type == 'H') {
				int height = sc.nextInt();
				int number = sc.nextInt();
				int t1 = 1;
				int t2 = 0;
				System.out.print("*");
				for(int j = 0; j < number * (height - 1); j++)
					System.out.print("*");
				System.out.println();
				for(int j = 1; j < height; j++) {
					for(int k = 0; k < t1; k++)
						System.out.print(" ");
					for(int k = 0; k < height - j; k++)
						System.out.print("*");
					for(int k = 0; k < number - 1; k++) {
						for(int l = 0; l < t2; l++)
							System.out.print(" ");
						for(int l = 0; l < height - j; l++)
							System.out.print("*");
					}
					System.out.println();
					t1++;
					t2++;
				}
			}
			else {
				sc.nextInt();
				sc.nextInt();
			}
			System.out.println();
		}
		sc.close();
	}
}