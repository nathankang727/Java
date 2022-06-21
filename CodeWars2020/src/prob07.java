import java.util.*;
import java.io.*;
public class prob07 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		while(sc.hasNext()) {
			String color1 = sc.next();
			String color2 = sc.next();
			if(color1.equals(color2))
				System.out.println(color1);
			else if(color1.equals("WHITE"))
				System.out.println("LIGHT " + color2);
			else if(color1.equals("BLACK"))
				System.out.println("DARK " + color2);
			else if(color2.equals("WHITE"))
				System.out.println("LIGHT " + color1);
			else if(color2.equals("BLACK"))
				System.out.println("DARK " + color1);
			else if(color1.equals("RED") && color2.equals("YELLOW") || color2.equals("RED") && color1.equals("YELLOW"))
				System.out.println("ORANGE");
			else if(color1.equals("BLUE") && color2.equals("YELLOW") || color2.equals("BLUE") && color1.equals("YELLOW"))
				System.out.println("GREEN");
			else
				System.out.println("PURPLE");
		}
		sc.close();
	}
}