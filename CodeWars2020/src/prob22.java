import java.util.*;
import java.io.*;
public class prob22 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		String A = "A BC D EF G A";
		String E = "EF G A BC D E";
		while(sc.hasNext()) {
			String input = sc.next();
			int fret = 0;
			try {
				fret = Integer.parseInt(input);
				char c = sc.next().charAt(0);
				if(c == 'E') {
					char note = E.charAt((++fret % 13));
					while(note == ' ')
						note = E.charAt((++fret % 13));
					System.out.println(note);
				}
				else {
					char note = A.charAt((++fret % 13));
					while(note == ' ')
						note = A.charAt((++fret % 13));
					System.out.println(note);
				}
			}
			catch(Exception e) {
				int indexE = E.indexOf(input);
				int indexA = A.indexOf(input);
				if(input.equals("E"))
					System.out.println(indexE + " E 12 E " + indexA + " A");
				else if(input.equals("A"))
					System.out.println(indexE + " E " + indexA + " A 12 A");
				else
					System.out.println(indexE + " E " + indexA + " A");
			}
		}
		sc.close();
	}
}