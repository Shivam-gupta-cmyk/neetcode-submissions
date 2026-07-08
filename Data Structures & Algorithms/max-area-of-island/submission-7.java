class Solution {
    int maxIslandArea = 0;
    
    public void dfs(int row, int col, int[][] grid, int[] area){
        grid[row][col] = -1;
        area[0]++;
        int[] dirRow = {-1,1,0,0};
        int[] dirCol = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol = col+dirCol[i];
            if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]==1){
                dfs(newRow, newCol, grid, area);
            }
        }
    }
    public int maxAreaOfIsland(int[][] grid) {
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    int[] area = new int[1];
                    dfs(i,j,grid,area);
                    maxIslandArea = Math.max(maxIslandArea, area[0]);
                }
            }
        }
        return maxIslandArea;
    }
}
