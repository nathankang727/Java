import java.io.*;
public class InLine {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		boolean isBreak = false;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'I') {
				System.out.print(i);
				isBreak = true;
				break;
			}
		}
		if(!isBreak)
			System.out.print(0);
		int prevI = 0;
		int max = 0;
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'I') {
				max = Math.max(max, i - prevI);
				prevI = i + 1;
			}
		}
		System.out.print(" " + max);
		br.close();
	}
}