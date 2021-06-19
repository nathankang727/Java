package ACSL16_17;
import java.util.*;
import java.io.*;
import java.text.*;
public class AllStar2_Panels {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(new File("1617AllStar2.in")));
		DecimalFormat df = new DecimalFormat("0.###");
		for(int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double wallWidth = Double.parseDouble(st.nextToken());
			double wallHeight = Double.parseDouble(st.nextToken());
			double panelWidth = Double.parseDouble(st.nextToken());
			double panelHeight = Double.parseDouble(st.nextToken());
			int panelCount = 0;
			panelCount += (int)(wallWidth / panelWidth);
			double panelUpStart = panelWidth / 2;
			double panelDownStart = panelWidth / 4;
			int panelRow = 0;
			while(wallHeight / 2 - panelHeight / 2 - panelRow * panelHeight >= panelHeight) {
				++panelRow;
				panelCount += (int)((wallWidth - panelUpStart) / panelWidth);
				panelUpStart += panelWidth / 2;
				panelCount += (int)((wallWidth - panelDownStart) / panelWidth);
				panelDownStart += panelWidth / 4;
			}
			System.out.println(df.format(wallWidth * wallHeight - (double)(panelCount) * panelWidth * panelHeight));
		}
		br.close();
	}
}