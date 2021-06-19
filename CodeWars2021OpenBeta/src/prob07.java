import java.util.*;
import java.io.*;
public class prob07 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> cubes = new ArrayList<Integer>();
		ArrayList<Integer> dup = new ArrayList<Integer>();
		int ans1 = 0;
		int ans2 = 0;
		int ans3 = 0;
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			int cube = Integer.parseInt(st.nextToken());
			if(cube == 0)
				++ans3;
			if(name.equals("Lonely"))
				++ans1;
			if(cubes.contains(cube) && !dup.contains(cube) && cube != 0) {
				dup.add(cube);
				++ans2;
			}
			cubes.add(cube);
		}
		System.out.println("Lonely Cubes: " + ans1);
		System.out.println("Duplicate Cube Assignments: " + ans2);
		System.out.println("Test Subjects without Cubes: " + ans3);
		br.close();
	}
}