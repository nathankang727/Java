package ACSL22_23;
import java.io.*;
public class C1IN_NextBase {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int s = Integer.parseInt(br.readLine());
		System.out.println(countLargestDigit(n, b, s));
		br.close();
	}
	public static int countLargestDigit(int num, int base, int start) {
        int s10 = Integer.parseInt(String.valueOf(start), base);
        int cnt = 0;
        int largest = base - 1;
        for(int i = s10; i < s10 + num; i++) {
            String n = Integer.toString(i, base);
            for(int j = 0; j < n.length(); j++)
                if(Integer.parseInt(n.substring(j, j + 1)) == largest)
                    ++cnt;
        }
        return cnt;
    }
}