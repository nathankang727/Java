package Factorial;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Practice1 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = Integer.parseInt(br.readLine());
		long res = 1;
		for(int i = number; i >= 1; i--)
			res *= i;
		System.out.println(res);
	}
}