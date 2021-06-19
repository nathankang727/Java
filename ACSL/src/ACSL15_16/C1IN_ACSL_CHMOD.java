package ACSL15_16;
import java.io.*;
public class C1IN_ACSL_CHMOD {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("1516C1In.in"));
		for(int i = 1; i <= 10; i++) {
			String[] command = br.readLine().split(" ");
			String res1 = "";
			String res2 = "";
			boolean[] choice = new boolean[3];
			if(i == 1 || i == 2 || i == 6 || i == 7)
				choice[0] = true;
			else if(i == 3 || i == 4 || i == 8 || i == 9)
				choice[1] = true;
			else
				choice[2] = true;
			for(int j = 0; j < 3; j++) {
				if(choice[0]) {
					res1 += toBinary(command[j]);
					res2 += toCommand(command[j]);
				}
				else if(choice[1]) {
					res1 += toOctal(command[j]);
					res2 += toCommand(command[j]);
				}
				else {
					res1 += toOctal(command[j]);
					res2 += toBinary(command[j]);
				}
			}
			System.out.println(res1 + "and " + res2);
		}
		br.close();
	}
	public static String toBinary(String n) {
		if(n.equals("0") || n.equals("---"))
			return "000 ";
		else if(n.equals("1") || n.equals("--x"))
			return "001 ";
		else if(n.equals("2") || n.equals("-w-"))
			return "010 ";
		else if(n.equals("3") || n.equals("-wx"))
			return "011 ";
		else if(n.equals("4") || n.equals("r--"))
			return "100 ";
		else if(n.equals("5") || n.equals("r-x"))
			return "101 ";
		else if(n.equals("6") || n.equals("rw-"))
			return "110 ";
		else
			return "111 ";
	}
	public static String toCommand(String n) {
		if(n.equals("0") || n.equals("000"))
			return "--- ";
		else if(n.equals("1") || n.equals("001"))
			return "--x ";
		else if(n.equals("2") || n.equals("010"))
			return "-w- ";
		else if(n.equals("3") || n.equals("011"))
			return "-wx ";
		else if(n.equals("4") || n.equals("100"))
			return "r-- ";
		else if(n.equals("5") || n.equals("101"))
			return "r-x ";
		else if(n.equals("6") || n.equals("110"))
			return "rw- ";
		else
			return "rwx ";
	}
	public static String toOctal(String n) {
		if(n.equals("000") || n.equals("---"))
			return "0 ";
		else if(n.equals("001") || n.equals("--x"))
			return "1 ";
		else if(n.equals("010") || n.equals("-w-"))
			return "2 ";
		else if(n.equals("011") || n.equals("-wx"))
			return "3 ";
		else if(n.equals("100") || n.equals("r--"))
			return "4 ";
		else if(n.equals("101") || n.equals("r-x"))
			return "5 ";
		else if(n.equals("110") || n.equals("rw-"))
			return "6 ";
		else
			return "7 ";
	}
}