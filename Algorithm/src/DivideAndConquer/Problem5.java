package DivideAndConquer;
import java.util.*;
import java.io.*;
public class Problem5 {
	private static int n;
	private static int res = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Queue<Integer> a = new LinkedList<Integer>();
		Queue<Integer> b = new LinkedList<Integer>();
		Queue<Integer> c = new LinkedList<Integer>();
		n = Integer.parseInt(br.readLine());
		b.offer(21);
		c.offer(21);
		for(int i = 1; i <= n; i++)
			a.offer(i);
		towers(a, b, c);
	}
	public static void towers(Queue<Integer> a, Queue<Integer> b, Queue<Integer> c) {
		if(c.size() == (n + 1)) {
			System.out.println(res);
			return;
		}
		else {
			if(a.peek() < b.peek()) {
				System.out.println("1 2");
				b.offer(a.poll());
			}
			if(a.peek() < c.peek()) {
				System.out.println("1 3");
				c.offer(a.poll());
			}
			if(b.peek() < a.peek()) {
				System.out.println("2 1");
				a.offer(b.poll());
			}
			if(b.peek() < c.peek()) {
				System.out.println("2 3");
				c.offer(b.poll());
			}
			if(c.peek() < a.peek()) {
				System.out.println("3 1");
				a.offer(c.poll());
			}
			if(c.peek() < b.peek()) {
				System.out.println("3 2");
				b.offer(c.poll());
			}
		}
		towers(a, b, c);
	}
}