package ACSL04_05;
import java.util.*;
import java.io.*;
public class C2JR_DigitalDeletions {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0405C2Jr.in"));
		for(int i = 0; i < 8; i++) {
			int n = sc.nextInt();
			int count = 1;
			ArrayList<Integer> numbers = new ArrayList<Integer>();
			for(int j = 0; j < n; j++)
				numbers.add(sc.nextInt());
			while(numbers.size() != 0) {
				int index = 0;
				int max = 0;
				boolean a = false;
				for(int j = 0; j < numbers.size(); j++) {
					if(numbers.get(j) == 0) {
						for(int k = 0; k < j; k++)
							numbers.remove(0);
						a = true;
						break;
					}
					else if(numbers.get(j) >= max) {
						index = j;
						max = numbers.get(j);
					}
				}
				if(max % 2 == 0 && !(a))
					numbers.set(index, max - 2);
				else if(max % 2 == 1 && !(a))
					numbers.set(index,  max - 1);
				count++;
			}
			System.out.println(count);
		}
		sc.close();
	}
}