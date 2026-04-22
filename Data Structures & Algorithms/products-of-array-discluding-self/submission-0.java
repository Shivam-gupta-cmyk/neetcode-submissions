class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        int prefixProduct = 1;
        int suffixProduct = 1;
        for (int i = 0; i < nums.length - 1; i++) {
            prefixProduct *= nums[i];
            ans[i] = prefixProduct;
        }
        for (int i = nums.length - 1; i > 0; i--) {
            ans[i] = suffixProduct * ans[i - 1];
            suffixProduct *= nums[i];
        }
        ans[0] = suffixProduct;
        return ans;
    }
}  
