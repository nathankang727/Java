import java.util.*;
import java.io.*;
public class Problem1644 {
	static ArrayList<Integer> primes;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		primes = new ArrayList<Integer>();
		primes.add(0);
		sieveofEratosthenes(n);
		int count = 0;
		for(int i = 1; i < primes.size(); i++) {
			long check = (long)(primes.get(i));
			int index = i - 1;
			while(check < (long)(n) && index > 0) {
				check += (long)(primes.get(index));
				--index;
			}
			if(check == (long)(n)) {
				++count;
			}
		}
		System.out.println(count);
		br.close();
	}
	public static void sieveofEratosthenes(int n) {
		boolean[] isComposite = new boolean[n + 1];
		if(n < 2)
			return;
		for(int i = 2; i <= n; i++) {
			if(isComposite[i])
				continue;
			primes.add(i);
			for(int j = i + i; j <= n; j += i)
				if(j % i == 0)
					isComposite[j] = true;
		}
	}
}