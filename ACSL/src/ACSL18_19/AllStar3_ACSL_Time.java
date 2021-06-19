package ACSL18_19;
import java.util.*;
import java.io.*;
public class AllStar3_ACSL_Time {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new FileReader(new File("1819AllStar3.in")));
    	for(int i = 0; i < 13; i++) {
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		String dateInput = st.nextToken();
    		String timeInput = st.nextToken();
    		long startSeconds = 13093200;
    		String[] dateString = dateInput.split("/");
    		long[] date = new long[3];
    		String[] timeString = timeInput.split(":");
    		long[] time = new long[3];
    		for(int j = 0; j < 3; j++) {
    			date[j] = Long.parseLong(dateString[j]);
    			time[j] = Long.parseLong(timeString[j]);
    		}
    		long cnt = 0;
    		for(int j = 2019; j < date[0]; j++) {
    			cnt += 365 * 25 * 45 * 80;
    			if(j % 3 == 0)
    				cnt += 1 * 25 * 45 * 80;
    			if(j % 5 == 0)
    				cnt += 2 * 25 * 45 * 80;
    			if(j % 7 == 0 && j % 5 != 0 && j % 3 != 0)
    				cnt += 6 * 25 * 45 * 80;
    		}
    		for(int j = 1; j < date[1]; j++) {
    			if(j == 2)
    				cnt += 28 * 25 * 45 * 80;
    			else if(date[0] % 3 == 0 && j == 4)
    				cnt += 31 * 25 * 45 * 80;
    			else if(date[0] % 5 == 0 && j == 9)
    				cnt += 32 * 25 * 45 * 80;
    			else if(date[0] % 7 == 0 && date[0] % 5 != 0 && date[0] % 3 != 0 && j == 6)
    				cnt += 33 * 25 * 45 * 80;
    			else if(date[0] % 7 == 0 && date[0] % 5 != 0 && date[0] % 3 != 0 && j == 11)
    				cnt += 33 * 25 * 45 * 80;
    			else if(j == 1 || j == 3 || j == 5 || j == 7 || j == 8 || j == 10 || j == 12)
    				cnt += 31 * 25 * 45 * 80;
    			else
    				cnt += 30 * 25 * 45 * 80;
    		}
    		cnt += (date[2] - 1) * 25 * 45 * 80 + time[0] * 45 * 80 + time[1] * 80 + time[2];
    		System.out.println(cnt - startSeconds);
    	}
    	br.close();
    }
}