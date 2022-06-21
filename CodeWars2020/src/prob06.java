import java.util.*;
import java.io.*;
public class prob06 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		while(sc.hasNextLine()) {
			int num = Integer.parseInt(sc.nextLine());
			String ans = "";
			if(num - 1000 >= 0) {
				num -= 1000;
				ans += "R";
			}
			if(num - 900 >= 0) {
				num -= 900;
				ans += "BR";
			}
			if(num - 800 >= 0) {
				num -= 800;
				ans += "GBBB";
			}
			if(num - 700 >= 0) {
				num -= 700;
				ans += "GBB";
			}
			if(num - 600 >= 0) {
				num -= 600;
				ans += "GB";
			}
			if(num - 500 >= 0) {
				num -= 500;
				ans += "G";
			}
			if(num - 400 >= 0) {
				num -= 400;
				ans += "BG";
			}
			if(num - 300 >= 0) {
				num -= 300;
				ans += "BBB";
			}
			if(num - 200 >= 0) {
				num -= 200;
				ans += "BB";
			}
			if(num - 100 >= 0) {
				num -= 100;
				ans += "B";
			}
			if(num - 90 >= 0) {
				num -= 90;
				ans += "ZB";
			}
			if(num - 80 >= 0) {
				num -= 80;
				ans += "PZZZ";
			}
			if(num - 70 >= 0) {
				num -= 70;
				ans += "PZZ";
			}
			if(num - 60 >= 0) {
				num -= 60;
				ans += "PZ";
			}
			if(num - 50 >= 0) {
				num -= 50;
				ans += "P";
			}
			if(num - 40 >= 0) {
				num -= 40;
				ans += "ZP";
			}
			if(num - 30 >= 0) {
				num -= 30;
				ans += "ZZZ";
			}
			if(num - 20 >= 0) {
				num -= 20;
				ans += "ZZ";
			}
			if(num - 10 >= 0) {
				num -= 10;
				ans += "Z";
			}
			if(num - 9 >= 0) {
				num -= 9;
				ans += "BK";
			}
			if(num - 8 >= 0) {
				num -= 8;
				ans += "WBBB";
			}
			if(num - 7 >= 0) {
				num -= 7;
				ans += "WBB";
			}
			if(num - 6 >= 0) {
				num -= 6;
				ans += "WB";
			}
			if(num - 5 >= 0) {
				num -= 5;
				ans += "W";
			}
			if(num - 4 >= 0) {
				num -= 4;
				ans += "BW";
			}
			if(num - 3 >= 0) {
				num -= 3;
				ans += "BBB";
			}
			if(num - 2 >= 0) {
				num -= 2;
				ans += "BB";
			}
			if(num - 1 >= 0) {
				num -= 1;
				ans += "B";
			}
			System.out.println(ans);
		}
		sc.close();
	}
}