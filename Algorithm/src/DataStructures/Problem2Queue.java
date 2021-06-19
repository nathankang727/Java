package DataStructures;
import java.util.*;
import java.io.*;
public class Problem2Queue {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		int total = Integer.parseInt(a.substring(0, 1));
		int k = Integer.parseInt(a.substring(2));
		Queue<Integer> q = new LinkedList<Integer>();
		StringBuilder res = new StringBuilder();
		for(int i = 1; i <= total; i++)
			q.offer(i);
		for(int i = 0; i < total - 2; i++) {
			for(int j = 0; j < k - 1; j++) {
				q.offer(q.poll());
			}
			res.append(q.poll() + ", ");
		}
		res.append(q.poll());
		System.out.println("<" + res + ">");
	}
}