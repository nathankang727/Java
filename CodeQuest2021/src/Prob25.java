import java.util.*;
import java.io.*;
public class Prob25 {
	static char[][] grid;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int i = 0; i < t; i++) {
			String alphabet = "abcdefghiklmnopqrstuvwxyz";
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			String key = st.nextToken().toLowerCase().replace("j", "x");
			Set<Character> set = new LinkedHashSet<Character>();
			grid = new char[5][5];
			for(int j = 0; j < key.length(); j++)
				set.add(key.charAt(j));
			ArrayList<Character> input = new ArrayList<Character>();
			for(char c : set)
				input.add(c);
			int index = 0;
			int alphaIndex = 0;
			String used = "";
			for(int j = 0; j < 5; j++) {
				for(int k = 0; k < 5; k++) {
					if(index < input.size()) {
						grid[j][k] = input.get(index);
						used += input.get(index);
						++index;
					}
					else {
						while(true) {
							if(used.indexOf(alphabet.substring(alphaIndex, alphaIndex + 1)) == -1) {
								used += alphabet.charAt(alphaIndex);
								grid[j][k] = alphabet.charAt(alphaIndex);
								break;
							}
							++alphaIndex;
						}
					}
				}
			}
			for(int j = 0; j < n; j++) {
				String code = br.readLine().toLowerCase().replace("j", "x");
				if(code.length() % 2 == 1)
					code += "x";
				String result = "";
				for(int k = 0; k < code.length(); k += 2) {
					char a = code.charAt(k);
					char b = code.charAt(k + 1);
					if(a == b)
						b = 'x';
					int resultSize = result.length();
					result += row(a, b);
					if(resultSize + 2 == result.length())
						continue;
					result += col(a, b);
					if(resultSize + 2 == result.length())
						continue;
					result += other(a, b);
				}
				System.out.println(result);
			}
		}
		br.close();
	}
	public static String row(char a, char b) {
		int ax = 0;
		int ay = 0;
		int bx = 0;
		int by = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(grid[i][j] == a) {
					ax = i;
					ay = j;
				}
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(grid[i][j] == b) {
					bx = i;
					by = j;
				}
			}
		}
		if(ax != bx)
			return "";
		--ay;
		--by;
		if(ay == -1)
			ay = 4;
		if(by == -1)
			by = 4;
		return grid[ax][ay] + "" + grid[bx][by];
	}
	public static String col(char a, char b) {
		int ax = 0;
		int ay = 0;
		int bx = 0;
		int by = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(grid[i][j] == a) {
					ax = i;
					ay = j;
				}
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(grid[i][j] == b) {
					bx = i;
					by = j;
				}
			}
		}
		if(ay != by)
			return "";
		--ax;
		--bx;
		if(ax == -1)
			ax = 4;
		if(bx == -1)
			bx = 4;
		return grid[ax][ay] + "" + grid[bx][by];
	}
	public static String other(char a, char b) {
		int ax = 0;
		int ay = 0;
		int bx = 0;
		int by = 0;
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(grid[i][j] == a) {
					ax = i;
					ay = j;
				}
			}
		}
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++) {
				if(grid[i][j] == b) {
					bx = i;
					by = j;
				}
			}
		}
		int temp1 = ay;
		int temp2 = by;
		ay = temp2;
		by = temp1;
		return grid[ax][ay] + "" + grid[bx][by];
	}
}