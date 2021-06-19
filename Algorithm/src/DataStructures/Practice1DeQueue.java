package DataStructures;
import java.util.*;
import java.io.*;
public class Practice1DeQueue {
	public static void main(String[] args) throws IOException{
		ArrayDeque<Integer> adq = new ArrayDeque<Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int commands = Integer.parseInt(br.readLine());
		String[] a = new String[commands];
		for(int i = 0; i < commands; i++)
			a[i] += br.readLine();
		for(int i = 0; i < commands; i++) {
			if(a[i].indexOf("push_front") != -1)
				adq.offerFirst(Integer.parseInt(a[i].substring(15)));
			else if(a[i].indexOf("push_back") != -1)
				adq.offerLast(Integer.parseInt(a[i].substring(14)));
			else if(a[i].indexOf("pop_front") != -1) {
				if(adq.size() == 0)
					System.out.println("-1");
				else
					System.out.println(adq.pollFirst());
			}
			else if(a[i].indexOf("pop_back") != -1) {
				if(adq.size() == 0)
					System.out.println("-1");
				else
					System.out.println(adq.pollLast());
			}
			else if(a[i].indexOf("size") != -1)
				System.out.println(adq.size());
			else if(a[i].indexOf("empty") != -1) {
				if(adq.size() == 0)
					System.out.println("1");
				else
					System.out.println("0");
			}
			else if(a[i].indexOf("front") != -1) {
				if(adq.size() == 0)
					System.out.println("-1");
				else
					System.out.println(adq.peekFirst());
			}
			else if(a[i].indexOf("back") != -1) {
				if(adq.size() == 0)
					System.out.println("-1");
				else
					System.out.println(adq.peekLast());
			}
		}
	}
}