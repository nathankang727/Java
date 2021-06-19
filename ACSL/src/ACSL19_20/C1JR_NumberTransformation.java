package ACSL19_20;
import java.util.*;
import java.io.*;
public class C1JR_NumberTransformation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("1920C1Jr.in")));
        for(int i = 0; i < 5; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	String s = st.nextToken();
        	int[] num = new int[s.length() + 1];
        	for(int j = 1; j < num.length; j++)
        		num[j] = Integer.parseInt(s.substring(j - 1, j));
        	int p = Integer.parseInt(st.nextToken());
        	int d = Integer.parseInt(st.nextToken());
        	int digit = num[num.length - p];
        	int newDigit = 0;
        	if(digit < 5) {
        		digit += d;
        		newDigit = digit % 10;
        	}
        	else {
        		digit -= d;
        		digit = Math.abs(digit);
        		newDigit = Integer.parseInt(String.valueOf(digit).substring(0, 1));
        	}
        	num[num.length - p] = newDigit;
        	for(int j = num.length - p + 1; j < num.length; j++)
        		num[j] = 0;
        	String str = "";
        	for(int j = 0; j < num.length; j++)
        		str += num[j];
        	System.out.println(Long.parseLong(str));
        }
        br.close();
    }
}