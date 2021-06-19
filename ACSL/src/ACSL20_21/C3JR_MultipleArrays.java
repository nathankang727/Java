package ACSL20_21;
import java.io.*;
public class C3JR_MultipleArrays {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a1 = br.readLine();
        String a2 = br.readLine();
        String a3 = br.readLine();
        System.out.println(sumOfLargest(a1, a2, a3));
		br.close();
	}
	public static int sumOfLargest(String a1, String a2, String a3) {
		int sum = 0;
        String[] arr1 = a1.split(" ");
        String[] arr2 = a2.split(" ");
        String[] arr3 = a3.split(" ");
        int maxSize = Math.max(arr1.length, Math.max(arr2.length, arr3.length));
        for(int i = 0; i < maxSize; i++) {
            int n1 = Integer.MIN_VALUE;
            int n2 = Integer.MIN_VALUE;
            int n3 = Integer.MIN_VALUE;
            if(i < arr1.length)
                n1 = Integer.parseInt(arr1[i]);
            if(i < arr2.length)
                n2 = Integer.parseInt(arr2[i]);
            if(i < arr3.length)
                n3 = Integer.parseInt(arr3[i]);
            sum += Math.max(n1, Math.max(n2, n3));
        }
        return sum;
	}
}