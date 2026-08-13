class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        // Impossible
        if (Math.abs(target) > sum) {
            return 0;
        }

        // sum + target must be even
        if ((sum + target) % 2 != 0) {
            return 0;
        }

        int required = (sum + target) / 2;

        int[] dp = new int[required + 1];

        // One way to make sum 0: choose nothing
        dp[0] = 1;

        for (int num : nums) {

            // Go backwards so each number is used only once
            for (int j = required; j >= num; j--) {

                dp[j] += dp[j - num];
            }
        }

        return dp[required];
    }
}
