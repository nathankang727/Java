package DataStructures;
import java.util.*;
import java.io.*;
public class Problem1Queue {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> q = new LinkedList<Integer>();
		int a = Integer.parseInt(br.readLine());
		String[] b = new String[a];
		StringBuilder back = new StringBuilder();
		for(int i = 0; i < a; i++)
			b[i] = br.readLine();
		for(int i = 0; i < a; i++) {
			if(b[i].indexOf("push") != -1)
				q.offer(Integer.parseInt(b[i].substring(5)));
			else if(b[i].indexOf("pop") != -1) {
				if(q.size() == 0)
					System.out.println("-1");
				else
					System.out.println(q.poll());
			}
			else if(b[i].indexOf("back") != -1 && q.size() != 0) {
				if(q.size() == 0)
					System.out.println("-1");
				else {
					for(int j = 0; j < q.size(); j++)
						back.append(q.poll());
					//System.out.println(back);
					System.out.println(q.peek());
					back.append(q.poll());
					for(int j = 0; j < back.length(); j++)
						q.offer(Integer.parseInt(back.substring(j, j + 1)));
				}
			}
			else if(b[i].indexOf("front") != -1 && q.size() != 0) {
				if(q.size() == 0)
					System.out.println("-1");
				else
					System.out.println(q.peek());
			}
			else if(b[i].indexOf("size") != -1)
				System.out.println(q.size());
			else if(b[i].indexOf("empty") != -1 && q.size() != 0)
				System.out.println("0");
			else if(b[i].indexOf("empty") != -1 && q.size() == 0)
				System.out.println("1");
			else
				System.out.println("-1");
		}
	}
}