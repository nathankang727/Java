import java.util.*;
import java.io.*;
public class ImportantExam {
    static BufferedReader br;
    static String[][] answers;
    static int[] array;
    static int[] points;
    public static void main(String[] args) {
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            init();
            solve();
            br.close();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    private static void init() throws IOException {
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	answers = new String[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
    	for(int i = 0; i < answers.length; i++)
    		answers[i] = br.readLine().split("");
    	array = new int[answers[0].length];
    	points = new int[answers[0].length];
    	st = new StringTokenizer(br.readLine());
    	for(int i = 0; i < points.length; i++)
    		points[i] = Integer.parseInt(st.nextToken());
    }
    private static void solve() {
        String choices = "ABCDE";
        for(int i = 0; i < answers[0].length; i++) {
        	for(int j = 0; j < 5; j++) {
    			String s = choices.substring(j, j + 1);
    			int count = 0;
        		for(int k = 0; k < answers.length; k++)
        			if(s.equals(answers[k][i]))
        				++count;
        		count *= points[i];
        		if(count > array[i])
        			array[i] = count;
        	}
        }
        int count = 0;
        for(int i = 0; i < array.length; i++)
        	count += array[i];
        System.out.println(count);
    }
}