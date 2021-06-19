import java.util.*;
public class yeetus {
	public static void main(String[] args) {
		String str = "111000101010110011010011010100011111001111100101010110100000111011100111010111100";
		ArrayList<Character> list = new ArrayList<Character>();
		for(int i = 0; i < str.length(); i++)
			list.add(str.charAt(i));
		String res = "";
		while(list.size() > 0) {
			if(list.size() > 3 && list.get(0) == '1' && list.get(1) == '0' && list.get(2) == '0' && list.get(3) == '0') {
				res += "bad";
				list.remove(3);
				list.remove(2);
				list.remove(1);
				list.remove(0);
			}
			else if(list.size() > 3 && list.get(0) == '1' && list.get(1) == '0' && list.get(2) == '0' && list.get(3) == '1') {
				res += "fade";
				list.remove(3);
				list.remove(2);
				list.remove(1);
				list.remove(0);
			}
			else if(list.size() > 2 && list.get(0) == '0' && list.get(1) == '1' && list.get(2) == '0') {
				res += "abba";
				list.remove(2);
				list.remove(1);
				list.remove(0);
			}
			else if(list.size() > 2 && list.get(0) == '0' && list.get(1) == '1' && list.get(2) == '1') {
				res += "feed";
				list.remove(2);
				list.remove(1);
				list.remove(0);
			}
			else if(list.size() > 2 && list.get(0) == '1' && list.get(1) == '0' && list.get(2) == '1') {
				res += "face";
				list.remove(2);
				list.remove(1);
				list.remove(0);
			}
			else if(list.size() > 2 && list.get(0) == '1' && list.get(1) == '1' && list.get(2) == '0') {
				res += "ca";
				list.remove(2);
				list.remove(1);
				list.remove(0);
			}
			else if(list.size() > 2 && list.get(0) == '1' && list.get(1) == '1' && list.get(2) == '1') {
				res += "dead";
				list.remove(2);
				list.remove(1);
				list.remove(0);
			}
			else {
				res += "beef";
				list.remove(1);
				list.remove(0);
			}
		}
		System.out.println(res);
	}
}