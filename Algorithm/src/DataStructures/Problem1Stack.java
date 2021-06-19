package DataStructures;
import java.util.*;
public class Problem1Stack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack <Integer> s = new Stack<Integer>();
		int len = Integer.parseInt(in.nextLine());
		String[] arr = new String[len];
		for(int i = 0; i < len; i++) {
			String a = in.nextLine();
			arr[i] = a;
		}
		for(int i = 0; i < len; i++) {
			if(arr[i].equals("top")) {
				if(s.size() == 0)
					System.out.println("-1");
				else
					System.out.println(s.peek());
			}
			else if(arr[i].equals("pop"))
				if(s.size() == 0)
					System.out.println("-1");
				else
					System.out.println(s.pop());
			else if(arr[i].equals("size"))
				System.out.println(s.size());
			else if(arr[i].equals("empty") && s.size() != 0)
				System.out.println("0");
			else if(arr[i].equals("empty") && s.size() == 0)
				System.out.println("1");
			else
				s.push(Integer.parseInt(arr[i].substring(5)));
		}
		in.close();
	}
}