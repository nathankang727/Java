package ACSL14_15;
import java.util.*;
import java.io.*;
public class AllStar1_ACSLBall_Jr {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1415AllStar1.in")));
		for(int i = 0; i < 2; i++) {
			String[] names = new String[8];
			int[] onePoint = new int[8];
			int[] twoPoint = new int[8];
			int[] threePoint = new int[8];
			int sumThreePoint = 0;
			int mostGoals = 0;
			int goalIndex = 0;
			int jetsScore = 0;
			int jetsFirst = 0;
			int jetsFIndex = 0;
			int jetsSecond = -1;
			int jetsSIndex = 0;
			int sharksScore = 0;
			int sharksFirst = 0;
			int sharksFIndex = 0;
			int sharksSecond = -1;
			int sharksSIndex = 0;
			for(int j = 0; j < 8; j++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				names[j] = st.nextToken();
				onePoint[j] = Integer.parseInt(st.nextToken());
				twoPoint[j] = Integer.parseInt(st.nextToken());
				threePoint[j] = Integer.parseInt(st.nextToken());
				sumThreePoint += threePoint[j];
				if(onePoint[j] + twoPoint[j] + threePoint[j] > mostGoals) {
					mostGoals = onePoint[j] + twoPoint[j] + threePoint[j];
					goalIndex = j;
				}
				int score = onePoint[j] + 2 * twoPoint[j] + 3 * threePoint[j];
				if(j < 4) {
					jetsScore += score;
					if(score > jetsFirst) {
						jetsFirst = score;
						jetsFIndex = j;
					}
				}
				else {
					sharksScore += score;
					if(score > sharksFirst) {
						sharksFirst = score;
						sharksFIndex = j;
					}
				}
			}
			for(int j = 0; j < 4; j++) {
				int score1 = onePoint[j] + 2 * twoPoint[j] + 3 * threePoint[j];
				int score2 = onePoint[j + 4] + 2 * twoPoint[j + 4] + 3 * threePoint[j + 4];
				if(score1 < jetsFirst && score1 > jetsSecond) {
					jetsSecond = score1;
					jetsSIndex = j;
				}
				if(score2 < sharksFirst && score2 > sharksSecond) {
					sharksSecond = score2;
					sharksSIndex = j + 4;
				}
			}
			boolean jetsWin = jetsScore > sharksScore;
			System.out.println(sumThreePoint + "\n" + names[goalIndex]);
			System.out.println(jetsFirst > sharksFirst ? names[jetsFIndex] : names[sharksFIndex]);
			if(jetsWin)
				System.out.println(jetsScore + "\n" + names[sharksSIndex]);
			else
				System.out.println(sharksScore + "\n" + names[jetsSIndex]);
		}
		br.close();
	}
}