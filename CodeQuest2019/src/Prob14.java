import java.util.*;
import java.io.*;
public class Prob14 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob14.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	int n = Integer.parseInt(br.readLine());
        	Map<String, Integer> map = new HashMap<String, Integer>();
        	Map<String, String> map2 = new HashMap<String, String>();
        	for(int j = 0; j < n; j++) {
        		StringTokenizer st = new StringTokenizer(br.readLine());
        		String s1 = st.nextToken();
        		String s2 = st.nextToken();
        		map2.put(s2, s1);
        		if(!map.containsKey(s1))
        			map.put(s1, 0);
        		else
        			map.put(s1, 2);
        		if(!map.containsKey(s2))
        			map.put(s2, 1);
        		else
        			map.put(s2, 2);
        	}
        	String startCity = "";
        	String endCity = "";
        	for(Map.Entry<String, Integer> m : map.entrySet()) {
        		if(m.getValue() == 1)
        			endCity = m.getKey();
        		else if(m.getValue() == 0) {
        			startCity = m.getKey();
        		}
        	}
        	String index = endCity;
        	while(!index.equals(startCity)) {
        		pw.println(index);
        		index = map2.get(index);
        	}
        	pw.println(index);
        }
        br.close();
        pw.close();
        Check.check("Prob14.out.txt");
	}
	static class mapp {
		public String start, end;
		public mapp(String st, String en) {
			this.start = st;
			this.end = en;
		}
	}
}