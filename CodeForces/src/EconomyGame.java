import java.io.*;
public class EconomyGame {
    static BufferedReader br;
    static int n;
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
    	n = Integer.parseInt(br.readLine());
    }
    private static String solve() {
        for(int i = 0; i <= n; i += 1234567)
        	for(int j = 0; i + j <= n; j += 123456)
        		if((n - i - j) % 1234 == 0)
        			return "YES";
        return "NO";
    }
}