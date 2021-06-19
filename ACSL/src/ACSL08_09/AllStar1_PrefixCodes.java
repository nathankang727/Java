package ACSL08_09;
import java.io.*;
public class AllStar1_PrefixCodes {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("0809AllStar1.in")));
		for(int i = 0; i < 10; i++)
			System.out.println(change((conversions(br.readLine()))));
		br.close();
	}
	public static String conversions(String c) {
		String binary = "";
		for(int i = 0; i < c.length(); i++) {
			if(c.substring(i, i + 1).equals("A"))
				binary += "1010";
			else if(c.substring(i, i + 1).equals("B"))
				binary += "1011";
			else if(c.substring(i, i + 1).equals("C"))
				binary += "1100";
			else if(c.substring(i, i + 1).equals("D"))
				binary += "1101";
			else if(c.substring(i, i + 1).equals("E"))
				binary += "1110";
			else if(c.substring(i, i + 1).equals("F"))
				binary += "1111";
			else if(c.substring(i, i + 1).equals("0"))
				binary += "0000";
			else if(c.substring(i, i + 1).equals("1"))
				binary += "0001";
			else if(c.substring(i, i + 1).equals("2"))
				binary += "0010";
			else if(c.substring(i, i + 1).equals("3"))
				binary += "0011";
			else if(c.substring(i, i + 1).equals("4"))
				binary += "0100";
			else if(c.substring(i, i + 1).equals("5"))
				binary += "0101";
			else if(c.substring(i, i + 1).equals("6"))
				binary += "0110";
			else if(c.substring(i, i + 1).equals("7"))
				binary += "0111";
			else if(c.substring(i, i + 1).equals("8"))
				binary += "1000";
			else if(c.substring(i, i + 1).equals("9"))
				binary += "1001";
		}
		return binary;
	}
	public static String change(String s) {
		String result = "";
        String[] key = {"0", "10", "110", "1110", "1111"};
        while(s.length() > 0) {
            for(int i = 0; i < 5; i++) {
                if(s.indexOf(key[i]) == 0) {
                    if(i == 0)
                    	result += "P";
                    else if(i == 1)
                    	result += "Q";
                    else if(i == 2)
                    	result += "R";
                    else if(i == 3)
                    	result += "S";
                    else
                    	result += "T";
                    s = s.substring(key[i].length());
                }
            }
        }
        return result;
	}
}