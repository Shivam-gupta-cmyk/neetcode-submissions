class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->((a[0]*a[0] + a[1]*a[1])-(b[0]*b[0]+b[1]*b[1])));
        for(int[]point:points){
            pq.add(point);        
        }
        int i=0;
        int[][] ans = new int[k][2];
        while(i<k){
            int[] point = pq.poll();
            ans[i][0] = point[0];
            ans[i][1] = point[1];
            i++;
        }
        return ans;
    }
}
