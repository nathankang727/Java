import java.util.*;
import java.io.*;
import java.text.*;
public class prob09 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		DecimalFormat df = new DecimalFormat("0.00");
		double minions = sc.nextInt() * 1.20;
		double cockpitRadius = sc.nextDouble();
		double bodyRadius = sc.nextDouble();
		double bodyHeight = sc.nextDouble();
		double podsLength = sc.nextDouble();
		double podsWidth = sc.nextDouble();
		double podsHeight = sc.nextDouble();
		double cockpit = (4.0 / 3.0) * Math.PI * Math.pow(cockpitRadius, 3) - 2.20 - 4.10;
		double body = bodyHeight * Math.PI * Math.pow(bodyRadius, 2) - 12.10;
		double pods = (2.0 / 3.0) * podsLength * podsWidth * podsHeight;
		System.out.println("Cockpit " + df.format(cockpit));
		System.out.println("Body " + df.format(body));
		System.out.println("Pods " + df.format(pods));
		System.out.println("Minions Need " + df.format(minions));
		if(cockpit + body + pods >= minions)
			System.out.println("PLAN ACCEPTED");
		else
			System.out.println("PLAN REJECTED");
		sc.close();
	}
}
