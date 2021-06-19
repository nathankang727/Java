import java.util.*;
import java.io.*;
public class prob20 {
	static int[] toppings;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		toppings = new int[8];
		while(sc.hasNextLine()) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			int n = Integer.parseInt(st.nextToken());
			while(st.hasMoreTokens()) {
				String input = st.nextToken();
				if(input.equals("1/4")) {
					String pizza = st.nextToken();
					calculate(pizza, n);
				}
				else if(input.equals("1/2")) {
					String pizza = st.nextToken();
					calculate(pizza, 2 * n);
				}
				else
					calculate(input, 4 * n);
			}
		}
		System.out.println("Pepperoni: " + toppings[0]);
		System.out.println("Red Peppers: " + toppings[1]);
		System.out.println("Pineapple: " + toppings[2]);
		System.out.println("Olives: " + toppings[3]);
		System.out.println("Sardines: " + toppings[4]);
		System.out.println("Onion: " + toppings[5]);
		System.out.println("Sausage: " + toppings[6]);
		System.out.println("Ham: " + toppings[7]);		
		sc.close();
	}
	public static void calculate(String s, int n) {
		if(s.equals("Pepperoni"))
			toppings[0] += 8 * n;
		else if(s.equals("Red Peppers"))
			toppings[1] += 4 * n;
		else if(s.equals("Pineapple"))
			toppings[2] += 21 * n;
		else if(s.equals("Olives"))
			toppings[3] += 5 * n;
		else if(s.equals("Sardines"))
			toppings[4] += 3 * n;
		else if(s.equals("Onion"))
			toppings[5] += 7 * n;
		else if(s.equals("Sausage"))
			toppings[6] += 10 * n;
		else if(s.equals("Ham"))
			toppings[7] += 9 * n;
		else if(s.equals("Hawaiian")) {
			toppings[2] += 21 * n;
			toppings[7] += 9 * n;
		}
		else if(s.equals("Combo")) {
			toppings[1] += 4 * n;
			toppings[3] += 5 * n;
			toppings[5] += 7 * n;
			toppings[6] += 10 * n;
		}
		else if(s.equals("Fishaster")) {
			toppings[4] += 3 * n;
			toppings[5] += 7 * n;
		}
		else if(s.equals("Meat-Lovers")) {
			toppings[0] += 8 * n;
			toppings[6] += 10 * n;
			toppings[7] += 9 * n;
		}
	}
}