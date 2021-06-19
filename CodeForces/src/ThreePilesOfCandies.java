import java.io.*;
import java.util.StringTokenizer;
public class ThreePilesOfCandies {
    static BufferedReader br;
    static long[][] candy;
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
    	int n = Integer.parseInt(br.readLine());
    	candy = new long[n][3];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		candy[i][0] = Long.parseLong(st.nextToken());
    		candy[i][1] = Long.parseLong(st.nextToken());
    		candy[i][2] = Long.parseLong(st.nextToken());
    	}
    }
    private static void solve() {
    	for(int i = 0; i < candy.length; i++) {
    		long sum = candy[i][0] + candy[i][1];
    		sum += candy[i][2];
    		System.out.println(sum/2);
    	}
    }
}