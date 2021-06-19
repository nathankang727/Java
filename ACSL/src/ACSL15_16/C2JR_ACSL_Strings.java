package ACSL15_16;
import java.util.*;
import java.io.*;
public class C2JR_ACSL_Strings {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1516C2Jr.in"));
		for(int i = 0; i < 1; i++) {
			String[] string = sc.nextLine().split("");
			for(int j = 0; j < 8; j++) {
				String[] index = sc.nextLine().split(" ");
				int start = Integer.parseInt(index[0]);
				int length = Integer.parseInt(index[1]);
				String res = "";
				if(length >= 0) {
					int formerLength = length;
					if(length == 0)
						length = string.length;
					if(start < 0)
						start += string.length;
					if(formerLength > 0 || formerLength < 0)
						length += start;
					for(int k = start; k < length; k++)
						res += string[k];
				}
				else {
					length += string.length;
					if(start < 0)
						start += string.length;
					for(int k = start; k < length; k++)
						res += string[k];
				}
				System.out.println(res);
			}
		}
		for(int i = 0; i < 1; i++) {
			String[] string = sc.nextLine().split("");
			for(int j = 0; j < 5; j++) {
				String[] index = sc.nextLine().split(" ");
				int start = Integer.parseInt(index[0]);
				int length = Integer.parseInt(index[1]);
				String res = "";
				if(length >= 0) {
					int formerLength = length;
					if(length == 0)
						length = string.length;
					if(start < 0)
						start += string.length;
					if(formerLength > 0 || formerLength < 0)
						length += start;
					for(int k = start; k < length; k++)
						res += string[k];
				}
				else {
					length += string.length;
					if(start < 0)
						start += string.length;
					for(int k = start; k < length; k++)
						res += string[k];
				}
				System.out.println(res);
			}
		}
		sc.close();
	}
}
/*
Hello world!
0 10
1 8
0 5
6 6
0 -1
-10 -2
0 -5
-4 0
ALL-STAR CONTEST 2016
0 10
3 8
-8 0
6 -6
-12 -8
*/