class Solution {
    public boolean canWaterFlowInBothOceans(int[][]heights,boolean[][]visited,int row,int col,boolean[][]dp,boolean[]oceanTracker){
        // if(dp[row][col]) return true;
        visited[row][col]=true;
        if(row==0 || col==0){
            oceanTracker[0]=true;
        }
        if(row==heights.length-1 || col == heights[0].length-1){
            oceanTracker[1]=true;
        }
        if(oceanTracker[0] && oceanTracker[1]){
            // dp[row][col]=true;
            visited[row][col]=false;
            return true;
        }

        int[]dirRow= {-1,1,0,0};
        int[]dirCol={0,0,-1,1};
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol = col+dirCol[i];
            if(newRow>=0 && newRow<heights.length && newCol>=0 && newCol<heights[0].length && !visited[newRow][newCol] && heights[newRow][newCol]<=heights[row][col]){
                boolean ans = canWaterFlowInBothOceans(heights,visited,newRow,newCol,dp,oceanTracker);
                if(ans){
                    // dp[row][col]=true;
                    visited[row][col]=false;
                    return true;
                }
            }
        }
        visited[row][col]=false;
        return false;
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        boolean[][]visited = new boolean[heights.length][heights[0].length];
        boolean[][]dp = new boolean[heights.length][heights[0].length];
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                boolean[]oceanTracker= new boolean[2];
                boolean res = canWaterFlowInBothOceans(heights,visited,i,j,dp,oceanTracker);
                if(res){
                    List<Integer> ls = new ArrayList<>();
                    ls.add(i);
                    ls.add(j);
                    ans.add(ls);
                }
            }
        }
        return ans;
    }
}
