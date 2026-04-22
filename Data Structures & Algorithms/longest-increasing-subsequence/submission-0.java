class Solution {
    public int lengthOfLIS(int[] nums) {
        int[][]memo = new int[nums.length+1][nums.length];
        for(int[] row:memo){
            Arrays.fill(row,-1);
        }
        return helper(nums,-1,0,memo);
    }

    public int helper(int[]nums, int prevIndex, int currIndex,int[][]memo){
        if(currIndex==nums.length) return 0;
        if(memo[prevIndex+1][currIndex]!=-1) return memo[prevIndex+1][currIndex];

        int include = 0;
        if(prevIndex==-1 || nums[currIndex]>nums[prevIndex]){
            include = 1+ helper(nums,currIndex, currIndex+1,memo);
        }
        int exclude = exclude = helper(nums,prevIndex, currIndex+1,memo);
        memo[prevIndex+1][currIndex]=Math.max(include,exclude);
        return memo[prevIndex+1][currIndex];

    }
}
