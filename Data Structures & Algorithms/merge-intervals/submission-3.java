class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1) return intervals;
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int[]> ls = new ArrayList<>();
        int[] current = intervals[0];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>current[1]){
                ls.add(current);
                current = intervals[i];
            }
            else{
                current[0] = Math.min(intervals[i][0],current[0]);
                current[1] = Math.max(intervals[i][1],current[1]);
            }
        }
        ls.add(current);
        int[][] ans = new int[ls.size()][2];
        for(int i=0;i<ls.size();i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }
}
