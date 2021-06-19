package ACSL14_15;
import java.util.*;
import java.io.*;
public class AllStar4_M_of_N_ErrorDetection {
	static ArrayList<String> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1415AllStar4.in")));
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String maskStr = st.nextToken();
			int[] mask = new int[maskStr.length()];
			for(int j = 0; j < mask.length; j++)
				mask[j] = Integer.parseInt(maskStr.substring(j, j + 1));
			int num = Integer.parseInt(st.nextToken());
			String temp = "";
			for(int j = 0; j < num; j++)
				temp += "1";
			for(int j = 0; j < mask.length - num; j++)
				temp += "0";
			int n = Integer.parseInt(st.nextToken());
			list = new ArrayList<String>();
			combinations(temp, "");
			boolean somethingPrint = false;
			for(int j = 0; j < list.size(); j++) {
				String string = list.get(j);
				int res = 0;
				for(int k = 0; k < string.length(); k++)
					if(string.charAt(k) == '1')
						res += mask[k];
				if(res == n) {
					System.out.print(string + " ");
					somethingPrint = true;
				}
			}
			System.out.println(somethingPrint ? "" : "NONE");
		}
		br.close();
	}
	public static void combinations(String str, String results) {
		if(str.length() == 0) {
			list.add(results);
			return;
		}
		boolean[] b = new boolean[2];
		for(int i = 0; i < str.length(); i++) {
			int n = Integer.parseInt(str.substring(i, i + 1));
			String temp = str.substring(0, i) + str.substring(i + 1);
			if(!b[n])
				combinations(temp, results + str.substring(i, i + 1));
			b[n] = true;
		}
	}
}