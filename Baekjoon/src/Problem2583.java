import java.io.*;
import java.util.*;
public class Problem2583 {
	static BufferedReader br;
    static int[][] map;
    static Queue<Integer> q;
    static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, 1, -1};
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
		map = new int[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())];
		int k = Integer.parseInt(st.nextToken()); 
		q = new LinkedList<Integer>();
		for(int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int startY = Integer.parseInt(st.nextToken());
			int startX = Integer.parseInt(st.nextToken());
			int endY = Integer.parseInt(st.nextToken());
			int endX = Integer.parseInt(st.nextToken());
			for(int r = startX; r < endX; r++)
				for(int c = startY; c < endY; c++)
					map[r][c] = 1;
		}
	}
	private static void solve() {
		ArrayList<Integer> n = new ArrayList<Integer>();
        for(int i = 0; i < map.length; i++)
        	for(int j = 0; j < map[0].length; j++)
        		if(map[i][j] == 0)
        			n.add(bfs(i, j));
        System.out.println(n.size());
        Collections.sort(n);
        for(int i = 0; i < n.size(); i++) {
        	if(n.get(i) == 0)
        		System.out.print("1 ");
        	else
        		System.out.print(n.get(i) + " ");
        }
	}
	private static int bfs(int r, int c) {
    	q.add(r);
    	q.add(c);
    	int count = 0;
    	while(!q.isEmpty()) {
    		int x = q.poll();
    		int y = q.poll();
    		for(int i = 0; i < 4; i++) {
    			int nX = x + dx[i];
    			int nY = y + dy[i];
    			if(nX < 0 || nY < 0 || nX >= map.length || nY >= map[0].length)
    				continue;
    			if(map[nX][nY] == 1)
    				continue;
    			q.add(nX);
    			q.add(nY);
    			++count;
    			map[nX][nY] = 1;
    		}
    	}
    	return count;
    }
}
