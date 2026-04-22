class Solution {
    public int[] nextSmallerOnLeft(int[]heights){
        int[] ans = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i]=-1;
            else ans[i]= st.peek();       
            st.push(i);
        }
        return ans;
    }

    public int[] nextSmallerOnRight(int[]heights){
        int[] ans = new int[heights.length];
        Stack<Integer> st = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) ans[i]=heights.length;
            else ans[i]= st.peek();       
            st.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] nsol = nextSmallerOnLeft(heights);
        int[] nsor = nextSmallerOnRight(heights);
        int maxAns = Integer.MIN_VALUE;
        for(int i=0;i<heights.length;i++){
            maxAns = Math.max(maxAns,heights[i]*(nsor[i]-nsol[i]-1));
        }
        return maxAns;
    }
}
