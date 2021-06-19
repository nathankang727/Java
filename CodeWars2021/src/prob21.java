import java.util.*;
import java.io.*;
public class prob21 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(new File("input.txt"));
		ArrayList<ArrayList<Character>> grid = new ArrayList<ArrayList<Character>>();
		while(sc.hasNextLine()) {
			grid.add(new ArrayList<Character>());
			String input = sc.nextLine();
			for(int i = 0; i < input.length(); i++)
				grid.get(grid.size() - 1).add(input.charAt(i));
		}
		boolean find = false;
		for(int i = 0; i < grid.size(); i++) {
			for(int j = 0; j < grid.get(i).size() - 3; j++) {
				if(grid.get(i).get(j) == 'M' && grid.get(i).get(j + 1) == 'O' && grid.get(i).get(j + 2) == 'J' && grid.get(i).get(j + 3) == 'O') {
					find = true;
					System.out.println("M: " + j + "," + i);
					System.out.println("O: " + (j + 1) + "," + i);
					System.out.println("J: " + (j + 2) + "," + i);
					System.out.println("O: " + (j + 3) + "," + i);
				}
				else if(grid.get(i).get(j) == 'O' && grid.get(i).get(j + 1) == 'J' && grid.get(i).get(j + 2) == 'O' && grid.get(i).get(j + 3) == 'M') {
					find = true;
					System.out.println("M: " + (j + 3) + "," + i);
					System.out.println("O: " + (j + 2) + "," + i);
					System.out.println("J: " + (j + 1) + "," + i);
					System.out.println("O: " + j + "," + i);
				}
			}
		}
		if(!find) {
			for(int i = 0; i < grid.size() - 3; i++) {
				for(int j = 0; j < grid.get(i).size(); j++) {
					if(grid.get(i).get(j) == 'M' && grid.get(i + 1).get(j) == 'O' && grid.get(i + 2).get(j) == 'J' && grid.get(i + 3).get(j) == 'O') {
						find = true;
						System.out.println("M: " + j + "," + i);
						System.out.println("O: " + j + "," + (i + 1));
						System.out.println("J: " + j + "," + (i + 2));
						System.out.println("O: " + j + "," + (i + 3));
					}
					else if(grid.get(i).get(j) == 'O' && grid.get(i + 1).get(j) == 'J' && grid.get(i + 2).get(j) == 'O' && grid.get(i + 3).get(j) == 'M') {
						find = true;
						System.out.println("M: " + j + "," + (i + 3));
						System.out.println("O: " + j + "," + (i + 2));
						System.out.println("J: " + j + "," + (i + 1));
						System.out.println("O: " + j + "," + i);
					}
				}
			}
		}
		if(!find) {
			for(int i = 0; i < grid.size() - 1; i++) {
				for(int j = 0; j < grid.get(i).size() - 1; j++) {
					if(grid.get(i).get(j) == 'M' && grid.get(i).get(j + 1) == 'O' && grid.get(i + 1).get(j) == 'J' && grid.get(i + 1).get(j + 1) == 'O') {
						find = true;
						System.out.println("M: " + j + "," + i);
						System.out.println("O: " + (j + 1) + "," + i);
						System.out.println("J: " + j + "," + (i + 1));
						System.out.println("O: " + (j + 1) + "," + (i + 1));
					}
				}
			}
		}
		sc.close();
	}
}