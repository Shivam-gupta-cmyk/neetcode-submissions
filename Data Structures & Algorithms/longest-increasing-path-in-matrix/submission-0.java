class Solution {
    public int helper(int[][] matrix,int i,int j,int[][]dp){
        if(dp[i][j]!=-1) return dp[i][j]; 
        int[] row= {-1,1,0,0};
        int[] col={0,0,-1,1};
        int maxLength =1;
        for(int k=0;k<4;k++){
            int currRow = i+row[k];
            int currCol = j+col[k];
            if(currRow>=0 && currCol>=0 && currRow<matrix.length && currCol<matrix[0].length && matrix[currRow][currCol]>matrix[i][j]){
                int ans=1+helper(matrix,currRow,currCol,dp);
                maxLength=Math.max(maxLength,ans);
                
            }
        }
        return dp[i][j]=maxLength;
    }
    public int longestIncreasingPath(int[][] matrix) {
        int[][]dp = new int[matrix.length+1][matrix[0].length+1];
        for(int[] arr:dp){
            Arrays.fill(arr,-1);
        }
        int ans = 0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(dp[i][j]==-1){
                    helper(matrix,i,j,dp);
                }
                ans=Math.max(ans,dp[i][j]);
            }
        }
        return ans;
    }
}
