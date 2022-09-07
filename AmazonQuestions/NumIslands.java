class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length;
        if(n==0)
            return 0;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1'){
                    numIslandUtil(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
    void numIslandUtil(int i, int j, char[][] grid){
        if(i<0||i>=grid.length||j<0||j>=grid[0].length||grid[i][j]=='0')
            return;
        grid[i][j]='0';
        numIslandUtil(i,j+1,grid);
        numIslandUtil(i,j-1,grid);
        numIslandUtil(i+1,j,grid);
        numIslandUtil(i-1,j,grid);
    }
}
