package DataStructures;
import java.util.*;
public class Problem3Stack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<String> s = new Stack<String>();
		int bars = 0;
		String a = in.nextLine().trim();
		for(int i = 0; i < a.length(); i++) {
			if(a.charAt(i) == '(')
				s.push("1");
			else if(a.charAt(i - 1) == '(' && a.charAt(i) == ')') {
				s.pop();
				bars += s.size();
			}
			else if(a.charAt(i - 1) != '(' && a.charAt(i) == ')') {
				s.pop();
				bars++;
			}
		}
		System.out.println(bars);
		in.close();
	}
}