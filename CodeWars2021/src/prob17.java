import java.util.*;
import java.io.*;
import java.text.*;
public class prob17 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		DecimalFormat df = new DecimalFormat("0.00");
		String[] startStr = sc.next().split(":");
		int[] start = new int[3];
		for(int i = 0; i < 3; i++)
			start[i] = Integer.parseInt(startStr[i]);
		String[] callStr = sc.next().split(":");
		int[] call = new int[3];
		for(int i = 0; i < 3; i++)
			call[i] = Integer.parseInt(callStr[i]);
		int elapsedTime = (call[0] * 3600 + call[1] * 60 + call[2]) - (start[0] * 3600 + start[1] * 60 + start[2]) + 40;
		double space = 500 - elapsedTime;
		if(space < 0)
			space = 0;
		System.out.println(df.format(space / 100));
		double schematic = (space - space % 20) / 20;
		for(int i = 0; i < 5; i++) {
			System.out.print("|");
			for(int j = 0; j < schematic; j++)
				System.out.print(" ");
			System.out.println("|");
		}
		System.out.print("|");
		for(int j = 0; j < schematic; j++)
			System.out.print(".");
		System.out.println("|");
		if(space == 20)
			System.out.println("THIS IS SOME RESCUE!");
		else if(space < 20)
			System.out.println("CURSE MY METAL BODY, I WASN'T FAST ENOUGH!");
		else
			System.out.println("THE FORCE WAS WITH YOU");
		sc.close();
	}
}