import java.util.*;
import java.io.*;
public class prob27 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		String key = br.readLine();
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < key.length(); i++)
			list.add(key.charAt(i));
		for(int i = list.size() - 1; i >= 0; i--) {
			if(list.get(i) == '!') {
				list.set(i + 1, list.get(i + 1) == 'T' ? 'F' : 'T');
				list.remove(i);
			}
		}
		int end = -1;
		for(int i = list.size() - 1; i >= 0; i--) {
			if(list.get(i) == ')')
				end = i;
			else if(list.get(i) == '(') {
				ArrayList<Character> expression = new ArrayList<Character>();
				for(int j = end; j >= i; j--)
					expression.add(0, list.remove(j));
				for(int j = expression.size() - 3; j >= 0; j--) {
					if(expression.get(j + 1) == '&') {
						char a = expression.remove(j + 2);
						expression.remove(j + 1);
						char b = expression.remove(j);
						expression.add(j, a == 'F' || b == 'F' ? 'F' : 'T');
					}
				}
				for(int j = expression.size() - 3; j >= 0; j--) {
					if(expression.get(j + 1) == '|') {
						char a = expression.remove(j + 2);
						expression.remove(j + 1);
						char b = expression.remove(j);
						expression.add(j, a == 'T' || b == 'T' ? 'T' : 'F');
					}
				}
				list.add(i, expression.get(1));
			}
		}
		for(int j = list.size() - 3; j >= 0; j--) {
			if(list.get(j + 1) == '&') {
				char a = list.remove(j + 2);
				list.remove(j + 1);
				char b = list.remove(j);
				list.add(j, a == 'F' || b == 'F' ? 'F' : 'T');
			}
		}
		for(int j = list.size() - 3; j >= 0; j--) {
			if(list.get(j + 1) == '|') {
				char a = list.remove(j + 2);
				list.remove(j + 1);
				char b = list.remove(j);
				list.add(j, a == 'T' || b == 'T' ? 'T' : 'F');
			}
		}
		if(list.get(0) == 'F')
			System.out.println("I am disinclined to acquiesce to your request");
		else {
			for(int i = 0; i < key.length(); i++) {
				if(key.charAt(i) == '!')
					System.out.println("1 N");
				else if(key.charAt(i) == '&')
					System.out.println("2 W");
				else if(key.charAt(i) == '|')
					System.out.println("3 S");
				else if(key.charAt(i) == 'T')
					System.out.println("4 E");
				else if(key.charAt(i) == 'F')
					System.out.println("JUMP");
			}
		}
		br.close();
	}
}