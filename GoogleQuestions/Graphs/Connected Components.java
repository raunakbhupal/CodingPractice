class Solution {
    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e :edges) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i=0;i<n;i++) {
            if(!visited[i]) {
                count++;
                dfs(graph, visited, i);
            }
        }
        return count;
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
