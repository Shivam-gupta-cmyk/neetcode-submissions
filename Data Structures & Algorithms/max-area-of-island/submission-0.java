class Solution {
    public void iterateOverIsland(int[][]grid, boolean[][]visited,int row,int col,int[] count){
        visited[row][col]=true;
        count[0]++;
        int[]dirRow={-1,1,0,0};
        int[]dirCol={0,0,1,-1};
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol = col+ dirCol[i];
            if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && grid[newRow][newCol]==1 && !visited[newRow][newCol]){
                iterateOverIsland(grid, visited,newRow,newCol,count);
            } 
        }
    }
    public int maxAreaOfIsland(int[][] grid) {        
        int ans =0;
        boolean[][]visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j] && grid[i][j]==1){
                    int[]count = new int[1];
                    iterateOverIsland(grid,visited,i,j,count);
                    ans = Math.max(ans,count[0]);
                }
            }
        }
        return ans;
    }
}
