import java.util.*;
public class CafeProject {
	public static void main(String[] args) {
		Map<String, Double> menu = new TreeMap<String, Double>();
		/*
		WATER - $0.01
		WATER BUT IT'S IN A BOTTLE - $1.00
		WATER BUT IT'S YELLOW - $.5
		WATER BUT IT'S YELLOW AND IN A BOTTLE - $1.50
		WATER BUT IT'S BROWN - $2.00 
		*/
		menu.put("CLEAR WATER", 0.00);
		menu.put("CLEAR WATER BUT IT'S IN A BOTTLE", 1.00);
		menu.put("WATER BUT IT'S YELLOW", 0.50);
		menu.put("WATER BUT IT'S YELLOW AND IN A BOTTLE", 1.50);
		menu.put("WATER BUT IT'S BROWN", 2.00);
		menu.put("WATER BUT IT'S BROWN AND IN A BOTTLE", 3.00);
		//print all items
		for(String s: menu.keySet())
			System.out.println(s + ": $" + menu.get(s) + "0");
		System.out.println("-------------------------------------------");
		//print items which are over $1.50
		for(String s: menu.keySet())
			if(menu.get(s) > 1.50)
				System.out.println(s + ": $" + menu.get(s) + "0");
		System.out.println("-------------------------------------------");
		//print total price of all items
		double totalPrice = 0;
		for(String s: menu.keySet())
			totalPrice += menu.get(s);
		System.out.println("TOTAL PRICE: $" + totalPrice + "0");
		System.out.println("-------------------------------------------");
		//add price $1.00 on all items
		for(String s: menu.keySet()) {
			menu.put(s, menu.get(s) + 1);
			System.out.println(s + ": $" + menu.get(s) + "0");
		}
	}
}