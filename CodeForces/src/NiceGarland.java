import java.io.*;
public class NiceGarland {
    static BufferedReader br;
    static String[] s;
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
    	br.readLine();
    	s = br.readLine().split("");
    }
    private static String solve() {
    	int minDiff = s.length;
    	StringBuilder sb = new StringBuilder();
        String[] basic = {"RGB", "RBG", "GRB", "GBR", "BRG", "BGR"};
        for(int i = 0; i < 6; i++) {
        	StringBuilder str = new StringBuilder();
        	int diff = 0;
        	for(int j = 0; j < s.length; j++) {
        		str.append(basic[i].substring(j % 3, j % 3 + 1));
        		if(!s[j].equals(str.substring(j, j + 1)))
        			diff++;
        	}
    		if(diff < minDiff) {
    			minDiff = diff;
    			sb.delete(0, sb.length());
    			sb.append(str);
    		}
        }
    	return minDiff + "\n" + sb;
    }
}