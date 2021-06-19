import java.util.*;
import java.io.*;
import java.text.*;
public class prob19 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		StringTokenizer st = new StringTokenizer(br.readLine());
		DecimalFormat df = new DecimalFormat("0.00");
		ArrayList<String> avengers = new ArrayList<String>();
		double[] power = new double[5];
		for(int i = 0; i < 5; i++) {
			String input = st.nextToken();
			if(input.equals("Iron")) {
				st.nextToken();
				avengers.add("Iron Man");
			}
			else if(input.equals("Captain")) {
				st.nextToken();
				avengers.add("Captain America");
			}
			else if(input.equals("Spider")) {
				st.nextToken();
				avengers.add("Spider Man");
			}
			else if(input.equals("Black")) {
				st.nextToken();
				avengers.add("Black Widow");
			}
			else
				avengers.add(input);
			power[i] = Double.parseDouble(st.nextToken().replace(",", ""));
		}
		st.nextToken();
		double thanos = Double.parseDouble(st.nextToken());
		for(int i = 0; i < 5; i++) {
			if(avengers.get(i).equals("Iron Man")) {
				if(avengers.contains("Iron Man"))
					power[i] *= 1.0;
				if(avengers.contains("Hulk"))
					power[i] *= 1.4;
				if(avengers.contains("Spider Man"))
					power[i] *= 1.7;
				if(avengers.contains("Captain America"))
					power[i] *= 1.7;
				if(avengers.contains("Thor"))
					power[i] *= 1.4;
				if(avengers.contains("Black Widow"))
					power[i] *= 1.7;
				if(avengers.contains("Hawkeye"))
					power[i] *= 1.7;
			}
			else if(avengers.get(i).equals("Hulk")) {
				if(avengers.contains("Iron Man"))
					power[i] *= 1.2;
				if(avengers.contains("Hulk"))
					power[i] *= 1.0;
				if(avengers.contains("Spider Man"))
					power[i] *= 1.5;
				if(avengers.contains("Captain America"))
					power[i] *= 1.7;
				if(avengers.contains("Thor"))
					power[i] *= 1.8;
				if(avengers.contains("Black Widow"))
					power[i] *= 1.4;
				if(avengers.contains("Hawkeye"))
					power[i] *= 1.6;
			}
			else if(avengers.get(i).equals("Spider Man")) {
				if(avengers.contains("Iron Man"))
					power[i] *= 2.0;
				if(avengers.contains("Hulk"))
					power[i] *= 1.3;
				if(avengers.contains("Spider Man"))
					power[i] *= 1.0;
				if(avengers.contains("Captain America"))
					power[i] *= 1.7;
				if(avengers.contains("Thor"))
					power[i] *= 1.2;
				if(avengers.contains("Black Widow"))
					power[i] *= 1.3;
				if(avengers.contains("Hawkeye"))
					power[i] *= 1.1;
			}
			else if(avengers.get(i).equals("Captain America")) {
				if(avengers.contains("Iron Man"))
					power[i] *= 1.6;
				if(avengers.contains("Hulk"))
					power[i] *= 1.5;
				if(avengers.contains("Spider Man"))
					power[i] *= 1.7;
				if(avengers.contains("Captain America"))
					power[i] *= 1.0;
				if(avengers.contains("Thor"))
					power[i] *= 1.6;
				if(avengers.contains("Black Widow"))
					power[i] *= 1.8;
				if(avengers.contains("Hawkeye"))
					power[i] *= 1.8;
			}
			else if(avengers.get(i).equals("Thor")) {
				if(avengers.contains("Iron Man"))
					power[i] *= 1.7;
				if(avengers.contains("Hulk"))
					power[i] *= 1.9;
				if(avengers.contains("Spider Man"))
					power[i] *= 1.2;
				if(avengers.contains("Captain America"))
					power[i] *= 1.4;
				if(avengers.contains("Thor"))
					power[i] *= 1.0;
				if(avengers.contains("Black Widow"))
					power[i] *= 1.4;
				if(avengers.contains("Hawkeye"))
					power[i] *= 1.3;
			}
			else if(avengers.get(i).equals("Black Widow")) {
				if(avengers.contains("Iron Man"))
					power[i] *= 1.7;
				if(avengers.contains("Hulk"))
					power[i] *= 1.9;
				if(avengers.contains("Spider Man"))
					power[i] *= 1.4;
				if(avengers.contains("Captain America"))
					power[i] *= 1.3;
				if(avengers.contains("Thor"))
					power[i] *= 1.4;
				if(avengers.contains("Black Widow"))
					power[i] *= 1.0;
				if(avengers.contains("Hawkeye"))
					power[i] *= 2.0;
			}
			else {
				if(avengers.contains("Iron Man"))
					power[i] *= 1.7;
				if(avengers.contains("Hulk"))
					power[i] *= 1.6;
				if(avengers.contains("Spider Man"))
					power[i] *= 1.1;
				if(avengers.contains("Captain America"))
					power[i] *= 1.8;
				if(avengers.contains("Thor"))
					power[i] *= 1.3;
				if(avengers.contains("Black Widow"))
					power[i] *= 2.0;
				if(avengers.contains("Hawkeye"))
					power[i] *= 1.0;
			}
		}
		double sum = 0;
		for(int i = 0; i < 5; i++)
			sum += power[i];
		int finalAvengers = round(df.format(sum));
		int finalThanos = (int)(thanos);
		if(finalAvengers > finalThanos)
			System.out.println("Avengers win! " + finalAvengers + "-" + finalThanos);
		else if(finalAvengers < finalThanos)
			System.out.println("Thanos's Army wins! " + finalThanos + "-" + finalAvengers);
		else
			System.out.println("Draw " + finalAvengers + "-" + finalThanos);
		br.close();
	}
	public static int round(String s) {
		int roundPoint = Integer.parseInt(s.substring(s.indexOf(".") + 1, s.indexOf(".") + 2));
		if(roundPoint < 5)
			return (int)(Double.parseDouble(s));
		else
			return (int)(Double.parseDouble(s) + 1.0);
	}
}