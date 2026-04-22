class Solution {
     public int coinChange(int[] coins, int amount) {
        Map<Integer,Integer> memo = new HashMap<>();
        return helper(coins, amount, memo);
    }

    private int helper(int[]coins, int remaining, Map<Integer,Integer> memo){
        if(remaining == 0) return 0;
        if(remaining < 0) return -1;

        if(memo.containsKey(remaining)){
            return memo.get(remaining);
        }

        int minCoins = Integer.MAX_VALUE;
        for(int coin: coins){
            int res = helper(coins, remaining - coin, memo);
            if(res!=-1){
                minCoins = Math.min(minCoins, res+1);
            }
        }
        memo.put(remaining,minCoins!=Integer.MAX_VALUE?minCoins:-1);
        return memo.get(remaining);
    }
}
