class Solution {
    public boolean validTree(int n, int[][] edges) {
        // cycle detection
        if (edges.length != n-1) {
            return false;
        }

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(graph, visited, 0);

        for (boolean vis : visited) {
            if(!vis) {
                return false;
            }
        }
        return true;
    }

    public void dfs(List<List<Integer>> graph, boolean[] visited, int node) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                dfs(graph, visited, next);
            }
        }
    }
}

// shortcut 
// A graph with n nodes is a tree ⟺ it has exactly n−1 edges AND is connected.


// to check for cycle explicity

class Solution {
    public boolean validTree(int n, int[][] edges) {
        // build UNDIRECTED adjacency list
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];

        // 1. no cycles?
        if (hasCycle(graph, visited, 0, -1)) return false;

        // 2. connected? (one DFS from 0 must have reached everything)
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, boolean[] visited, int node, int parent) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (next == parent) continue;       // the edge you came in on — not a cycle
            if (visited[next]) return true;     // reached it another way → cycle
            if (hasCycle(graph, visited, next, node)) return true;
        }
        return false;
    }
}
