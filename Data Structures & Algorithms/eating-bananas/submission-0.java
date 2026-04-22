class Solution {

    public boolean isPossibleToEat(int[]piles,int h, int speed){
        int ans =0;
        for(int pile:piles){
            ans+=Math.ceil(pile/(speed*1.0));
        }
        return ans<=h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int max=Integer.MIN_VALUE;
        for(int pile:piles){
            max=Math.max(max,pile);
        }
        if(h==piles.length) return max;
        int high=max;
        while(low<high){
            int mid=low+(high-low)/2;
            if(!isPossibleToEat(piles,h,mid)){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return high;
    }
}