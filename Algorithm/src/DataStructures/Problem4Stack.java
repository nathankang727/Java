package DataStructures;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Problem4Stack {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<String> s = new Stack<String>();
		Stack<String> b = new Stack<String>();
        String line = br.readLine();
		StringBuilder result = new StringBuilder();
		int count = 0;
		int command = Integer.parseInt(br.readLine());
		for(int i = 0; i < line.length(); i++)
			s.push(line.substring(i, i + 1));
		for(int i = 0; i < command; i++) {
			String c = br.readLine();
			if(c.equals("L") && s.size() != 0) {
				b.push(s.pop());
				count++;
				continue;
			}
			else if(c.equals("D") && b.size() != 0)
				s.push(b.pop());
			else if(c.equals("B") && s.size() != 0)
				s.pop();
			else if(c.substring(0, 1).equals("P")){
				s.push(String.valueOf(c.charAt(2)));
			}
			//System.out.println(s + " " + b);
		}
		if(b.size() != 0) {
			for(int j = 0; j < count; j++) {
				if(b.size() == 0)
					break;
				s.push(b.pop());
			}
		}
		//System.out.println(s);
		while(s.size() != 0)
			result=result.append(s.pop());
		System.out.println(result.reverse().toString());
	}
}