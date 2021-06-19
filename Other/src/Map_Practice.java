import java.util.*;
public class Map_Practice {
	public static void main(String[] args) {
		String s = "121131781356";
		Map<Character, Integer> m = new HashMap<Character, Integer>();
		m.put('0', 0);
		m.put('1', 0);
		m.put('2', 0);
		m.put('3', 0);
		m.put('4', 0);
		m.put('5', 0);
		m.put('6', 0);
		m.put('7', 0);
		m.put('8', 0);
		m.put('9', 0);
		for(int i = 0; i < s.length(); i++)
			m.put(s.charAt(i), m.get(s.charAt(i)) + 1);
		System.out.println("0 : " + m.get('0'));
		System.out.println("1 : " + m.get('1'));
		System.out.println("2 : " + m.get('2'));
		System.out.println("3 : " + m.get('3'));
		System.out.println("4 : " + m.get('4'));
		System.out.println("5 : " + m.get('5'));
		System.out.println("6 : " + m.get('6'));
		System.out.println("7 : " + m.get('7'));
		System.out.println("8 : " + m.get('8'));
		System.out.println("9 : " + m.get('9'));
		int unique = 0;
		for(int i = 0; i <= 9; i++)
			if(m.get(String.valueOf(i).charAt(0)) != 0)
				unique++;
		System.out.println(unique);
	}
}