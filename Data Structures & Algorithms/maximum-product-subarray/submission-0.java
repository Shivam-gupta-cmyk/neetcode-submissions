class Solution {
    public int maxProduct(int[] nums) {
         int maxAns = nums[0];
        int minAns = nums[0];
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i]<0){
                int val= maxAns;
                maxAns = minAns;
                minAns = val;
            }
            maxAns=Math.max(maxAns*nums[i],nums[i]);
            minAns = Math.min(minAns*nums[i],nums[i]);
            int ans = Math.max(maxAns,minAns);
            res=Math.max(res,ans);
        }
        return res;
    }
}
