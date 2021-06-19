package DataStructures;
import java.util.*;
import java.io.*;
public class Problem7String {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		ArrayList<String> res = new ArrayList<String>();
		for(int i = 0; i < a.length(); i++)
			res.add(a.substring(i));
		Collections.sort(res);
		for(int i = 0; i < res.size(); i++)
			System.out.println(res.get(i));
	}
}