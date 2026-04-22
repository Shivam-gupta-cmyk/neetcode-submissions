class Solution {

    public int findMaxProfit(int[]prices, int index, boolean canBuy){
        if(index>=prices.length) return 0;
        if(canBuy){
            int ans = findMaxProfit(prices, index+1, false)-prices[index] ;//buy
            int ans2 = findMaxProfit(prices,index+1,true);//skip
            return Math.max(ans,ans2);
        }
        else{
            int ans = findMaxProfit(prices,index+2,true) + prices[index]; //sell
            int ans2 = findMaxProfit(prices,index+1,false); //skip
            return Math.max(ans,ans2);

        }
    }
    public int maxProfit(int[] prices) {
        return findMaxProfit(prices,0,true);
    }
}
