package Sorting;
import java.util.*;
import java.io.*;
public class USACO3 {
	static class Song implements Comparable <Song> {
		String song;
		String ra;
		String a;
		public Song(String n, String s){
			song = n;
			a = s;
			if(a.length() < 4)
				ra = a.toLowerCase();
			if(a.substring(0, 4).equals("The "))
				ra = a.substring(4).toLowerCase();
			else
				ra = a.toLowerCase();
		}
		public int compareTo(Song that){
			if(this.ra.compareTo(that.ra)==0)
				return this.song.compareTo(that.song);
			else
				return this.ra.compareTo(that.ra);
		}
	}
	
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(new File("Whatever2"));
		int n = Integer.parseInt(sc.nextLine());
		for(int i = 0; i < n; i++){
			int num = Integer.parseInt(sc.nextLine());
			Song[]a = new Song[num];
			for(int j = 0; j < num; j++){
				String[]temp = sc.nextLine().split(" - ");
				a[j] = new Song(temp[0], temp[1]);
			}
			Arrays.sort(a);
			for(int j = 0; j < a.length; j++)
				System.out.println(a[j].song + " - " + a[j].a);
		}
		sc.close();
	}
}