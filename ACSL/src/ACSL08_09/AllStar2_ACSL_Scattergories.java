package ACSL08_09;
import java.util.*;
import java.io.*;
public class AllStar2_ACSL_Scattergories {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("0809AllStar2.in"));
		for(int i = 0; i < 2; i++) {
			String[][] answers = new String[5][5];
			for(int r = 0; r < 5; r++)
				for(int c = 0; c < 5; c++)
					answers[r][c] = sc.next();
			boolean[][] gotPoints = {{true, true, true, true, true}, {true, true, true, true, true}, 
					{true, true, true, true, true}, {true, true, true, true, true}, {true, true, true, true, true}};
			for(int c = 0; c < 5; c++) {
				for(int r = 0; r < 5; r++) {
					if(!gotPoints[r][c])
						continue;
					for(int y = 0; y < 5; y++) {
						if(r == y)
							continue;
						if(answers[r][c].equals(answers[y][c])) {
							gotPoints[r][c] = false;
							gotPoints[y][c] = false;
						}
					}
				}
			}
			String[] points = new String[5];
			int[] questionPoints = new int[5];
			for(int j = 0; j < 5; j++) {
				int count = 0;
				for(int k = 0; k < 5; k++)
					if(gotPoints[j][k])
						count++;
				points[j] = String.valueOf(count);
				int count2 = 0;
				for(int k = 0; k < 5; k++)
					if(gotPoints[k][j])
						count2++;
				questionPoints[j] = count2;
			}
			points[0] += "E"; points[1] += "D"; points[2] += "C"; points[3] += "B"; points[4] += "A";
			Arrays.sort(points);
			System.out.println(swap(points[4].substring(1)));
			int max = 0;
			ArrayList<Integer> indexes = new ArrayList<Integer>();
			for(int j = 0; j < 5; j++)
				if(questionPoints[j] > max)
					max = questionPoints[j];
			for(int j = 0; j < 5; j++)
				if(questionPoints[j] == max)
					indexes.add(j);
			for(int j = 0; j < indexes.size(); j++)
				System.out.print((indexes.get(j) + 1) + " ");
			System.out.println();
			String result = "";
			for(int j = 0; j < questionPoints.length; j++)
				if(questionPoints[j] == 0)
					result += (questionPoints[j] + 1) + " ";
			if(result.equals(""))
				System.out.println("NONE");
			else
				System.out.println(result);
			int count = 0;
			for(int j = 0; j < points.length; j++)
				count += Integer.parseInt(points[j].substring(0, 1));
			System.out.println(count);
			String res = "";
			for(int j = points.length - 1; j >= 0; j--)
				res += swap(points[j].substring(1));
			System.out.println(res);
			sc.close();
		}
	}
	public static String swap(String s) {
		if(s.equals("A"))
			return "E";
		else if(s.equals("B"))
			return "D";
		else if(s.equals("C"))
			return "C";
		else if(s.equals("D"))
			return "B";
		else
			return "A";
	}
}