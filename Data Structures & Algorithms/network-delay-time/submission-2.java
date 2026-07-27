class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[1]-b[1]);
        List<List<int[]>> ls = new ArrayList<>();
        for(int i=0;i<=n;i++){
            ls.add(new ArrayList<>());
        }
        boolean[] visited = new boolean[n+1];
        for(int i=0;i<times.length;i++){
            int currNode = times[i][0];
            int nextNode = times[i][1];
            int weight = times[i][2];
            ls.get(currNode).add(new int[]{nextNode,weight});
        }
        int minTime = 0;
        pq.add(new int[]{k,0});
        while(pq.size()>0){
            int[] top = pq.poll();
            int currNode = top[0];
            int currTime = top[1];
            if(visited[currNode]) continue;
            visited[currNode] = true;
            minTime = currTime;
            for(int i=0;i<ls.get(currNode).size();i++){
                int nei = ls.get(currNode).get(i)[0];
                int wei = ls.get(currNode).get(i)[1];
                if(!visited[nei]) pq.add(new int[]{nei, currTime+wei});
            }
        }
        for(int i=1;i<=n;i++){
            if(!visited[i]) return -1;
        }
        return minTime;
    }
}
