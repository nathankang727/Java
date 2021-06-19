import java.io.*;
public class prob03 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s = "";
		if(n == 1)
			s = "one";
		else if(n == 2)
			s = "two";
		else if(n == 3)
			s = "three";
		else if(n == 4)
			s = "four";
		else if(n == 5)
			s = "five";
		else if(n == 6)
			s = "six";
		else if(n == 7)
			s = "seven";
		else if(n == 8)
			s = "eight";
		else if(n == 9)
			s = "nine";
		else
			s = "ten";
		System.out.println("Number " + s + " is alive!");
		br.close();
	}
}