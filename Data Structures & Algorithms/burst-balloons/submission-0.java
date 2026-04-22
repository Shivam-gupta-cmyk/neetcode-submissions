class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[nums.length+2];
        arr[0] = arr[n+1] = 1;
        for(int i=0;i<nums.length;i++){
            arr[i+1] = nums[i];
        }
        int[][]dp = new int[n+2][n+2];
        for(int len=1;len<=n;len++){
            for(int l=1;l<=n-len+1;l++){
                int r = l+len-1;
                for(int k=l;k<=r;k++){
                    dp[l][r] = Math.max(dp[l][k-1]+dp[k+1][r]+arr[l-1]*arr[k]*arr[r+1],dp[l][r]);
                }
            }
        }
        return dp[1][n];
    }
}