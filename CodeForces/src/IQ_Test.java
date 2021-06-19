import java.util.*;
import java.io.*;
public class IQ_Test {
    static BufferedReader br;
    static int[] n;
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
    	n = new int[Integer.parseInt(br.readLine())];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < n.length; i++)
    		n[i] = Integer.parseInt(st.nextToken());
    }
    private static String solve() {
        int index = 0;
        int trueCount = 0;
        int index2 = 0;
        for(int i = 0; i < n.length; i++) {
        	if(n[i] % 2 == 0)
        		index = i;
        	else {
        		index2 = i;
        		trueCount++;
        	}
        }
        if(trueCount == 1)
        	return String.valueOf(index2 + 1);
        else
        	return String.valueOf(index + 1);
    }
}