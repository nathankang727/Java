package ACSL15_16;
import java.util.*;
import java.io.*;
public class AllStar1JR_ACSL_Booleo_Jr {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("1516AllStar1Jr.in"));
		for(int i = 0; i < 10; i++) {
			int lvls = sc.nextInt();
			ArrayList<String> bottomLvl = new ArrayList<String>();
			ArrayList<String> topLvl = new ArrayList<String>();
			for(int j = 0; j < lvls; j++)
				bottomLvl.add(" " + sc.next());
			for(int j = 0; j < lvls - 1; j++)
				topLvl.add(sc.next());
			int count = 2;
			boolean isWrong = false;
			while(count <= lvls) {
				for(int j = 0; j < topLvl.size(); j++) {
					if(isWrong)
						break;
					char c = topLvl.get(j).charAt(0);
					char r = topLvl.get(j).charAt(1);
					char c1 = bottomLvl.get(j).charAt(1);
					char c2 = bottomLvl.get(j + 1).charAt(1);
					String type = "";
					if(c == 'A')
						type = "AND";
					else if(c == 'R')
						type = "OR";
					else
						type = "XOR";
					if(c == 'A' && ((r == '1' && (c1 == '0' || c2 == '0')) || (r == '0' && (c1 == '1' && c2 == '1')))) {
						System.out.println(type + " " + count + " " + (j + 1));
						isWrong = true;
					}
					else if(c == 'R' && ((r == '1' && (c1 == '0' && c2 == '0') || (r == '0' && (c1 == '1' || c2 == '1'))))) {
						System.out.println(type + " " + count + " " + (j + 1));
						isWrong = true;
					}
					else if(c == 'X' && ((r == '1' && c1 == c2) || (r == '0' && c1 != c2))) {
						System.out.println(type + " " + count + " " + (j + 1));
						isWrong = true;
					}
				}
				bottomLvl.clear();
				for(int j = 0; j < topLvl.size(); j++) {
					bottomLvl.add(topLvl.get(j));
				}
				topLvl.clear();
				for(int j = 0; j < bottomLvl.size() - 1; j++)
					topLvl.add(sc.next());
				count++;
			}
			if(!(isWrong))
				System.out.println("TRUE");
		}
		sc.close();
	}
}