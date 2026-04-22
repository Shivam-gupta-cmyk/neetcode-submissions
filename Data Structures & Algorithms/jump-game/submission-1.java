class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        Arrays.fill(dp,false);
        if(nums.length==1) return true;
        if(nums[0]!=0) dp[0] = true;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(nums[i]==0) continue;
            if(dp[i]){
                for(int j=i;j<=i+nums[i] && j<nums.length;j++){
                    dp[j] = true;
                }
            }
            
        }
        return dp[nums.length-1];
    }
}
