package DataStructures;
import java.util.*;
import java.io.*;
public class Problem6String {
	public static void main(String[] args) throws IOException{
		Scanner br = new Scanner(System.in);
		String a = br.next();
		String b = br.next();
		String c = br.next();
		String d = br.next();
		String e = a + b;
		String f = c + d;
		System.out.println(Long.parseLong(e) + Long.parseLong(f));
		br.close();
	}
}