import java.io.*;
public class prob17 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob17.in.txt")));
        PrintWriter pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	char[] c = new char[9];
        	for(int j = 0; j < 3; j++) {
        		String s = br.readLine();
        		for(int k = 0; k < 3; k++)
        			c[j * 3 + k] = s.charAt(k);
        	}
        	
        }
        br.close();
        pw.close();
        Check.check("Prob17.out.txt");
	}
	public static int recursion(char[] arr) {
		if(win(arr))
			return 1;
		else if(lose(arr))
			return -1;
		else if(draw(arr))
			return -1;
		return 0;
	}
	public static boolean win(char[] arr) {
		if(arr[0] == 'X' && arr[1] == 'X' && arr[2] == 'X' || arr[3] == 'X' && arr[4] == 'X' && arr[5] == 'X'
				|| arr[6] == 'X' && arr[7] == 'X' && arr[8] == 'X' || arr[0] == 'X' && arr[3] == 'X' && arr[6] == 'X'
				|| arr[1] == 'X' && arr[4] == 'X' && arr[7] == 'X' || arr[2] == 'X' && arr[5] == 'X' && arr[8] == 'X'
				|| arr[0] == 'X' && arr[4] == 'X' && arr[8] == 'X' || arr[2] == 'X' && arr[4] == 'X' && arr[6] == 'X') {
			return true;
		}
		return false;
	}
	public static boolean lose(char[] arr) {
		if(arr[0] == 'O' && arr[1] == 'O' && arr[2] == 'O' || arr[3] == 'O' && arr[4] == 'O' && arr[5] == 'O'
				|| arr[6] == 'O' && arr[7] == 'O' && arr[8] == 'O' || arr[0] == 'O' && arr[3] == 'O' && arr[6] == 'O'
				|| arr[1] == 'O' && arr[4] == 'O' && arr[7] == 'O' || arr[2] == 'O' && arr[5] == 'O' && arr[8] == 'O'
				|| arr[0] == 'O' && arr[4] == 'O' && arr[8] == 'O' || arr[2] == 'O' && arr[4] == 'O' && arr[6] == 'O') {
			return true;
		}
		return false;
	}
	public static boolean draw(char[] arr) {
		if(!win(arr) && !lose(arr) && arr[0] != '*' && arr[1] != '*' && arr[2] != '*' && arr[3] != '*' && arr[4] != '*' && arr[5] != '*' 
				&& arr[6] != '*' && arr[7] != '*' && arr[8] != '*') {
			return true;
		}
		return false;
	}
}