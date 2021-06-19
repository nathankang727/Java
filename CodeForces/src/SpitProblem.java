import java.util.*;
import java.io.*;
public class SpitProblem {
    static BufferedReader in;
    static int[][] camels;
    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            init();
            System.out.println(solve());
            in.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	int n = Integer.parseInt(in.readLine());
    	camels = new int[n][2];
    	for(int i = 0; i < n; i++) {
    		StringTokenizer st = new StringTokenizer(in.readLine());
    		camels[i][0] = Integer.parseInt(st.nextToken());
    		camels[i][1] = Integer.parseInt(st.nextToken()) + camels[i][0];
    	}
    }
    private static String solve() {
       	boolean hit = false;
       	for(int i = 0; i < camels.length; i++) {
       		int camelHit = camels[i][1];
       		int position = camels[i][0];
       		for(int j = 0; j < camels.length; j++) {
       			if(camelHit == camels[j][0] && camels[j][1] == position) {
       				hit = true;
       				break;
       			}
       		}
       		if(hit)
       			break;
       	}
       	if(hit)
       		return "YES";
       	return "NO";
    }
}