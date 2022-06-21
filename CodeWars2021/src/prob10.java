import java.util.*;
import java.io.*;
public class prob10 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		String input = sc.next();
		ArrayList<String> villagers = new ArrayList<String>();
		while(!input.equals("END")) {
			String name = input;
			name = name.substring(name.length() - 2);
			String timeString = sc.next();
			int time = Integer.parseInt(timeString.substring(0, 2)) * 60 + Integer.parseInt(timeString.substring(3));
			time += Integer.parseInt(sc.next()) * 10;
			if(time < 1020)
				villagers.add(name);
			input = sc.next();
		}
		if(villagers.isEmpty())
			System.out.println("Blah, blah, blah, time to order delivery");
		else {
			if(villagers.size() == 1)
				System.out.println("Villagers (" + villagers.get(0) + ") look tasty");
			else {
				System.out.print("Villagers (" + villagers.get(0));
				for(int i = 1; i < villagers.size(); i++)
					System.out.print(", " + villagers.get(i));
				System.out.print(") look tasty");
			}
		}
		sc.close();
	}
}