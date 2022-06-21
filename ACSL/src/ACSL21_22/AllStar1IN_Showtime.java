package ACSL21_22;
import java.util.*;
public class AllStar1IN_Showtime {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(displayTime(sc.nextLine()));
		sc.close();
	}
	public static String displayTime(String time) {
        ArrayList<String> combo = new ArrayList<String>();
        String colors = "rgbcmywk";
        for(int a = 0; a < 8; a++) {
            for(int b = 0; b < 8; b++) {
                for(int c = 0; c < 8; c++) {
                    for(int d = 0; d < 8; d++) {
                        for(int e = 0; e < 8; e++) {
                            String str = colors.substring(a, a + 1) + colors.substring(b, b + 1) + colors.substring(c, c + 1);
                            str += colors.substring(d, d + 1) + colors.substring(e, e + 1);
                            combo.add(str);
                        }
                    }
                }
            }
        }
        Collections.sort(combo);
        String ans = "";
        String[] input = time.split(":");
        int h = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        int s = Integer.parseInt(input[2]);
        for(int i = 0; i < combo.size(); i++) {
            String str = combo.get(i);
            int tempH = 0;
            int tempM = 0;
            int tempS = 0;
            int[] fib = {1, 1, 2, 3, 5};
            for(int j = 0; j < 5; j++) {
                if(str.charAt(j) == 'r' || str.charAt(j) == 'm' || str.charAt(j) == 'y' ||str.charAt(j) == 'w') {
                    tempH += fib[j];
                }
                if(str.charAt(j) == 'g' || str.charAt(j) == 'c' || str.charAt(j) == 'y' ||str.charAt(j) == 'w') {
                    tempM += 5 * fib[j];
                }
                if(str.charAt(j) == 'b' || str.charAt(j) == 'c' || str.charAt(j) == 'm' ||str.charAt(j) == 'w') {
                    tempS += 5 * fib[j];
                }
                if(str.charAt(j) == 'k')
                    tempS += 0;
            }
            if(tempH == h && tempM == m && tempS == s) {
                if(ans.equals(""))
                    ans += str;
                else
                    ans += " " + str;
            }
        }
        return ans;
    }
}