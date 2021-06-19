package ACSL03_04;
import java.util.*;
import java.io.*;
public class C3JR_ACSLMAN {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0304C3Jr.in"));
		for(int i = 0; i < 7; i++) {
			String word = sc.next();
			int n = sc.nextInt();
			int missingChars = 0;
			String[] letters = new String[n];
			for(int j = 0; j < n; j++)
				letters[j] = sc.next();
			for(int j = 0; j < n; j++)
				if(!(word.contains(letters[j])))
					missingChars++;
			if(missingChars == 0)
				System.out.println("NONE");
			if(missingChars >= 1)
				System.out.println("  O  ");
			if(missingChars >= 2)
				System.out.print("+");
			if(missingChars >= 3)
				System.out.print("=");
			if(missingChars >= 4)
				System.out.print("[]");
			if(missingChars >= 5)
				System.out.print("=");
			if(missingChars >= 6)
				System.out.println("+");
			if(missingChars >= 7)
				System.out.println("  []");
			if(missingChars >= 8)
				System.out.print("  /");
			if(missingChars >= 9)
				System.out.print("\\");
			if(missingChars == 2 || missingChars == 3 || missingChars == 4 || missingChars == 5 ||
					missingChars == 7 || missingChars >= 9) {
				System.out.println();
			}
			System.out.println();
		}
		sc.close();
	}
}