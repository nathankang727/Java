package BaseConversion;
import java.util.*;
public class Practice2 {
	public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        String s = line[0];
        int b = Integer.valueOf(line[1]);
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('0' <= c && c <= '9')
                ans = ans * b + (c - '0');
            else
                ans = ans * b + (c - 'A' + 10);
        }
        System.out.println(ans);
        in.close();
    }
}