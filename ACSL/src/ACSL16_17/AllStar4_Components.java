package ACSL16_17;
import java.util.*;
import java.io.*;
public class AllStar4_Components {
	@SuppressWarnings({"unchecked"})
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1617AllStar4.in")));
		char[] conversion = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
		for(int i = 0; i < 20; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			ArrayList<Character>[] graph = new ArrayList[n];
			for(int j = 0; j < graph.length; j++) {
				graph[j] = new ArrayList<Character>();
				graph[j].add(conversion[j]);
			}
			String hexConnections = st.nextToken();
			String connections = "";
			for(int j = 0; j < hexConnections.length(); j++) {
				String s1 = Integer.toString(Integer.parseInt(hexConnections.substring(j, j + 1), 16), 2);
				int len = s1.length();
				for(int k = 0; k < 4 - len; k++)
					s1 = "0" + s1;
				connections += s1;
			}
			int characterIndex = 0;
			for(int j = 0; j < graph.length; j++) {
				for(int k = 1; k < n - j; k++) {
					if(connections.charAt(characterIndex) == '1')
						graph[j].add(conversion[j + k]);
					++characterIndex;
				}
				System.out.println(graph[j].toString());
			}
			ArrayList<Set<Character>> connect = new ArrayList<Set<Character>>();
			for(int j = 0; j < graph.length; j++) {
				int lookIndex = -1;
				for(int k = 0; k < connect.size(); k++) {
					boolean didBreak = false;
					for(int l = 0; l < graph[j].size(); l++) {
						if(connect.get(k).contains(graph[j].get(l))) {
							lookIndex = k;
							didBreak = true;
							break;
						}
					}
					if(didBreak)
						break;
				}
				if(lookIndex < 0) {
					connect.add(new TreeSet<Character>());
					lookIndex = connect.size() - 1;
				}
				for(int k = 0; k < graph[j].size(); k++)
					connect.get(lookIndex).add(graph[j].get(k));
			}
			int sumOfSizes = 0;
			for(int j = 0; j < connect.size(); j++)
				sumOfSizes += connect.get(j).size();
			if(sumOfSizes > n) {
				int[] appearances = new int[26];
				for(int j = 0; j < 26; j++)
					for(int k = 0; k < connect.size(); k++)
						if(connect.get(k).contains(conversion[j]))
							++appearances[j];
				for(int j = 0; j < 26; j++) {
					if(appearances[j] > 1) {
						Set<Character> set = new TreeSet<Character>();
						for(int k = connect.size() - 1; k >= 0; k--) {
							if(connect.get(k).contains(conversion[j])) {
								Collections.addAll(set, connect.get(k).toArray(new Character[0]));
								connect.remove(k);
							}
						}
						connect.add(set);
					}
				}
			}
			int indexContainingA = 0;
			for(int j = 0; j < connect.size(); j++) {
				if(connect.get(j).contains('A')) {
					indexContainingA = j;
					break;
				}
			}
			String ans = "";
			for(char c : connect.get(indexContainingA))
				ans += c;
			System.out.println(connect.size() + " " + ans);
		}
		br.close();
	}
}