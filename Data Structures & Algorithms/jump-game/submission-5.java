class Solution {
    public boolean canJump(int[] nums) {
        int maxDistance = 0;
        for(int i=0;i<nums.length;i++){
            if(i>maxDistance) return false;
            int currDistance = i+nums[i];
            maxDistance = Math.max(maxDistance,currDistance);
            if(maxDistance>=nums.length-1) return true;
        }
        return false;
    }
}
