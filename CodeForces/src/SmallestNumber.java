import java.util.*;
import java.io.*;
public class SmallestNumber {
    static BufferedReader br;
    static int[] n;
    static char[] operations;
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
    	n = new int[4];
    	operations = new char[3];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < 4; i++)
    		n[i] = Integer.parseInt(st.nextToken());
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < 3; i++)
    		operations[i] = st.nextToken().charAt(0);
    }
    private static String solve() {
    	int[] total;
    	if(operations[0] == '*' && operations[1] == '*' && operations[2] == '*') {
    		long l = n[0] * n[1] * n[2];
    		return String.valueOf(l * n[3]);
    	}
    	else if(operations[0] == '+' && operations[1] == '*' && operations[2] == '*') {
    		total = new int[6];
    		for(int i = 0; i < 6; i++) {
    			if(i == 0) total[i] = (n[0] + n[1]) * n[2] * n[3];
    			else if(i == 1) total[i] = (n[0] + n[2]) * n[1] * n[3];
    			else if(i == 2) total[i] = (n[0] + n[3]) * n[1] * n[2];
    			else if(i == 3) total[i] = (n[1] + n[2]) * n[0] * n[3];
    			else if(i == 4) total[i] = (n[1] + n[3]) * n[0] * n[2];
    			else total[i] = (n[2] + n[3]) * n[0] * n[1];
    		}
    	}
    	else if(operations[0] == '*' && operations[1] == '+' && operations[2] == '*') {
    		total = new int[24];
    		for(int i = 0; i < 24; i++) {
    			if(i == 0) total[i] = (n[0] * n[2] + n[3]) * n[1];
    			else if(i == 1) total[i] = (n[0] * n[3] + n[2]) * n[1];
    			else if(i == 2) total[i] = (n[0] * n[1] + n[3]) * n[2];
    			else if(i == 3) total[i] = (n[0] * n[3] + n[1]) * n[2];
    			else if(i == 4) total[i] = (n[0] * n[1] + n[2]) * n[3];
    			else if(i == 5) total[i] = (n[0] * n[2] + n[1]) * n[3];
    			else if(i == 6) total[i] = (n[1] * n[2] + n[3]) * n[0];
    			else if(i == 7) total[i] = (n[1] * n[3] + n[2]) * n[0];
    			else if(i == 8) total[i] = (n[1] * n[0] + n[3]) * n[2];
    			else if(i == 9) total[i] = (n[1] * n[3] + n[0]) * n[2];
    			else if(i == 10) total[i] = (n[1] * n[0] + n[2]) * n[3];
    			else if(i == 11) total[i] = (n[1] * n[2] + n[0]) * n[3];
    			else if(i == 12) total[i] = (n[2] * n[1] + n[3]) * n[0];
    			else if(i == 13) total[i] = (n[2] * n[3] + n[1]) * n[0];
    			else if(i == 14) total[i] = (n[2] * n[0] + n[3]) * n[1];
    			else if(i == 15) total[i] = (n[2] * n[3] + n[0]) * n[1];
    			else if(i == 16) total[i] = (n[2] * n[0] + n[1]) * n[3];
    			else if(i == 17) total[i] = (n[2] * n[1] + n[0]) * n[3];
    			else if(i == 18) total[i] = (n[3] * n[1] + n[2]) * n[0];
    			else if(i == 19) total[i] = (n[3] * n[2] + n[1]) * n[0];
    			else if(i == 20) total[i] = (n[3] * n[0] + n[2]) * n[1];
    			else if(i == 21) total[i] = (n[3] * n[2] + n[0]) * n[1];
    			else if(i == 22) total[i] = (n[3] * n[0] + n[1]) * n[2];
    			else total[i] = (n[3] * n[1] + n[0]) * n[2];
    		}
    	}
    	else if(operations[0] == '*' && operations[1] == '*' && operations[2] == '+') {
    		total = new int[3];
    		for(int i = 0; i < 3; i++) {
    			if(i == 0) total[i] = n[0] * n[1] + n[2] * n[3];
    			else if(i == 1) total[i] = n[0] * n[2] + n[1] * n[3];
    			else total[i] = n[0] * n[3] + n[1] * n[2];
    		}
    	}
    	else if(operations[0] == '*' && operations[1] == '+' && operations[2] == '+') {
    		total = new int[6];
    		for(int i = 0; i < 6; i++) {
    			if(i == 0) total[i] = n[0] * n[1] + n[2] + n[3];
    			else if(i == 1) total[i] = n[0] * n[2] + n[1] + n[3];
    			else if(i == 2) total[i] = n[0] * n[3] + n[1] + n[2];
    			else if(i == 3) total[i] = n[1] * n[2] + n[0] + n[3];
    			else if(i == 4) total[i] = n[1] * n[3] + n[0] + n[2];
    			else total[i] = n[2] * n[3] + n[0] + n[1];
    		}
    	}
    	else if(operations[0] == '+' && operations[1] == '*' && operations[2] == '+') {
    		total = new int[30];
    		for(int i = 0; i < 30; i++) {
    			if(i == 0) total[i] = n[2] * (n[0] + n[1]) + n[3];
    			else if(i == 1) total[i] = (n[0] + n[1]) * n[3] + n[2];
    			else if(i == 2) total[i] = (n[0] + n[2]) * n[1] + n[3];
    			else if(i == 3) total[i] = (n[0] + n[2]) * n[3] + n[1];
    			else if(i == 4) total[i] = (n[0] + n[3]) * n[1] + n[2];
    			else if(i == 5) total[i] = (n[0] + n[3]) * n[2] + n[1];
    			else if(i == 6) total[i] = (n[1] + n[0]) * n[2] + n[3];
    			else if(i == 7) total[i] = (n[1] + n[0]) * n[3] + n[2];
    			else if(i == 8) total[i] = (n[1] + n[2]) * n[0] + n[3];
    			else if(i == 9) total[i] = (n[1] + n[2]) * n[3] + n[0];
    			else if(i == 10) total[i] = (n[1] + n[3]) * n[0] + n[2];
    			else if(i == 11) total[i] = (n[1] + n[3]) * n[2] + n[0];
    			else if(i == 12) total[i] = (n[2] + n[0]) * n[1] + n[3];
    			else if(i == 13) total[i] = (n[2] + n[0]) * n[3] + n[1];
    			else if(i == 14) total[i] = (n[2] + n[1]) * n[0] + n[3];
    			else if(i == 15) total[i] = (n[2] + n[1]) * n[3] + n[0];
    			else if(i == 16) total[i] = (n[2] + n[3]) * n[0] + n[1];
    			else if(i == 17) total[i] = (n[2] + n[3]) * n[1] + n[0];
    			else if(i == 18) total[i] = (n[3] + n[2]) * n[0] + n[1];
    			else if(i == 19) total[i] = (n[3] + n[2]) * n[1] + n[0];
    			else if(i == 20) total[i] = (n[3] + n[1]) * n[0] + n[2];
    			else if(i == 21) total[i] = (n[3] + n[1]) * n[2] + n[0];
    			else if(i == 22) total[i] = (n[3] + n[0]) * n[1] + n[2];
    			else if(i == 23) total[i] = n[0] * n[1] + (n[2] + n[3]);
    			else if(i == 24) total[i] = n[0] * n[2] + (n[1] + n[3]);
    			else if(i == 25) total[i] = n[0] * n[3] + (n[1] + n[2]);
    			else if(i == 26) total[i] = n[1] * n[2] + (n[0] + n[3]);
    			else if(i == 27) total[i] = n[1] * n[3] + (n[0] + n[2]);
    			else if(i == 28) total[i] = n[2] * n[3] + (n[0] + n[1]);
    			else total[i] = (n[3] + n[0]) * n[2] + n[1];
    		}
    	}
    	else if(operations[0] == '+' && operations[1] == '+' && operations[2] == '*') {
    		total = new int[7];
    		for(int i = 0; i < 7; i++) {
    			if(i == 0) total[i] = (n[1] + n[2] + n[3]) * n[0];
    			else if(i == 1) total[i] = (n[0] + n[2] + n[3]) * n[1];
    			else if(i == 2) total[i] = (n[0] + n[1] + n[3]) * n[2];
    			else if(i == 3) total[i] = (n[0] + n[1] + n[2]) * n[3];
    			else if(i == 4) total[i] = (n[0] + n[1]) * (n[2] + n[3]);
    			else if(i == 5) total[i] = (n[0] + n[2]) * (n[1] + n[3]);
    			else total[i] = (n[0] + n[3]) * (n[1] + n[2]);
    		}
    	}
    	else
    		return String.valueOf(n[0] + n[1] + n[2] + n[3]);
    	Arrays.sort(total);
		return String.valueOf(total[0]);
    }
}