package PrimeFactorization;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.BufferedReader;
public class Practice1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader((System.in)));
        int n = Integer.parseInt(br.readLine());
        for (int i = 2; Math.pow(i, 2) <= n; i++) {
            while (n%i == 0) {
                System.out.println(i);
                n /= i;
            }
        }
        if (n > 1)
            System.out.println(n);
    }
}