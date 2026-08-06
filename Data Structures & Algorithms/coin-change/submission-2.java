class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                int val = coins[j];
                if(i-val>=0 && dp[i-val]!=Integer.MAX_VALUE) dp[i] = Math.min(dp[i],1 + dp[i-val]);
            }
        }
        return dp[amount]!=Integer.MAX_VALUE?dp[amount]:-1;
    }
}
