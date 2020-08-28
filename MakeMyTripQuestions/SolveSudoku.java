class Sudoku
{
    static boolean SolveSudoku(int grid[][])
    {
        int row=-1;
        int col=-1;
        boolean isEmpty=true;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                if(grid[i][j]==0){
                    row=i;
                    col=j;
                    isEmpty=false;
                    break;
                }
            }
            if(!isEmpty)
                break;
        }
        if(isEmpty)
            return true;
        for(int num=1;num<=grid.length;num++){
            if(isSafe(grid,row,col,num)){
                grid[row][col]=num;
                if(SolveSudoku(grid))
                    return true;
                else
                    grid[row][col]=0;
            }
        }
        return false;
    }
    
    static boolean isSafe(int grid[][],int row,int col,int num){
        for(int i=0;i<grid.length;i++)
            if(grid[row][i]==num||grid[i][col]==num)
                return false;
        
        int sqrt=(int)Math.sqrt(grid.length);
        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;
        for(int i=rowStart;i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if(grid[i][j]==num)
                    return false;
            }
        }
        return true;
    }
    
    static void printGrid (int grid[][])
    {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid.length;j++){
                System.out.print(grid[i][j]+" ");
            }
        }
    }
}
