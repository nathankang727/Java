import java.util.*;
public class Dijkstra {
	static class Node implements Comparable<Node> {
		int v;
        int d;
        public Node(int vertex, int distance) {
            v = vertex;
            d = distance;
        }
        public int compareTo(Node n) {
            if (this.d <= n.d)
                return -1;
            else
                return 1;
        }
    }
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        boolean[] visited = new boolean[v];
        HashMap<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> q = new PriorityQueue<>();
        map.put(s, new Node(s, 0));
        q.add(new Node(s, 0));
        while (!q.isEmpty()) {
            Node n = q.poll();
            int vertex = n.v;
            int distance = n.d;
            visited[vertex] = true;
            ArrayList<ArrayList<Integer> > adjList = adj.get(vertex);
            for(ArrayList<Integer> adjLink : adjList) {
                if(visited[adjLink.get(0)] == false) {
                    if(!map.containsKey(adjLink.get(0)))
                    	map.put(adjLink.get(0), new Node(vertex, distance + adjLink.get(1)));
                    else {
                        Node sn = map.get(adjLink.get(0));
                        if(distance + adjLink.get(1) < sn.d) {
                            sn.v = vertex;
                            sn.d = distance + adjLink.get(1);
                        }
                    }
                    q.add(new Node(adjLink.get(0), distance + adjLink.get(1)));
                }
            }
        }
        int[] result = new int[v];
        for(int i = 0; i < v; i++)
            result[i] = map.get(i).d;
        return result;
    }
    public static void main(String[] args) {
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
        HashMap<Integer, ArrayList<ArrayList<Integer>>> map = new HashMap<>();
        int v = 6;
        int e = 5;
        int[] x = {0, 0, 1, 2, 4};
        int[] y = {3, 5, 4, 5, 5};
        int[] z = {9, 4, 4, 10, 3};
        for(int i = 0; i < e; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(y[i]);
            edge.add(z[i]);
            ArrayList<ArrayList<Integer> > adjList;
            if(!map.containsKey(x[i]))
                adjList = new ArrayList<>();
            else
                adjList = map.get(x[i]);
            adjList.add(edge);
            map.put(x[i], adjList);
            ArrayList<Integer> edge2 = new ArrayList<>();
            edge2.add(x[i]);
            edge2.add(z[i]);
            ArrayList<ArrayList<Integer>> adjList2;
            if(!map.containsKey(y[i]))
                adjList2 = new ArrayList<>();
            else
                adjList2 = map.get(y[i]);
            adjList2.add(edge2);
            map.put(y[i], adjList2);
        }
        for (int i = 0; i < v; i++) {
            if (map.containsKey(i))
                adj.add(map.get(i));
            else
                adj.add(null);
        }
        int s = 1;
        int[] result = Dijkstra.dijkstra(v, adj, s);
        System.out.println(Arrays.toString(result));
    }
}