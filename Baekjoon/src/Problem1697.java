import java.util.*;
import java.io.*;
public class Problem1697 {
	static int start, end, n[];
	static Queue<Integer> q;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		n = new int[100001];
		q = new LinkedList<Integer>();
		if(start == end)
    		System.out.println("0");
    	else {
    		bfs();
    		System.out.println(n[end]);
    	}
		br.close();
	}
    private static void bfs() {
    	q.add(start);
    	while(!q.isEmpty()) {
    		int parent = q.poll();
    		int prev = n[parent];
    		int n1 = parent + 1;
    		int n2 = parent - 1;
    		int n3 = parent * 2;
    		if(n1 >= 0 && n1 <= 100000 && n[n1] == 0 && n1 != start) {
    			q.add(n1);
    			n[n1] = prev + 1;
    		}
    		if(n2 >= 0 && n2 <= 100000 && n[n2] == 0 && n2 != start) {
    			q.add(n2);
    			n[n2] = prev + 1;
    		}
    		if(n3 >= 0 && n3 <= 100000 && n[n3] == 0 && n3 != start) {
    			q.add(n3);
    			n[n3] = prev + 1;
    		}
    		if(n1 == end || n2 == end || n3 == end)
    			break;
    	}
    }
}