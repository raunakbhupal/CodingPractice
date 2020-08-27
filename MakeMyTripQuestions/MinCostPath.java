import java.util.*;
import java.lang.*;
import java.io.*;

class Node {
    int x, y, dist;
    Node (int x, int y, int d) {
        this.x = x;
        this.y = y;
        this.dist = d;
    }
}
class GFG {
    static int dx[] = {-1, 0, 0, 1};
    static int dy[] = {0, -1, 1, 0};
    static int dist[][];
    static int n;
    static int[][] arr;
    static boolean[][] visited;
	public static void main (String[] args) {
	    Scanner scan = new Scanner(System.in);
	    int t = scan.nextInt();
	    while (t-- > 0) {
	        n = scan.nextInt();
	        dist = new int[n][n];
	        arr = new int[n][n];
	        for (int i = 0; i < n; i++) {
		    for (int j = 0; j < n; j++) {
		       arr[i][j] = scan.nextInt();
		       dist[i][j] = Integer.MAX_VALUE;
		    }
		}
		System.out.println(dijkstra());
	    }
		
	}
	
	private static int dijkstra() {
	    visited = new boolean[n][n];
	    Queue<Node> q = new PriorityQueue<Node>(new Comparator<Node>(){
	        public int compare(Node a, Node b) {
	            return a.dist - b.dist;
	        }
	    });
	    dist[0][0] = arr[0][0];
	    q.add(new Node(0, 0, arr[0][0]));
	    while (!q.isEmpty()) {
	        Node node = (Node)q.remove();
	        if (node.x == (n - 1) && node.y == (n - 1)) return dist[node.x][node.y];
	        if (visited[node.x][node.y])  continue;
	        visited[node.x][node.y] = true;
	        for (int k = 0; k < 4; k++) {
	            int u = node.x + dx[k];
	            int v = node.y + dy[k];
	            if (valid(u, v) &&!visited[u][v]) {
	                if (dist[u][v] > dist[node.x][node.y] + arr[u][v]) {
	                    dist[u][v] = dist[node.x][node.y] + arr[u][v];
	                }
	                q.add(new Node(u, v, dist[u][v]));
	            }
	        }
	    }
	    return - 1;
	}
	private static boolean valid (int u, int v) {
	    return u < n && u >= 0 && v < n && v >= 0;
	}
}
