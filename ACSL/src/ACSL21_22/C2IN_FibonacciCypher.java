package ACSL21_22;
import java.io.*;
public class C2IN_FibonacciCypher {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n1 = Integer.parseInt(br.readLine());
		int n2 = Integer.parseInt(br.readLine());
		char c = br.readLine().charAt(0);
		String msg = br.readLine();
		System.out.println(fibCypher(n1, n2, c, msg));
		br.close();
	}
	public static String fibCypher(int num1, int num2, char key, String msg) {
        int[] fibSequence = new int[20];
        fibSequence[0] = num1;
        fibSequence[1] = num2;
        for(int i = 2; i < 20; i++)
        	fibSequence[i] = fibSequence[i - 2] + fibSequence[i - 1];
        String encoded = "";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < msg.length(); i++) {
        	int fibOffset = (int)(alphabet.charAt((fibSequence[i % 20] + alphabet.indexOf(key)) % 26));
        	int offset = 3 * fibOffset + (int)(msg.charAt(i));
        	encoded += offset + " ";
        }
        return encoded.substring(0, encoded.length() - 1);
    }
}