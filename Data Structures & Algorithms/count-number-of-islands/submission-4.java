class Solution {

    public void dfs(char[][] grid, int row, int col){
        grid[row][col] = '0';
        int[]dirRow = {-1,1,0,0};
        int[]dirCol = {0,0,1,-1};
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol = col+dirCol[i];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol] == '1'){
                dfs(grid,newRow,newCol);
            }
        }
    }
    public int numIslands(char[][] grid) {
        // brute force
        int numOfIslands = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }
}
