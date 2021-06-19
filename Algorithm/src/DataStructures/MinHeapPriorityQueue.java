package DataStructures;
import java.util.*;
import java.io.*;
public class MinHeapPriorityQueue {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		int commands = Integer.parseInt(br.readLine());
		int[] a = new int[commands];
		for(int i = 0; i < commands; i++)
			a[i] = Integer.parseInt(br.readLine());
		for(int i = 0; i < commands; i++) {
			if(a[i] == 0) {
				if(pq.isEmpty() == true)
					System.out.println("0");
				else
					System.out.println(pq.poll());
			}
			else if(a[i] > 0)
				pq.offer(a[i]);
			else
				continue;
		}
	}
}