class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        return Math.max(robHouse(nums,0,nums.length-2),robHouse(nums,1,nums.length-1));
    }

    public int robHouse(int[]nums, int start, int end){
        int[] dp = new int[end-start+2];
        dp[0]=0;
        dp[1]=nums[start];
        for(int i=2;i<dp.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[start+i-1]);
        }
        return dp[dp.length-1];

    }  
}
