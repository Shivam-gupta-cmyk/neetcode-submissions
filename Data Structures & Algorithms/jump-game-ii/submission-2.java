class Solution {
    public int jump(int[] nums) {
        if(nums.length<=1) return 0;
        int jumps = 0;
        int currentEnd = 0;
        int maxDistance = 0;
        for(int i=0;i<nums.length;i++){
            maxDistance = Math.max(maxDistance, i+nums[i]);
            if(i==currentEnd){
                jumps++;
                currentEnd = maxDistance;
                if(currentEnd>=nums.length-1) return jumps;
            }
        }
        return jumps;
    }
}
