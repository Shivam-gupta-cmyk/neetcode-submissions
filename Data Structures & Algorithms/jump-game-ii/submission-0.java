class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<=i+nums[i] && j<nums.length;j++){
                dp[j] = Math.min(dp[j],1+dp[i]);
            }
        }
        return dp[nums.length-1];
    }
}
