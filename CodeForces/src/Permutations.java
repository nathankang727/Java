import java.io.*;
import java.util.*;
public class Permutations {
    static BufferedReader br;
    static String[] numbers;
    static int k;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            init();
            System.out.println(solve());
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	numbers = new String[Integer.parseInt(st.nextToken())];
    	k = Integer.parseInt(st.nextToken());
    	for(int i = 0; i < numbers.length; i++)
    		numbers[i] = br.readLine();
    }
    private static String solve() {
    	int min = Integer.MAX_VALUE;
    	String s1 = "";
    	for(int i = 0; i < k; i++)
    		s1 += i + "";
    	String[] s = possibleDigits(s1);
        String[] changeable = new String[numbers.length];
        for(int i = 0; i < changeable.length; i++)
        	changeable[i] = "";
    	for(int i = 0; i < s.length; i++) {
    		int total = 0;
    		for(int j = 0; j < changeable.length; j++) {
    			for(int k = 0; k < numbers[j].length(); k++) {
    				String a = s[i].substring(k, k + 1);
    				changeable[j] += numbers[j].substring(Integer.parseInt(a), Integer.parseInt(a) + 1);
    			}
    		}
    		Arrays.sort(changeable);
    		total = Integer.parseInt(changeable[changeable.length - 1]) - Integer.parseInt(changeable[0]);
    		if(total < min)
    			min = total;
    		changeable = new String[numbers.length];
    		for(int j = 0; j < changeable.length; j++)
    			changeable[j] = "";
    	}
    	return String.valueOf(min);
    }
    private static String[] possibleDigits(String s) {
    	ArrayList<String> list = new ArrayList<String>();
    	list.add(s.substring(0, 1));
    	for(int i = 1; i < s.length(); i++) {
    		for(int j = list.size() - 1; j >= 0; j--) {
    			String str = list.remove(j);
    			for(int k = 0; k <= str.length(); k++)
    				list.add(str.substring(0, k) + s.charAt(i) + str.substring(k));
    		}
    	}
    	String[] res = new String[list.size()];
    	for(int i = 0; i < list.size(); i++)
    		res[i] = list.get(i);
    	return res;
    }
}