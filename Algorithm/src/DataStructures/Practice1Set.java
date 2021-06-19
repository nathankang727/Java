package DataStructures;
import java.util.*;
import java.io.*;
public class Practice1Set {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		HashSet<Integer> hs = new HashSet<Integer>();
		for(int i = 0; i < n1; i++)
			hs.add(Integer.parseInt(br.readLine()));
		int a = hs.size();
		int n2 = Integer.parseInt(br.readLine());
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < n2; i++)
			q.offer(Integer.parseInt(br.readLine()));
		while(q.size() != 0) {
			hs.add(q.poll());
			if(a != hs.size())
				System.out.println("0");
			else
				System.out.println("1");
		}
	}
}