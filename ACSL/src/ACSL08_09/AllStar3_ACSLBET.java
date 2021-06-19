package ACSL08_09;
import java.util.*;
import java.io.*;
public class AllStar3_ACSLBET {
	static String convert = " ABCDEFGHIJKLMNOPQRSTUVWXYZ*/$%#";
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("0809AllStar3.in")));
		for(int i = 0; i < 2; i++) {
			ArrayList<Integer> ogBits = new ArrayList<Integer>();
			ArrayList<Integer> bits = new ArrayList<Integer>();
			String s = br.readLine();
			for(int j = 0; j < s.length(); j++) {
				String binary = Integer.toString(convert.indexOf(s.substring(j, j + 1)), 2);
				System.out.println(binary);
				for(int k = 0; k < binary.length(); k++) {
					ogBits.add(Integer.parseInt(binary.substring(k, k + 1)));
					bits.add(Integer.parseInt(binary.substring(k, k + 1)));
				}
			}
			System.out.println(findAnswer(circ(bits, 2, 'L')));
			System.out.println(findAnswer(shift(bits, 4, 'R')));
			System.out.println(findAnswer(circ(bits, 10, 'R')));
			System.out.println(findAnswer(shift(bits, 8, 'L')));
			System.out.println(findAnswer(circ(shift(bits, 3, 'R'), 5, 'L')));
			System.out.println(findAnswer(shift(circ(bits, 8, 'R'), 5, 'L')));
			System.out.println(findAnswer(binOps(shift(bits, 2, 'R'), circ(bits, 4, 'L'), 'A')));
			System.out.println(findAnswer(binOps(circ(bits, 6, 'R'), circ(bits, 3, 'L'), 'O')));
			System.out.println(findAnswer(binOps(shift(bits, 9, 'L'), circ(bits, 7, 'L'), 'X')));
			System.out.println(findAnswer(binOps(circ(bits, 4, 'R'), binOps(circ(bits, 2, 'L'), shift(bits, 1, 'R'), 'A'), 
					'O')));
		}
		br.close();
	}
	public static ArrayList<Integer> circ(ArrayList<Integer> list1, int num, char c) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = reset(list1);
		for(int i = 0; i < num; i++) {
			if(c == 'L')
				list.add(list.remove(0));
			else
				list.add(0, list.remove(list.size() - 1));
		}
		return list;
	}
	public static ArrayList<Integer> shift(ArrayList<Integer> list1, int num, char c) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list = reset(list1);
		for(int i = 0; i < num; i++) {
			if(c == 'L') {
				list.remove(0);
				list.add(0);
			}
			else {
				list.remove(list.size() - 1);
				list.add(0, 0);
			}
		}
		return list;
	}
	public static ArrayList<Integer> binOps(ArrayList<Integer> list1, ArrayList<Integer> list2, char c) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 0; i < list1.size(); i++) {
			if(c == 'A')
				answer.add(list1.get(i) == 1 && list2.get(i) == 1 ? 1 : 0);
			else if(c == 'O')
				answer.add(list1.get(i) == 1 || list2.get(i) == 1 ? 1 : 0);
			else
				answer.add(list1.get(i) == 1 && list2.get(i) == 0 || list1.get(i) == 0 && list2.get(i) == 1 ? 1 : 0);
		}
		return answer;
	}
	public static String findAnswer(ArrayList<Integer> list) {
		String answer = "";
		int size = list.size();
		for(int i = 0; i < 5 - size % 5; i++)
			list.add(0, 0);
		for(int i = 0; i < list.size(); i += 5) {
			String bits = "" + list.get(i) + list.get(i + 1) + list.get(i + 2) + list.get(i + 3) + list.get(i + 4) + "";
			answer += convert.charAt(Integer.parseInt(bits, 2)) + "";
		}
		return answer.replace(" ", "");
	}
	public static ArrayList<Integer> reset(ArrayList<Integer> list) {
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i = 0; i < list.size(); i++)
			answer.add(list.get(i));
		return answer;
	}
}