import java.util.*;
import java.io.*;
public class prob28 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		while(sc.hasNextLine()) {
			ArrayList<Long> list = new ArrayList<Long>();
			String input = sc.nextLine();
			StringTokenizer st = new StringTokenizer(input);
			while(st.hasMoreTokens())
				list.add(Long.parseLong(st.nextToken()));
			boolean isBreak = false;
			for(int i = 0; i < list.size() - 1; i++) {
				if(list.get(i + 1) != Math.pow(list.get(i), 2)) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak) {
				System.out.println("X^2");
				continue;
			}
			isBreak = false;
			for(int i = 0; i < list.size() - 1; i++) {
				if(list.get(i + 1) != Math.pow(list.get(i), 3)) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak) {
				System.out.println("X^3");
				continue;
			}
			isBreak = false;
			for(int i = 2; i < list.size(); i++) {
				if(list.get(i) != list.get(i - 1) + list.get(i - 2)) {
					isBreak = true;
					break;
				}
			}
			if(!isBreak) {
				System.out.println("Fibonacci");
				continue;
			}
			isBreak = false;
			boolean isBreak2 = false;
			ArrayList<Long> list2 = new ArrayList<Long>();
			for(int i = 0; i < list.size(); i++)
				list2.add(list.get(i));
			Collections.sort(list2);
			long ratio = list2.get(1) / list2.get(0);
			long first = list2.get(0) == 1 ? list2.get(1) : list2.get(0);
			for(int i = 1; i < list.size() - 1; i++) {
				if(list.get(i) % first != 0) {
					isBreak = true;
					break;
				}
				if(list2.get(i) * ratio != list2.get(i + 1) && list2.get(i) / ratio != list2.get(i + 1)) {
					isBreak2 = true;
					break;
				}
			}
			if(!isBreak && !isBreak2)
				System.out.println("Geometric");
			else if(!isBreak && isBreak2)
				System.out.println("Geometric (With Gaps)");
			else
				System.out.println(input + " is an Unknown series");
		}
		sc.close();
	}
}