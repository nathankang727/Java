import java.io.*;
import java.util.*;
public class RGBSubstring {
    static BufferedReader br;
    static int[] input;
    static String[] word;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            init();
            solve();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	int q = Integer.parseInt(br.readLine());
    	input = new int[q];
    	word = new String[q];
    	for(int i = 0; i < q; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		st.nextToken();
    		input[i] = Integer.parseInt(st.nextToken());
    		word[i] = br.readLine();
    	}
    }
    private static void solve() {
        for(int i = 0; i < word.length; i++) {
        	StringBuilder sb = new StringBuilder();
        	sb.append(word[i]);
        	int n = input[i];
        	int min = Integer.MAX_VALUE;
        	String[] poss = possible(n);
        	for(int j = 0; j < 3; j++) {
        		for(int k = 0; k <= sb.length() - n; k++) {
        			StringBuilder s = new StringBuilder();
        			s.append(sb.substring(k, k + n));
        			int d = 0;
        	    	for(int l = 0; l < s.length(); l++)
        	    		if(s.charAt(l) != poss[j].charAt(l))
        	    			d++;
        			if(d < min)
        				min = d;
        		}
        	}
        	System.out.println(min);
        }
    }
    private static String[] possible(int n) {
    	String[] res = {"", "", ""};
    	StringBuilder sb = new StringBuilder();
    	sb.append("RGB");
    	for(int j = 0; j < n; j++)
    		res[0] += sb.substring(j % 3, j % 3 + 1);
    	for(int j = 1; j <= n; j++)
    		res[1] += sb.substring(j % 3, j % 3 + 1);
    	for(int j = 2; j <= n + 1; j++)
    		res[2] += sb.substring(j % 3, j % 3 + 1);
    	return res;
    }
}