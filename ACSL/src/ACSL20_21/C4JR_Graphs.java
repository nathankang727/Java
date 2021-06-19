package ACSL20_21;
import java.io.*;
public class C4JR_Graphs {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int choice = Integer.parseInt(br.readLine());
		String edges = br.readLine();
		System.out.println(findCharacteristic(choice, edges));
		br.close();
	}
	public static int findCharacteristic(int choice, String edges) {
		String[] e = edges.split(" ");
		if(choice == 1) {
			int sum = 0;
			for(int i = 1; i <= 9; i++)
				if(contains(e, String.valueOf(i) + String.valueOf(i)))
					++sum;
			for(int i = 1; i <= 9; i++)
				for(int j = i + 1; j <= 9; j++)
					if(contains(e, String.valueOf(i) + String.valueOf(j)) && contains(e, String.valueOf(j) + String.valueOf(i)))
						++sum;
			return sum;
		}
		else if(choice == 2) {
			int sum = 0;
			int max = 0;
			int maxIndex = 1;
			int[] eOnV = new int[10];
			for(int i = 0; i < e.length; i++)
				++eOnV[Integer.parseInt(e[i].substring(0, 1))];
			for(int i = 1; i <= 9; i++) {
				if(eOnV[i] > max) {
					max = eOnV[i];
					maxIndex = i;
				}
			}
			for(int i = 0; i < e.length; i++)
				if(Integer.parseInt(e[i].substring(0, 1)) == maxIndex)
					sum += Integer.parseInt(e[i]);
			return sum;
		}
		else {
			int count = 0;
			for(int i = 1; i <= 9; i++)
				for(int j = 1; j <= 9; j++)
					for(int k = 1; k <= 9; k++)
						if(contains(e, String.valueOf(i) + String.valueOf(j)) && contains(e, String.valueOf(j) + String.valueOf(k)))
							++count;
			return count;
		}
	}
	public static boolean contains(String[] e, String s) {
		for(int i = 0; i < e.length; i++)
			if(e[i].equals(s))
				return true;
		return false;
	}
}
