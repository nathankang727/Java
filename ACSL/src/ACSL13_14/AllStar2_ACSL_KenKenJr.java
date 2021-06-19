package ACSL13_14;
import java.util.*;
import java.io.*;
public class AllStar2_ACSL_KenKenJr  {
	static int[][] grid;
	@SuppressWarnings({"rawtypes", "unchecked"})
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1314AllStar2.in")));
		String[] possibleGrids = {"123231312", "123312231", "132213321", "132321213", "213132321", "213321132", "231123312", 
				"231312123", "312123231", "312231123", "321132213", "321213132"};
		for(int i = 0; i < 3; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int groupNum = Integer.parseInt(st.nextToken());
			ArrayList[] groups = new ArrayList[groupNum];
			for(int j = 0; j < groupNum; j++) {
				groups[j] = new ArrayList<String>();
				String num = st.nextToken();
				while(num.length() < 2) {
					groups[j].add(num);
					num = st.nextToken();
				}
				groups[j].add(num);
			}
			String grid = "";
			for(int j = 0; j < 12; j++) {
				grid = possibleGrids[j];
				boolean gridWorks = true;
				for(int k = 0; k < groupNum; k++) {
					if(!works(grid, groups[k])) {
						gridWorks = false;
						break;
					}
				}
				if(!gridWorks)
					continue;
				else
					break;
			}
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++)
				System.out.println(grid.charAt(Integer.parseInt(st.nextToken()) - 1));
		}
		br.close();
	}
	public static boolean works(String grid, ArrayList<String> list) {
		if(list.size() == 2)
			return grid.charAt(Integer.parseInt(list.get(0)) - 1) == list.get(1).charAt(0);
		else if(list.size() == 3) {
			return Integer.parseInt(grid.substring(Integer.parseInt(list.get(0)) - 1, Integer.parseInt(list.get(0)))) + 
					Integer.parseInt(grid.substring(Integer.parseInt(list.get(1)) - 1, Integer.parseInt(list.get(1)))) == 
					Integer.parseInt(list.get(2).substring(0, 1));
		}
		else {
			return Integer.parseInt(grid.substring(Integer.parseInt(list.get(0)) - 1, Integer.parseInt(list.get(0)))) + 
					Integer.parseInt(grid.substring(Integer.parseInt(list.get(1)) - 1, Integer.parseInt(list.get(1)))) + 
					Integer.parseInt(grid.substring(Integer.parseInt(list.get(2)) - 1, Integer.parseInt(list.get(2)))) == 
					Integer.parseInt(list.get(3).substring(0, 1));
		}
	}
}