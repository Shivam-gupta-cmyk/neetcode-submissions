class Solution {
    public void countRottenOranges(int[][]grid, int[][]visited, int row, int col,int[][] trackCount, int count){
        visited[row][col]=2;
        int[]dirRow={-1,1,0,0};
        int[]dirCol={0,0,1,-1};
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol = col+dirCol[i];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && visited[newRow][newCol]==0 && grid[newRow][newCol]==1){
                if(trackCount[newRow][newCol]==0)trackCount[newRow][newCol]= count+1;
                else trackCount[newRow][newCol]=Math.min(trackCount[newRow][newCol],count+1);

                countRottenOranges(grid,visited,newRow,newCol,trackCount,trackCount[newRow][newCol]);
                visited[newRow][newCol]=0;
            }
        }
    }

    public int orangesRotting(int[][] grid) {
        int[][]visited = new int[grid.length][grid[0].length];
        int[][] trackCount = new int[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                visited = new int[grid.length][grid[0].length];
                
                if(visited[i][j]==0 && grid[i][j]==2){
                    countRottenOranges(grid,visited,i,j,trackCount,0);
                }
            }
        }

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1 && trackCount[i][j]==0){
                    return -1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<trackCount.length;i++){
            for(int j=0;j<trackCount[0].length;j++){
                ans= Math.max(ans,trackCount[i][j]);
            }
        }
        return ans;
    }
}
