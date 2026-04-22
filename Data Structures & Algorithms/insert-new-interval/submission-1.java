class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ls = new ArrayList<>();
        int i=0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            ls.add(intervals[i]);
            i++;
        }
        while(i<intervals.length && intervals[i][0]<=newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0],newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1],newInterval[1]);
            i++;
        }
        ls.add(newInterval);
        while(i<intervals.length){
            ls.add(intervals[i]);
            i++;
        }
        int[][] result = new int[ls.size()][2];
        for(i=0;i<ls.size();i++){
            result[i] = ls.get(i);
        }
        return result;
    }
}
