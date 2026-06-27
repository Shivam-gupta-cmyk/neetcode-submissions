class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(hmap.containsKey(target-nums[i])){
                return new int[]{hmap.get(target-nums[i]),i};
            }
            else{
                hmap.put(nums[i],hmap.getOrDefault(nums[i],i));
            }
        }
        return null;
    }
}
