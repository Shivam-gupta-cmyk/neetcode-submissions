class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (hmap.containsKey(target - val)) {
                return new int[] { hmap.get(target - val), i };
            } else {
                hmap.put(nums[i], i);
            }
        }
        return new int[2];
    }
}
