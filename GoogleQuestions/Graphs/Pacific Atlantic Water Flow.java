class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pac = new boolean[m][n];
        boolean[][] atl = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pac, i, 0, Integer.MIN_VALUE); // left column
            dfs(heights, atl, i, n-1, Integer.MIN_VALUE); // right col
        }

        for (int j = 0; j < n; j++) {
            dfs(heights, pac, 0, j, Integer.MIN_VALUE); // top row
            dfs(heights, atl, m-1, j, Integer.MIN_VALUE); // bottom row
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i=0;i<m;i++) {
            for (int j=0;j<n;j++) {
                if (pac[i][j] && atl[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    public void dfs(int[][] heights, boolean[][] visited, int i, int j, int prevHeight) {
        if (i<0 || i >= heights.length || j<0 || j >= heights[0].length
        || visited[i][j] || heights[i][j] < prevHeight) {
            return;
        }

        visited[i][j] = true;

        dfs(heights, visited, i-1, j, heights[i][j]);
        dfs(heights, visited, i+1, j, heights[i][j]);
        dfs(heights, visited, i, j-1, heights[i][j]);
        dfs(heights, visited, i, j+1, heights[i][j]);
    }
}


// or for dfs function

public void dfs(int[][] heights, boolean[][] visited, int i, int j) {
    visited[i][j] = true;
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    for (int[] d : dirs) {
        int r = i + d[0], c = j + d[1];
        if (r >= 0 && r < heights.length && c >= 0 && c < heights[0].length
            && !visited[r][c]
            && heights[r][c] >= heights[i][j]) {
            dfs(heights, visited, r, c);
        }
    }
}
