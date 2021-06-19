package ACSL04_05;
import java.util.*;
import java.io.*;
public class C1IN_ACSLPoker {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0405C1In.in"));
		for(int i = 0; i < 9; i++) {
			int[] original = new int[5];
			int[] simple = new int[5];
			int[] dup = new int[5];
			for(int j = 0; j < 5; j++) {
				int a = sc.nextInt();
				original[j] = a;
				simple[j] = a % 13;
			}
			Arrays.sort(original);
			int twos = 0;
			int threes = 0;
			int fours = 0;
			boolean b = false; 
			int a = original.length - 1;
			if((original[0] > 0 && original[a] < 14) || (original[0] > 13 && original[a] < 27) || (original[0] > 26 && original[a] < 40) || (original[0] > 39 && original[a] < 53))
				b = true;
			for(int j = 0; j < 5; j++)
				for(int k = j; k < 5; k++)
					if(simple[j] == simple[k])
						dup[j]++;
			for(int j = 0; j < 4; j++) {
				if(dup[j] == 2)
					twos++;
				else if(dup[j] == 3)
					threes++;
				else if(dup[j] == 4)
					fours++;
			}
			if(b)
				System.out.println("FLUSH");
			else if(fours == 1)
				System.out.println("FOUR OF A KIND");
			else if(twos == 2 && threes == 1)
				System.out.println("FULL HOUSE");
			else if(threes == 1 && twos == 1)
				System.out.println("THREE OF A KIND");
			else if(twos > 1)
				System.out.println("TWO PAIRS");
			else if(twos == 1)
				System.out.println("PAIR");
			else
				System.out.println("NONE");
		}
		sc.close();
	}
}