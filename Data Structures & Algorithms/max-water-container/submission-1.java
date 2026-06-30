class Solution {
    public int maxArea(int[] heights) {
        int currArea = Integer.MIN_VALUE;
        int i = 0;
        int j = heights.length-1;
        while(i<j){
            currArea = Math.max(currArea,Math.min(heights[i],heights[j])*(j-i));
            if(heights[i]<heights[j]){
                i++;
            }
            else{
                j--;
            }
        }
        return currArea;
    }
}
