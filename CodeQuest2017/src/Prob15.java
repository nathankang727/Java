import java.util.*;
import java.io.*;
public class prob15 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob152.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	String input = br.readLine();
        	ArrayList<Integer> num = new ArrayList<Integer>();
        	int max = 0;
        	for(int j = 0; j < input.length(); j++)
        		if(input.charAt(j) != '0')
        			num.add(Integer.parseInt(input.substring(j, j + 1)));
        	Collections.sort(num);
        	max = num.get(num.size() - 1);
        	int[] count = new int[10];
        	int cnt = 1;
        	++count[num.get(0)];
        	for(int j = 1; j < num.size(); j++) {
        		++count[num.get(j)];
        		if(num.get(j - 1) + 1 == num.get(j))
        			++cnt;
        		else if(num.get(j - 1) == num.get(j))
        			continue;
        		else if(cnt < 5)
        			cnt = 1;
        	}
        	Arrays.sort(count);
        	boolean has2 = false;
        	boolean has3 = false;
        	for(int j = 0; j < count.length; j++) {
        		if(!has3 && count[j] >= 3)
        			has3 = true;
        		else if(count[j] >= 2)
        			has2 = true;
        	}
        	boolean has21 = false;
        	boolean has22 = false;
        	for(int j = 0; j < count.length; j++) {
        		if(has21 && count[j] >= 2)
        			has22 = true;
        		else if(count[j] >= 2)
        			has21 = true;
        	}
        	String result = "";
        	if(count[count.length - 1] >= 5)
        		result = "FIVE OF A KIND";
        	else if(count[count.length - 1] >= 4)
        		result = "FOUR OF A KIND";
        	else if(has2 && has3)
        		result = "FULL HOUSE";
        	else if(cnt >= 5)
        		result = "STRAIGHT";
        	else if(count[count.length - 1] >= 3)
        		result = "THREE OF A KIND";
        	else if(has21 && has22)
        		result = "TWO PAIR";
        	else if(count[count.length - 1] >= 2)
        		result = "PAIR";
        	else
        		result = String.valueOf(max);
        	pw.println(input + " = " + result);
        }
        br.close();
        pw.close();
        Check.check("Prob152.out.txt");
	}
}