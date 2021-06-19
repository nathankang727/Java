import java.io.*;
import java.util.*;
public class SerejaAndBottles {
    static BufferedReader br;
    static int[][] bottles;
    static boolean[] open;
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
    	bottles = new int[n][2];
    	for(int i = 0; i < bottles.length; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		bottles[i][0] = Integer.parseInt(st.nextToken());
    		bottles[i][1] = Integer.parseInt(st.nextToken());
    	}
    	open = new boolean[n];
    }
    private static String solve() {
        for(int i = 0; i < open.length; i++) {
        	int brand = bottles[i][1];
        	for(int j = 0; j < open.length; j++) {
        		if(i == j)
        			continue;
        		if(brand == bottles[j][0])
        			open[j] = true;
        	}
        }
        int result = 0;
        for(int i = 0; i < open.length; i++)
        	if(!open[i])
        		++result;
        return String.valueOf(result);
    }
}