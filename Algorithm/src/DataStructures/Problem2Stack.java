package DataStructures;
import java.util.*;
public class Problem2Stack {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Stack<String> s = new Stack<String>();
		int len = Integer.parseInt(in.nextLine());
		String[] a = new String[len];
		for(int i = 0; i < len; i++)
			a[i] = in.nextLine();
		for(int i = 0; i < len; i++) {
			int zz = 0;
			for(int j = 0; j < a[i].length(); j++) {
				if(a[i].length() == 0)
					break;
				else if(a[i].substring(j, j + 1).equals("("))
					s.push("(");
				else if(a[i].substring(j, j + 1).equals(")")){
					if(s.size() == 0) {
						zz = 3;
						break;
					}
					else
						s.pop();
				}
			}
			s.clear();
			if(s.size() == 0 && zz == 0)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		in.close();
	}
}