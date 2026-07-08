class Solution {
    public void fillGrid(int row, int col, int[][]grid, int[][] res, int currLevel){
        int[] dirRow = {-1,1,0,0};
        int[] dirCol = {0,0,1,-1};
        grid[row][col] = 2;
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol = col+dirCol[i];
            if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]==1){
                if(currLevel+1 < res[newRow][newCol]){
                    res[newRow][newCol] = Math.min(currLevel+1, res[newRow][newCol]);
                    fillGrid(newRow,newCol,grid,res,currLevel+1);
                }
            }
        } 
        grid[row][col] = 1;
    }
    public int orangesRotting(int[][] grid) {
        int maxTimeLapsed = 0;
        int[][] res = new int[grid.length][grid[0].length];
        for(int i=0;i<res.length;i++){
            Arrays.fill(res[i], Integer.MAX_VALUE);
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    fillGrid(i,j,grid,res,0);
                    grid[i][j] = 2;
                }
            }
        }
        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[0].length;j++){
                if(grid[i][j] == 1){
                    if(res[i][j] == Integer.MAX_VALUE) return -1;
                    maxTimeLapsed = Math.max(maxTimeLapsed, res[i][j]);
                }
               
            }
        }
        return maxTimeLapsed;
    }
}
