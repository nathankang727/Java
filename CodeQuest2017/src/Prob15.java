import java.util.*;
import java.io.*;
public class Prob15 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob15.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	String s = br.readLine();
        	ArrayList<Integer> list = new ArrayList<Integer>();
        	Set<Integer> set = new TreeSet<Integer>();
        	for(int j = 0; j < s.length(); j++) {
        		if(s.charAt(j) != '0') {
        			list.add(Integer.parseInt(s.substring(j, j + 1)));
        			set.add(Integer.parseInt(s.substring(j, j + 1)));
        		}
        	}
        	Collections.sort(list);
        	int[] arr = new int[set.size()];
        	int index2 = 0;
        	for(int j : set)
        		arr[index2++] = j;
        	Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        	int index3 = list.get(0);
        	int cnt2 = 0;
        	for(int j = 0; j < list.size(); j++) {
        		if(index3 == list.get(j))
        			++cnt2;
        		else {
        			map.put(index3, cnt2);
        			index3 = list.get(j);
        			cnt2 = 1;
        		}
        	}
        	map.put(index3, cnt2);
        	int cnt = 0;
        	int index = list.get(0);
        	boolean isBreak = false;
        	for(int j = 0; j < list.size(); j++) {
        		if(index == list.get(j))
        			++cnt;
        		if(cnt == 5) {
        			pw.println(s + " = FIVE OF A KIND");
        			isBreak = true;
        			break;
        		}
        		if(index != list.get(j)) {
        			cnt = 1;
        			index = list.get(j);
        		}
        	}
        	if(isBreak)
        		continue;
        	cnt = 0;
        	index = list.get(0);
        	isBreak = false;
        	for(int j = 0; j < list.size(); j++) {
        		if(index == list.get(j))
        			++cnt;
        		if(cnt == 4) {
        			pw.println(s + " = FOUR OF A KIND");
        			isBreak = true;
        			break;
        		}
        		if(index != list.get(j)) {
        			cnt = 1;
        			index = list.get(j);
        		}
        	}
        	if(isBreak)
        		continue;
        	int countt3 = 0;
        	int countt2 = 0;
        	for(int j : set) {
        		if(map.get(j) >= 3 && countt3 == 0) {
        			++countt3;
        			continue;
        		}
        		if(map.get(j) >= 2)
        			++countt2;
        	}
        	if(countt3 > 0 && countt2 > 0) {
        		pw.println(s + " = FULL HOUSE");
        		continue;
        	}
        	isBreak = false;
        	for(int j = 0; j < arr.length - 4; j++) {
        		if(arr[j] + 1 == arr[j + 1] && arr[j + 1] + 1 == arr[j + 2] && arr[j + 2] + 1 == arr[j + 3] && arr[j + 3] + 1 == arr[j + 4]) {
        			isBreak = true;
        			pw.println(s + " = STRAIGHT");
        			break;
        		}
        	}
        	if(isBreak)
        		continue;
        	cnt = 0;
        	index = list.get(0);
        	isBreak = false;
        	for(int j = 0; j < list.size(); j++) {
        		if(index == list.get(j))
        			++cnt;
        		if(cnt == 3) {
        			pw.println(s + " = THREE OF A KIND");
        			isBreak = true;
        			break;
        		}
        		if(index != list.get(j)) {
        			cnt = 1;
        			index = list.get(j);
        		}
        	}
        	if(isBreak)
        		continue;
        	int count2 = 0;
        	for(int j : set)
        		if(map.get(j) == 2)
        			++count2;
        	if(count2 >= 2) {
        		pw.println(s + " = TWO PAIR");
        		continue;
        	}
        	isBreak = false;
        	cnt = 0;
        	index = list.get(0);
        	isBreak = false;
        	for(int j = 0; j < list.size(); j++) {
        		if(index == list.get(j))
        			++cnt;
        		if(cnt == 2) {
        			pw.println(s + " = PAIR");
        			isBreak = true;
        			break;
        		}
        		if(index != list.get(j)) {
        			cnt = 1;
        			index = list.get(j);
        		}
        	}
        	if(isBreak)
        		continue;
        	pw.println(s + " = " + arr[arr.length - 1]);
        }
        br.close();
        pw.close();
        Check.check("Prob15.out.txt");
	}
}