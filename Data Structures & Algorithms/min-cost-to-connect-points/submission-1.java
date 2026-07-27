class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        boolean[] visited = new boolean[points.length];
        int visitedCount = 0;
        int sum = 0;
        while(pq.size()>0 && visitedCount<n){
            int[] topEle = pq.poll();
            int pointIndex = topEle[0];
            int currDistance = topEle[1];
            if(visited[pointIndex]) continue;
            visited[pointIndex] = true;
            sum+=currDistance;
            for(int i=0;i<points.length;i++){
                int[] point = points[i];
                if(!visited[i]){
                    int manhattanDistance = Math.abs(point[0]-points[pointIndex][0])+
                     Math.abs(point[1]-points[pointIndex][1]);
                     pq.add(new int[]{i, manhattanDistance});
                }
            }
        }
        return sum;
    }
}
