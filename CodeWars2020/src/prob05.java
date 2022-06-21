import java.io.*;
public class prob05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int n = Integer.parseInt(br.readLine());
		if(n != 1 && isPrime(n))
			System.out.println(n + " is PRIME");
		else
			System.out.println(n + " is NOT Prime");
		br.close();
	}
	public static boolean isPrime(int n) {
		for(int i = 2; i <= n / 2; i++)
			if(n % i == 0)
				return false;
		return true;
	}
}