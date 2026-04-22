class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum =0;
        for(int num:nums){
            totalSum+=num;
        }
        if(totalSum%2!=0) return false;
        Boolean[][]memo = new Boolean[nums.length][totalSum/2+1];
        return helper(nums,0,totalSum/2,memo);
    }

    public boolean helper(int[]nums, int index, int remaining,Boolean[][]memo){
        if(remaining==0) return true;
        if(index>=nums.length || remaining<0) return false;
        if(memo[index][remaining]!=null) return memo[index][remaining];
        boolean val = helper(nums,index+1, remaining - nums[index],memo) || helper(nums,index+1,remaining,memo);
        memo[index][remaining]= val;
        return memo[index][remaining];
    }
}
