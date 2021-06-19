package ACSL17_18;
import java.util.*;
import java.io.*;
public class AllStar1_PatternFinder {
	static int[][] nums;
	static int[][] pattern;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1718AllStar1.in")));
		for(int i = 0; i < 2; i++) {
			nums = new int[8][8];
			String[] sA = br.readLine().split(" ");
			for(int j = 0; j < 8; j++) {
				String str = convert(sA[j].substring(0, 1)) + convert(sA[j].substring(1));
				for(int k = 0; k < 8; k++)
					nums[j][k] = Integer.parseInt(str.substring(k, k + 1));
			}
			for(int j = 0; j < 10; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int row = Integer.parseInt(st.nextToken());
				int col = Integer.parseInt(st.nextToken());
				pattern = new int[row][col];
				for(int k = 0; k < row; k++) {
					String s = st.nextToken();
					for(int l = 0; l < col; l++)
						pattern[k][l] = Integer.parseInt(s.substring(l, l + 1));
				}
				counting();
			}
		}
		br.close();
	}
	public static String convert(String s) {
		if(s.equals("0"))
			return "0000";
		else if(s.equals("1"))
			return "0001";
		else if(s.equals("2"))
			return "0010";
		else if(s.equals("3"))
			return "0011";
		else if(s.equals("4"))
			return "0100";
		else if(s.equals("5"))
			return "0101";
		else if(s.equals("6"))
			return "0110";
		else if(s.equals("7"))
			return "0111";
		else if(s.equals("8"))
			return "1000";
		else if(s.equals("9"))
			return "1001";
		else if(s.equals("A"))
			return "1010";
		else if(s.equals("B"))
			return "1011";
		else if(s.equals("C"))
			return "1100";
		else if(s.equals("D"))
			return "1101";
		else if(s.equals("E"))
			return "1110";
		else
			return "1111";
	}
	public static void counting() {
		int count = 0;
		for(int i = 0; i <= 8 - pattern.length; i++) {
			for(int j = 0; j <= 8 - pattern[0].length; j++) {
				boolean didBreak = false;
				for(int r = i; r < i + pattern.length; r++) {
					for(int c = j; c < j + pattern[0].length; c++) {
						if(nums[r][c] != pattern[r - i][c - j]) {
							didBreak = true;
							break;
						}
					}
					if(didBreak)
						break;
				}
				if(!didBreak)
					++count;
			}
		}
		System.out.println(count);
	}
}