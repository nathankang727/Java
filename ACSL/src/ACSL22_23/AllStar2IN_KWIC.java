package ACSL22_23;
import java.util.*;
public class AllStar2IN_KWIC {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String original = sc.nextLine();
		String unused = sc.nextLine();
		String rows = sc.nextLine();
		System.out.println(findARow(original, unused, rows));
		sc.close();
	}
	public static String findARow(String original, String unused, String rows) {
		String[] rowNums = rows.split(" ");
		String[] unusedSplit = unused.split(" ");
		ArrayList<String> unused2 = new ArrayList<String>();
		for(int i = 0 ; i < unusedSplit.length; i++)
			unused2.add(unusedSplit[i]);
		int start = Integer.parseInt(rowNums[0]) - 1;
		int end = Integer.parseInt(rowNums[1]) - 1;
		String[] splitted = original.split(" ");
		ArrayList<Table> list = new ArrayList<Table>();
		int longestBefore = 0;
		int longestWord = 0;
		int longestAfter = 0;
		for(int i = 0; i < splitted.length; i++) {
			String word = splitted[i];
			if(word.charAt(word.length() - 1) == '.' || word.charAt(word.length() - 1) == '?' ||
					word.charAt(word.length() - 1) == '!' || word.charAt(word.length() - 1) == ',' ||
					word.charAt(word.length() - 1) == ';' || word.charAt(word.length() - 1) == ':') {
				word = word.substring(0, word.length() - 1);
			}
			if(unused2.contains(word.toLowerCase()))
				continue;
			String before = "";
			for(int j = i - 1; j >= i - 3; j--) {
				if(j < 0)
					break;
				if(splitted[j].charAt(splitted[j].length() - 1) == '.' || splitted[j].charAt(splitted[j].length() - 1) == '?' ||
						splitted[j].charAt(splitted[j].length() - 1) == '!' || splitted[j].charAt(splitted[j].length() - 1) == ',' ||
						splitted[j].charAt(splitted[j].length() - 1) == ';' || splitted[j].charAt(splitted[j].length() - 1) == ':') {
					break;
				}
				if(unused2.contains(splitted[j].toLowerCase()))
					break;
				before = splitted[j] + " " + before;
			}
			if(before.length() != 0)
				before = before.substring(0, before.length() - 1);
			String after = "";
			for(int j = i + 1; j <= i + 3; j++) {
				if(j - 1 < splitted.length && (splitted[j - 1].charAt(splitted[j - 1].length() - 1) == '.' ||
						splitted[j - 1].charAt(splitted[j - 1].length() - 1) == '?' ||
						splitted[j - 1].charAt(splitted[j - 1].length() - 1) == '!' ||
						splitted[j - 1].charAt(splitted[j - 1].length() - 1) == ',' ||
						splitted[j - 1].charAt(splitted[j - 1].length() - 1) == ';' ||
						splitted[j - 1].charAt(splitted[j - 1].length() - 1) == ':')) {
					break;
				}
				if(j >= splitted.length)
					break;
				String word2 = splitted[j];
				if(word2.charAt(word2.length() - 1) == '.' || word2.charAt(word2.length() - 1) == '?' || 
						word2.charAt(word2.length() - 1) == ',' || word2.charAt(word2.length() - 1) == '!' || 
						word2.charAt(word2.length() - 1) == ':' || word2.charAt(word2.length() - 1) == ';') {
					word2 = word2.substring(0, word2.length() - 1);
				}
				if(unused2.contains(word2.toLowerCase()))
					break;
				after += word2 + " ";
			}
			if(after.length() != 0)
				after = after.substring(0, after.length() - 1);
			int index = 0;
			for(int j = list.size() - 1; j >= 0; j--) {
				if(list.get(j).w.toLowerCase().equals(word.toLowerCase())) {
					index = 1 + list.get(j).i;
					break;
				}
			}
			list.add(new Table(before, word, after, index));
			Collections.sort(list);
		}
		for(int i = 0; i < list.size(); i++) {
			int b = list.get(i).b.length();
			int w = list.get(i).w.length();
			int a = list.get(i).a.length();
			longestBefore = Math.max(b, longestBefore);
			longestWord = Math.max(w, longestWord);
			longestAfter = Math.max(a, longestAfter);
		}
		for(int i = 0; i < list.size(); i++) {
			Table t = list.get(i);
			String b = t.b;
			String w = t.w;
			String a = t.a;
			for(int j = 0; j < longestBefore - t.b.length(); j++)
				b = "-" + b;
			for(int j = 0; j < longestWord - t.w.length(); j++)
				w += "-";
			for(int j = 0; j < longestAfter - t.a.length(); j++)
				a += "-";
			w = "<" + w + ">";
			list.set(i, new Table(b, w, a, t.i));
		}
		int dashCount = Integer.MAX_VALUE;
		int indexRow = -1;
		for(int i = start; i <= end; i++) {
			Table t = list.get(i);
			int dash = 0;
			for(int j = 0; j < t.b.length(); j++)
				if(t.b.charAt(j) == '-')
					++dash;
			for(int j = 0; j < t.w.length(); j++)
				if(t.w.charAt(j) == '-')
					++dash;
			for(int j = 0; j < t.a.length(); j++)
				if(t.a.charAt(j) == '-')
					++dash;
			if(dash < dashCount) {
				dashCount = dash;
				indexRow = i;
			}
		}
		Table t = list.get(indexRow);
		return t.b + " " + t.w + " " + t.a;
    }
	static class Table implements Comparable<Table> {
		public String b;
		public String w;
		public String a;
		public int i;
		public int compareTo(Table t) {
			if(this.w.toLowerCase().equals(t.w.toLowerCase()))
				return this.i - t.i;
			return this.w.toLowerCase().compareTo(t.w.toLowerCase());
		}
		public Table(String before, String word, String after, int index) {
			b = before;
			w = word;
			a = after;
			i = index;
		}
	}
}