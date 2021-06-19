package ACSL09_10;
import java.util.*;
import java.io.*;
public class C4JR_ACSL_StacksAndQueues {
	static ArrayList<Character> c;
	static char type;
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0910C4Jr.in"));
		for(int i = 0; i < 10; i++) {
			type = sc.next().charAt(0);
			c = new ArrayList<Character>();
			c.add('A');
			c.add('B');
			c.add('C');
			c.add('D');
			c.add('E');
			String s = sc.next();
			while(!(s.equals("PRT"))) {
				if(s.equals("POP"))
					pop(sc.nextInt());
				else if(s.equals("PSH"))
					c.add(sc.next().charAt(0));
				else if(s.equals("DUP"))
					dup(sc.nextInt());
				else if(s.equals("SWP"))
					swp(sc.nextInt());
				else {
					swh();
				}
				s = sc.next();
			}
			int n = sc.nextInt();
			if(type == 'S')
				for(int j = c.size() - n; j < c.size(); j++)
					System.out.print(c.get(j) + " ");
			else
				for(int j = 0; j < n; j++)
					System.out.print(c.get(j) + " ");
			System.out.println();
			for(int j = 0; j < c.size(); j++)
				c.remove(0);
			c.add('A');
			c.add('B');
			c.add('C');
			c.add('D');
			c.add('E');
		}
		sc.close();
	}
	static void pop(int x) {
		if(type == 'S')
			for(int i = 0; i < x; i++)
				c.remove(c.size() - 1);
		else
			for(int i = 0; i < x; i++)
				c.remove(0);
	}
	static void dup(int x) {
		String s = "";
		for(int i = 0; i < x; i++)
			s += c.get(i);
		for(int i = 0; i < s.length(); i++)
			c.add(s.charAt(i));
	}
	static void swp(int x) {
		String s1 = "";
		String s2 = "";
		for(int i = 0; i < x; i++) {
			s1 += c.remove(0);
			s2 = c.remove(c.size() - 1) + s2;
		}
		for(int i = 0; i < x; i++) {
			c.add(i, s2.charAt(i));
			c.add(s1.charAt(i));
		}
	}
	static void swh() {
		if(type == 'S')
			type = 'Q';
		else
			type = 'S';
	}
}