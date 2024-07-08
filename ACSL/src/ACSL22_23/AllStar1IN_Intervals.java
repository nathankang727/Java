package ACSL22_23;
import java.util.*;
public class AllStar1IN_Intervals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String intervals1 = sc.nextLine();
		String intervals2 = sc.nextLine();
		String intervals3 = sc.nextLine();
		System.out.println(sumsNotCommon(intervals1, intervals2, intervals3));
		sc.close();
	}
	public static String sumsNotCommon(String intervals1, String intervals2, String intervals3) {
		String[] set1 = intervals1.split(" ");
		HashSet<Integer> num1 = new HashSet<Integer>();
		String[] set2 = intervals2.split(" ");
		HashSet<Integer> num2 = new HashSet<Integer>();
		for(int i = 0; i < set1.length; i++) {
			char front = set1[i].charAt(0);
			char back = set1[i].charAt(set1[i].length() - 1);
			String[] splitted = set1[i].substring(1, set1[i].length() - 1).split(",");
			for(int j = Integer.parseInt(splitted[0]); j <= Integer.parseInt(splitted[1]); j++) {
				if(front == '(' && j == Integer.parseInt(splitted[0]) || back == ')' && j == Integer.parseInt(splitted[1]))
					continue;
				num1.add(j);
			}
		}
		for(int i = 0; i < set2.length; i++) {
			char front = set2[i].charAt(0);
			char back = set2[i].charAt(set2[i].length() - 1);
			String[] splitted = set2[i].substring(1, set2[i].length() - 1).split(",");
			for(int j = Integer.parseInt(splitted[0]); j <= Integer.parseInt(splitted[1]); j++) {
				if(front == '(' && j == Integer.parseInt(splitted[0]) || back == ')' && j == Integer.parseInt(splitted[1]))
					continue;
				num2.add(j);
			}
		}
		ArrayList<Integer> all1 = new ArrayList<Integer>();
		ArrayList<Integer> all2 = new ArrayList<Integer>();
		for(int i : num1)
			all1.add(i);
		for(int i : num2)
			all2.add(i);
		Collections.sort(all1);
		Collections.sort(all2);
		if(intervals3.equals("null")) {
			Set<Integer> res = new HashSet<Integer>();
			for(int i : all1)
				if(!all2.contains(i))
					res.add(i);
			for(int i : all2)
				if(!all1.contains(i))
					res.add(i);
			int sum = 0;
			for(int i : res)
				sum += i;
			return sum + "";
		}
		else {
			String[] set3 = intervals3.split(" ");
			HashSet<Integer> num3 = new HashSet<Integer>();
			for(int i = 0; i < set3.length; i++) {
				char front = set3[i].charAt(0);
				char back = set3[i].charAt(set3[i].length() - 1);
				String[] splitted = set3[i].substring(1, set3[i].length() - 1).split(",");
				for(int j = Integer.parseInt(splitted[0]); j <= Integer.parseInt(splitted[1]); j++) {
					if(front == '(' && j == Integer.parseInt(splitted[0]) || back == ')' && j == Integer.parseInt(splitted[1]))
						continue;
					num3.add(j);
				}
			}
			ArrayList<Integer> all3 = new ArrayList<Integer>();
			for(int i : num3)
				all3.add(i);
			Collections.sort(all3);
			Set<Integer> res1 = new HashSet<Integer>();
			for(int i : all1)
				if(!all2.contains(i) && !all3.contains(i))
					res1.add(i);
			for(int i : all2)
				if(!all1.contains(i) && !all3.contains(i))
					res1.add(i);
			for(int i : all3)
				if(!all1.contains(i) && !all2.contains(i))
					res1.add(i);
			int sum1 = 0;
			for(int i : res1)
				sum1 += i;
			Set<Integer> res2 = new HashSet<Integer>();
			int sum2 = 0;
			for(int i : all1)
				if((!all2.contains(i) || !all3.contains(i)) && (all2.contains(i) || all3.contains(i)))
					res2.add(i);
			for(int i : all2)
				if((!all1.contains(i) || !all3.contains(i)) && (all1.contains(i) || all3.contains(i)))
					res2.add(i);
			for(int i : all3)
				if((!all2.contains(i) || !all1.contains(i)) && (all2.contains(i) || all1.contains(i)))
					res2.add(i);
			for(int i : res2)
				sum2 += i;
			return sum1 + " " + sum2;
		}
	}
}