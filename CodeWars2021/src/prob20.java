import java.util.*;
import java.io.*;
public class prob20 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("input.txt")));
		int n = Integer.parseInt(br.readLine());
		Data[] arr = new Data[n];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i] = new Data(Integer.parseInt(st.nextToken()), st.nextToken().toUpperCase().charAt(0));
		}
		Arrays.sort(arr);
		int maxHeight = arr[arr.length - 1].height;
		for(int i = maxHeight + 1; i >= 1; i--) {
			for(int j = 0; j < arr.length; j++) {
				if(arr[j].height + 1 == i)
					System.out.print("~");
				else if(i <= arr[j].height)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		String ans = "";
		for(int i = 0; i < arr.length; i++)
			ans += arr[i].address + "";
		System.out.println(ans);
		br.close();
	}
	static class Data implements Comparable<Data> {
		public int height;
		public char address;
		public int compareTo(Data d) {
			return this.height != d.height ? this.height - d.height : this.address - d.address;
		}
		public Data(int h, char a) {
			this.height = h;
			this.address = a;
		}
	}
}