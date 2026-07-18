class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;

        for (int i = 0; i<grid.length; i++) {
            for (int j = 0; j<grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    callDfs(grid, i, j);
                }
            }
        }

        return count;
    }

    public void callDfs(char[][] grid, int i, int j) {
        if (i<0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '0') {
            return;
        }

        grid[i][j] = '0';
        callDfs(grid, i - 1, j);
        callDfs(grid, i + 1, j);
        callDfs(grid, i, j - 1);
        callDfs(grid, i, j + 1);
    }
}


// iterative dfs
public void callDfsIterative(char[][] grid, int i, int j) {
    Deque<int[]> stack = new ArrayDeque<>();
    stack.push(new int[]{i, j});
    grid[i][j] = '0';
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    while (!stack.isEmpty()) {
        int[] cell = stack.pop();
        for (int[] d : dirs) {
            int r = cell[0] + d[0], c = cell[1] + d[1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
                grid[r][c] = '0';   // still mark when adding
                stack.push(new int[]{r, c});
            }
        }
    }
}

//iterative bfs
public void callBfs(char[][] grid, int i, int j) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{i, j});
    grid[i][j] = '0';
    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};
    while (!queue.isEmpty()) {
        int[] cell = queue.poll();
        for (int[] d : dirs) {
            int r = cell[0] + d[0], c = cell[1] + d[1];
            if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
                grid[r][c] = '0';   // mark when adding, not when polling
                queue.offer(new int[]{r, c});
            }
        }
    }
}
