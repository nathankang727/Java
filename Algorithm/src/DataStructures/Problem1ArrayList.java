package DataStructures;
import java.util.*;
public class Problem1ArrayList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();in.nextLine();
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for(int i = 0; i < len; i++)
			numbers.add(Integer.parseInt(in.nextLine()));
		Collections.sort(numbers);
		for(int i = 0 ; i < numbers.size(); i++)
			System.out.println(numbers.get(i));
		in.close();
	}
}