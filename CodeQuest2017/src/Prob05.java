import java.util.*;
import java.io.*;
public class Prob05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob05.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine().replace(",", " "));
        	ArrayList<String> lastYear = new ArrayList<String>();
        	ArrayList<String> thisYear = new ArrayList<String>();
        	Set<String> people = new HashSet<String>();
        	ArrayList<String> group1 = new ArrayList<String>();
        	ArrayList<String> group2 = new ArrayList<String>();
        	ArrayList<String> group3 = new ArrayList<String>();
        	while(st.hasMoreTokens()) {
        		lastYear.add(st.nextToken());
        		people.add(lastYear.get(lastYear.size() - 1));
        	}
        	st = new StringTokenizer(br.readLine().replace(",", " "));
        	while(st.hasMoreTokens()) {
        		thisYear.add(st.nextToken());
        		people.add(thisYear.get(thisYear.size() - 1));
        	}
        	for(String s : people) {
        		if(lastYear.contains(s) && !thisYear.contains(s))
        			group1.add(s);
        		else if(lastYear.contains(s) && thisYear.contains(s))
        			group2.add(s);
        		else
        			group3.add(s);
        	}
        	Collections.sort(group1);
        	Collections.sort(group2);
        	Collections.sort(group3);
        	pw.print(group1.get(0));
        	for(int j = 1; j < group1.size(); j++)
            	pw.print("," + group1.get(j));
        	pw.println();
        	pw.print(group2.get(0));
        	for(int j = 1; j < group2.size(); j++)
            	pw.print("," + group2.get(j));
        	pw.println();
        	pw.print(group3.get(0));
        	for(int j = 1; j < group3.size(); j++)
            	pw.print("," + group3.get(j));
        	pw.println();
        }
        br.close();
        pw.close();
        Check.check("Prob05.out.txt");
	}
}