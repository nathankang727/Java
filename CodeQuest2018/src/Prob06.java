import java.io.*;
public class Prob06 {
	static PrintWriter pw;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("Prob062.in.txt")));
        pw = new PrintWriter(new File("out.txt"));
        int t = Integer.parseInt(br.readLine()); 
        for(int i = 0; i < t; i++) {
        	String[] s = br.readLine().split(" ");
        	int error = 0;
        	if(s[0].equals("BROKEN"))
        		error += 8;
        	if(s[1].equals("BROKEN"))
        		error += 4;
        	if(s[2].equals("BROKEN"))
        		error += 2;
        	if(s[3].equals("BROKEN"))
        		error += 1;
        	check(error);
        }
        br.close();
        pw.close();
        Check.check("Prob062.out.txt");
	}
	public static void check(int n) {
		if(n == 0)
			pw.println("off off");
		else if(n == 1)
			pw.println("off red");
		else if(n == 2)
			pw.println("off green");
		else if(n == 3)
			pw.println("off blue");
		else if(n == 4)
			pw.println("red off");
		else if(n == 5)
			pw.println("red red");
		else if(n == 6)
			pw.println("red green");
		else if(n == 7)
			pw.println("red blue");
		else if(n == 8)
			pw.println("green off");
		else if(n == 9)
			pw.println("green red");
		else if(n == 10)
			pw.println("green green");
		else if(n == 11)
			pw.println("green blue");
		else if(n == 12)
			pw.println("blue off");
		else if(n == 13)
			pw.println("blue red");
		else if(n == 14)
			pw.println("blue green");
		else
			pw.println("blue blue");
	}
}