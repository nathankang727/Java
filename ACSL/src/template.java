import java.io.*;
public class template {
    static BufferedReader br;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(new File("xxx.in")));
        for(int i  = 0; i < 5; i++) {
        	try {
        		init();
        		solve();
        	}
        	catch(Exception e) {
        		e.printStackTrace();
        	}
        }
        br.close();
    }
    private static void init() throws IOException {
    	
    }
    private static void solve() {
       
    }
}