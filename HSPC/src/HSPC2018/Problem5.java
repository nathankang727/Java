package HSPC2018;
import java.io.*;
public class Problem5 {
	static int n;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		for(int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(br.readLine());		
		System.out.println(traverse(0) ? "True" : "False");
	}
	public static boolean traverse(int index) {
		if(index >= n || arr[index] == 0)
			return false;
		if(index == n - 1)
			return true;
		for(int i = 1; i <= arr[index]; i++)
			if(traverse(index + i))
				return true;
		return false;
	}
}