package GraphTheory;
import java.util.*;
public class CatchThatCow {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.close();
	}
	public static int bfs(int N, int K, int[] Min) {
        int nextN = N;
        int[] status = new int[3];
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(nextN);
        Min[nextN] = 0;
        while(!q.isEmpty() && nextN != K) {
        	nextN = q.poll();
        	status[0] = nextN - 1;
        	status[1] = nextN + 1;
        	status[2] = nextN * 2;
        	for(int i = 0; i < 3; i++) {
        		if(status[i] >= 0 && status[i] <= 100000) {
        			if(Min[status[i]] == -1) {
        				q.add(status[i]);
        				Min[status[i]] = Min[nextN] + 1;
        			}
        		}
        	}
        }
        return Min[K];
    }
}