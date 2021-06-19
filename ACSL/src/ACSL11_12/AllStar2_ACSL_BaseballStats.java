package ACSL11_12;
import java.util.*;
import java.io.*;
import java.math.*;
import java.text.*;
public class AllStar2_ACSL_BaseballStats {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1112AllStar2.in")));
		DecimalFormat df = new DecimalFormat("#.000");
		df.setRoundingMode(RoundingMode.HALF_UP);
		for(int i = 0; i < 2; i++) {
			int[] totalPlateAppearances = new int[3];
			int[] officialAtBats = new int[3];
			int[] totalHits = new int[3];
			double[] battingAverage = new double[3];
			int[] totalBases = new int[3];
			double[] sluggingPercentage = new double[3];
			double[] onBasePercentage = new double[3];
			for(int j = 0; j < 3; j++) {
				int[] stats = new int[9];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int k = 0; k < 9; k++)
					stats[k] = Integer.parseInt(st.nextToken());
				totalPlateAppearances[j] = stats[0] + stats[1] + stats[2] + stats[3] + stats[4] + stats[5] + stats[6] + 
						stats[7] + stats[8];
				officialAtBats[j] = stats[0] + stats[1] + stats[2] + stats[3] + stats[4] + stats[5];
				totalHits[j] = stats[1] + stats[2] + stats[3] + stats[4];
				battingAverage[j] = (double)(totalHits[j]) / (double)(officialAtBats[j]);
				totalBases[j] = stats[1] + 2 * stats[2] + 3 * stats[3] + 4 * stats[4];
				sluggingPercentage[j] = (double)(totalBases[j]) / (double)(officialAtBats[j]);
				onBasePercentage[j] = (double)(totalHits[j] + stats[6] + stats[7]) / (double)(totalPlateAppearances[j]);
			}
			double maxBattingAverage = 0;
			int minOfficialAtBats = 1000000;
			double maxSluggingPercentage = 0;
			double maxOnBasePercentage = 0;
			int minTotalBases = 1000000;
			for(int j = 0; j < 3; j++) {
				if(maxBattingAverage < battingAverage[j])
					maxBattingAverage = battingAverage[j];
				if(minOfficialAtBats > officialAtBats[j])
					minOfficialAtBats = officialAtBats[j];
				if(maxSluggingPercentage < sluggingPercentage[j])
					maxSluggingPercentage = sluggingPercentage[j];
				if(maxOnBasePercentage < onBasePercentage[j])
					maxOnBasePercentage = onBasePercentage[j];
				if(minTotalBases > totalBases[j])
					minTotalBases = totalBases[j];
			}
			if(maxBattingAverage == battingAverage[0])
				System.out.print("A, ");
			if(maxBattingAverage == battingAverage[1])
				System.out.print("B, ");
			if(maxBattingAverage == battingAverage[2])
				System.out.print("C, ");
			System.out.print(df.format(maxBattingAverage) + "\n");
			if(minOfficialAtBats == officialAtBats[0])
				System.out.print("A, ");
			if(minOfficialAtBats == officialAtBats[1])
				System.out.print("B, ");
			if(minOfficialAtBats == officialAtBats[2])
				System.out.print("C, ");
			System.out.print(minOfficialAtBats + "\n");
			if(maxSluggingPercentage == sluggingPercentage[0])
				System.out.print("A, ");
			if(maxSluggingPercentage == sluggingPercentage[1])
				System.out.print("B, ");
			if(maxSluggingPercentage == sluggingPercentage[2])
				System.out.print("C, ");
			System.out.print(df.format(maxSluggingPercentage) + "\n");
			if(maxOnBasePercentage == onBasePercentage[0])
				System.out.print("A, ");
			if(maxOnBasePercentage == onBasePercentage[1])
				System.out.print("B, ");
			if(maxOnBasePercentage == onBasePercentage[2])
				System.out.print("C, ");
			System.out.print(df.format(maxOnBasePercentage) + "\n");
			if(minTotalBases == totalBases[0])
				System.out.print("A, ");
			if(minTotalBases == totalBases[1])
				System.out.print("B, ");
			if(minTotalBases == totalBases[2])
				System.out.print("C, ");
			System.out.print(minTotalBases + "\n");
		}
		br.close();
	}
}