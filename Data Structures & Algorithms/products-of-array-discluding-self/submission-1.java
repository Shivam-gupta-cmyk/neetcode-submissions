class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixProduct = new int[nums.length];
        int[] suffixProduct = new int[nums.length];
        int prefixSalt = 1;
        int suffixSalt = 1;
        int n = nums.length;
        for(int i=0;i<nums.length;i++){
            prefixProduct[i] = prefixSalt * nums[i];
            prefixSalt = prefixProduct[i];
            suffixProduct[n-1-i] = suffixSalt * nums[n-1-i];
            suffixSalt = suffixProduct[n-1-i];
        }
        int[] ans = new int[n];
        ans[0] = suffixProduct[1];
        ans[n-1] = prefixProduct[n-2];
        for(int i=1;i<n-1;i++){
            ans[i] = prefixProduct[i-1]* suffixProduct[i+1];
        }
        return ans;
    }
}  
