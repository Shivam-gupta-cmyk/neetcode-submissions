class Solution {
    public int helper(int[]nums,int target,int index){
        if(index==nums.length && target==0) return 1;
        if(index>=nums.length) return 0;
        int ans = helper(nums,target-nums[index],index+1);
        int ans2 = helper(nums,target+nums[index],index+1);
        return ans+ans2;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0);
    }
}
