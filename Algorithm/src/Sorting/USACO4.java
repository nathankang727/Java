package Sorting;
import java.util.*;
import java.io.*;
public class USACO4 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("milk2.in"));
	    PrintWriter pw = new PrintWriter(new File("milk2.out"));
	    int numIntervals = sc.nextInt();
	    Interval[] intervals = new Interval[numIntervals];
	    for(int i = 0; i < numIntervals; i++)
	    	intervals[i] = new Interval(sc.nextInt(), sc.nextInt());
	    Arrays.sort(intervals, new Comparator<Interval>() {
	    	@Override
	    	public int compare(Interval o1, Interval o2) {
	    		return o1.getLow() - o2.getLow();
	    	}
	    });
	    int low = intervals[0].getLow();
	    int high = intervals[0].getHigh();
	    int maxInterval = high - low;
	    int maxGap = 0;   
	    for(int i = 1; i < intervals.length; i++) {
	    	Interval a = intervals[i];
	        if(a.getLow() <= high)
	        	high = Math.max(a.getHigh(), high);
	        else {
	        	maxInterval = Math.max(maxInterval, high - low);
	            maxGap = Math.max(maxGap, a.getLow() - high);
	            low = a.getLow();
	            high = a.getHigh();
	        }
	    }
	    pw.println(maxInterval + " " + maxGap);
	    sc.close();
	    pw.close();
	}
	private static class Interval {
		private final int low;
	    private final int high;
	    public Interval(int low, int high) {
	    	this.low = low;
	        this.high = high;
	    }
	    public int getLow() {
	    	return this.low;
	    }
	    public int getHigh() {
	    	return this.high;
	    }    
	    public String toString(){
	    	return low + " " + high;
	    }
	}
}