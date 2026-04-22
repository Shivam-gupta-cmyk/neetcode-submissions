class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hmap = new HashMap<>();
        for (int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);

        }
        int[] ans = new int[k];
        List<Integer> ls = new ArrayList<>();
        List<Integer>[] buckets = new List[nums.length + 1];
        for (Integer key : hmap.keySet()) {
            int freq = hmap.get(key);
            if (buckets[freq] == null) {
                ls = new ArrayList<>();
                ls.add(key);
                buckets[freq] = ls;
            } else {
                ls = buckets[freq];
                ls.add(key);
                buckets[freq] = ls;
            }
        }
        int i = nums.length;
        while (i > 0 && k > 0) {
            if (buckets[i] != null) {
                int val = buckets[i].size() - 1;
                while (val >= 0) {
                    ans[ans.length - k] = buckets[i].get(val);
                    val--;
                    k--;
                }
            }
            i--;
        }
        return ans;
    }
}
