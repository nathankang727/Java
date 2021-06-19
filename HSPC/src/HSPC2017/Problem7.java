package HSPC2017;
import java.io.*;
public class Problem7 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] a = new String[n];
		for(int i = 0; i < n; i++)
			a[i] = br.readLine();
		String diffArr = "";
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				if(i == j)
					continue;
				int diff = 0;
				for(int k = 0; k < a[i].length(); k++)
					if(a[i].charAt(k) != a[j].charAt(k))
						++diff;
				if(diff < 2)
					diffArr += j + " ";
			}
		}
		boolean b = false;
		for(int i = 0; i < n; i++) {
			if(diffArr.indexOf(String.valueOf(i)) == -1) {
				b = true;
				System.out.println("0");
				break;
			}
		}
		if(!b)
			System.out.println("1");
	}
}