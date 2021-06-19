package ACSL19_20;
import java.util.*;
import java.io.*;
public class AllStar2_Passort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 13; i++)
			System.out.println(passort(br.readLine()));
		br.close();
	}
	public static int passort(String line) {
        int cnt = 0;
        line = line.replaceAll("[^A-Za-z0-9]", "");
        ArrayList<Character> original = new ArrayList<Character>();
        ArrayList<Character> sorted = new ArrayList<Character>();
        for(int i = 0; i < line.length(); i++) {
        	original.add(line.charAt(i));
        	sorted.add(line.charAt(i));
        }
        Collections.sort(sorted);
        while(!original.toString().equals(sorted.toString())) {
        	int sortedIndex = 0;
        	int originalIndex = 0;
        	if(cnt % 2 == 1) {
        		for(int i = original.size() - 1; i >= 0; i--) {
        			if(original.get(i) != sorted.get(i)) {
        				sortedIndex = i;
        				for(int j = i; j >= 0; j--) {
        					if(original.get(j) == sorted.get(i)) {
        						originalIndex = j;
        						break;
        					}
        				}
        				break;
        			}
        		}
        	}
        	else {
        		for(int i = 0; i < original.size(); i++) {
        			if(original.get(i) != sorted.get(i)) {
        				sortedIndex = i;
        				for(int j = i; j < original.size(); j++) {
        					if(original.get(j) == sorted.get(i)) {
        						originalIndex = j;
        						break;
        					}
        				}
        				break;
        			}
        		}
        	}
        	char temp = original.get(originalIndex);
    		original.set(originalIndex, original.get(sortedIndex));
    		original.set(sortedIndex, temp);
        	++cnt;
        }
        return cnt;
    }
}