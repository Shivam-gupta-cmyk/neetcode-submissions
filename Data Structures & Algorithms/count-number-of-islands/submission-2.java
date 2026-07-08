class Solution {

    public void dfs(int row, int col, char[][]grid){
        grid[row][col] = 'a';
        int[] dirRow = {-1,1,0,0};
        int[] dirCol = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol = col+dirCol[i];
            if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]=='1'){
                dfs(newRow,newCol,grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    dfs(i,j,grid);
                    count++;
                }
            }
        }
        return count;
    }
}
