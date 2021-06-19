package DivideAndConquer;
import java.util.*;
public class Problem6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int[] b = new int[n];
		for(int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		for(int i = 0; i < n; i++)
			b[i] = sc.nextInt();
		int tr = b[b.length - 1];
		ArrayList<Integer> l = new ArrayList<Integer>();
		ArrayList<Integer> r = new ArrayList<Integer>();
		for(int i = 0; i < a.toString().indexOf(String.valueOf(tr)); i++)
			l.add(a[i]);
		for(int i = a.toString().indexOf(String.valueOf(tr)); i < n; i++)
			r.add(a[i]);
		for(int i = 0; i < l.size(); i++)
			System.out.println(l.get(i));
		for(int i = 0; i < r.size(); i++)
			System.out.println(r.get(i));
		sc.close();
	}
}