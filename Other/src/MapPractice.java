import java.util.*;
public class MapPractice {
	public static void main(String[] args) {
		Map<String, Integer> m = new HashMap<String, Integer>();
		m.put("A", 1);
		m.put("B", 2);
		System.out.println(m.get("A"));
		System.out.println(m.get("B"));
		for(String k: m.keySet())
			System.out.println(k + " = " + m.get(k));
	}
}