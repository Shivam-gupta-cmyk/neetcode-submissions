class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        for(int num:nums){
            sum+=num;
            sum=Math.max(sum,num);
            ans= Math.max(ans,sum);
        }
        return ans;
    }
}
