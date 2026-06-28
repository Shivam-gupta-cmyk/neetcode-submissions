class Solution {
    private int dfs(int num, Set<Integer> set, Map<Integer, Integer> memo) {

        if (!set.contains(num))
            return 0;

        if (memo.containsKey(num))
            return memo.get(num);

        int length = 1 + dfs(num + 1, set, memo);

        memo.put(num, length);

        return length;
    }

    public int longestConsecutive(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for (int num : nums)
            set.add(num);

        Map<Integer, Integer> memo = new HashMap<>();

        int ans = 0;

        for (int num : set) {
            ans = Math.max(ans, dfs(num, set, memo));
        }

        return ans;
    }
}
