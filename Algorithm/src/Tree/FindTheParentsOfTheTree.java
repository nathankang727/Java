package Tree;
import java.util.*;
public class FindTheParentsOfTheTree {
	static boolean[] check;
	static int[] c;
	static ArrayList<Integer>[] list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		for(int i = 0; i < a - 1; i++)
			list[i] = new ArrayList<Integer>();
		check = new boolean[a + 1];
		c = new int[a + 1];
		bfs(1);
		for(int i = 2; i <= a; i++)
			System.out.println(c[i]);
		sc.close();
	}
	public static void bfs(int n) {
		boolean[] check = new boolean[n];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		check[n] = true;
		while(!q.isEmpty()) {
			int x = q.remove();
			for(int y: list[x]) {
				if(!check[y]) {
					check[y] = true;
					c[y] = x;
					q.add(x);
				}
			}
		}
	}
}