class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
         Set<List<Integer>> temp = new HashSet<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        // int i=0;
        // int j = nums.length - 1;
        if (nums.length < 3)
            return res;
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[i] + nums[j] + nums[k] > 0) {
                    k--;
                } else if (nums[i] + nums[j] + nums[k] < 0) {
                    j++;
                } else {
                    List<Integer> ls = new ArrayList<>();
                    ls.add(nums[i]);
                    ls.add(nums[j]);
                    ls.add(nums[k]);
                    temp.add(ls);
                    while (j < k && nums[j + 1] == nums[j]) {
                        j++;
                    }
                    j++;
                    k--;
                }
            }
        }
        for (List<Integer> tempList : temp) {
            res.add(tempList);
        }
        return res;
    }
}
