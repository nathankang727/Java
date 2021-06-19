import java.io.*;
public class GivingChange {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int pay = (int)(Double.parseDouble(br.readLine()) * 100);
		int cost = (int)(Double.parseDouble(br.readLine()) * 100);
		int change = pay - cost;
		int ans = 0;
		while(change > 0) {
			if(change >= 2000)
				change -= 2000;
			else if(change >= 1000)
				change -= 1000;
			else if(change >= 500)
				change -= 500;
			else if(change >= 100)
				change -= 100;
			else if(change >= 25)
				change -= 25;
			else if(change >= 10)
				change -= 10;
			else if(change >= 5)
				change -= 5;
			else
				change--;
			++ans;
		}
		System.out.println(ans);
		br.close();
	}
}