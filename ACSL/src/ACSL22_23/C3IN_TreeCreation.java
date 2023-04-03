package ACSL22_23;
import java.util.*;
import java.io.*;
public class C3IN_TreeCreation {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println(onlyLeftOrRight(br.readLine()));
		br.close();
	}
	public static String onlyLeftOrRight(String input) {
        ArrayList<Character> letters = new ArrayList<Character>();
        ArrayList<Integer> values = new ArrayList<Integer>();
        for(int i = 0; i < input.length(); i++) {
            if(i == 0) {
                letters.add(input.charAt(i));
                values.add(0);
            }
            else {
                for(int j = 0; j < letters.size(); j++) {
                	int max = 0;
                	if(j == 0 && letters.get(j) >= input.charAt(i)) {
                		max = values.get(j) + 1;
                		letters.add(j, input.charAt(i));
                		values.add(j, max);
                		break;
                	}
                	if(letters.get(j) >= input.charAt(i)) {
                		max = Math.max(values.get(j) + 1, values.get(j - 1) + 1);
                		letters.add(j, input.charAt(i));
                		values.add(j, max);
                		break;
                	}
                    if(j == letters.size() - 1 && letters.get(j) < input.charAt(i)) {
                    	max = values.get(j) + 1;
                    	letters.add(input.charAt(i));
                    	values.add(max);
                    	break;
                    }
                }
            }
        }
    	String s1 = "";
    	String s2 = "";
        for(int i = 0; i < input.length(); i++) {
        	boolean left = false;
        	boolean right = false;
        	for(int j = i - 1; j >= 0; j--) {
        		if(values.get(j) == values.get(i) + 1) {
        			left = true;
        			break;
        		}
        		if(values.get(j) < values.get(i))
        			break;
        	}
        	for(int j = i + 1; j < input.length(); j++) {
        		if(values.get(j) == values.get(i) + 1) {
        			right = true;
        			break;
        		}
        		if(values.get(j) < values.get(i))
        			break;
        	}
        	if(left == right)
        		continue;
        	else if(left)
        		s1 += letters.get(i);
        	else
        		s2 += letters.get(i);
        }
        if(s1.length() == 0)
        	s1 = "NONE";
        if(s2.length() == 0)
        	s2 = "NONE";
        return s1 + " " + s2;
    }
}