import java.util.*;
import java.io.*;
public class JeffAndDigits {
    static BufferedReader br;
    static int[] cards;
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
    	int n = Integer.parseInt(br.readLine());
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	cards = new int[n];
    	for(int i = 0; i < n; i++)
    		cards[i] = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
    	int che = 0;
    	for(int i = 0; i < cards.length; i++)
    		if(cards[i] == 0)
    			che++;
    	if(che == 0)
    		return "-1";
    	String res = "";
    	int c = cards.length - che;
    	c = c / 9 * 9;
    	if(c == 0)
    		return "0";
    	for(int i = 0; i < c; i++)
    		res += "5";
    	for(int i = 0; i < che; i++)
    		res += "0";
    	return res;
    }
}