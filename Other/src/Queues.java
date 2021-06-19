import java.util.*;
public class Queues {
	public static void main(String[] args) {
		Queue<String> q = new LinkedList<String>();
        q.add("Sam");
        q.add("Justin");
        q.add("Minjun");
        System.out.println(q);
        String s = q.poll();
        System.out.println(s);
        System.out.println(q);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(30);
        pq.add(40);
        pq.add(10);
        pq.add(100);
        pq.add(1);
        System.out.println(pq);
	}
}