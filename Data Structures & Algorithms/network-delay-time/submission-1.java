class Solution {

    private class Pair{
        int node;
        int cost;
        Pair(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adjList = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adjList.add(new ArrayList<>());
        }
        for(int[] time: times){
            int source = time[0];
            int target = time[1];
            int cost = time[2];
            adjList.get(source).add(new Pair(target,cost));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> a.cost - b.cost);
        int[] minCost = new int[n+1];
        Arrays.fill(minCost,Integer.MAX_VALUE);
        pq.offer(new Pair(k, 0));
        minCost[k] = 0;
        while(pq.size()>0){
            Pair topNode = pq.poll();
            int srcNode = topNode.node;
            int currCost = topNode.cost;
            if(currCost>minCost[srcNode]) continue;
            for(int i=0;i<adjList.get(srcNode).size();i++){
                Pair nextPair = adjList.get(srcNode).get(i);
                int nextNode = nextPair.node;
                int nodeCost = nextPair.cost;
                int nextNodeCost = currCost+nodeCost;
                if(minCost[nextNode]>nextNodeCost){
                    minCost[nextNode] = nextNodeCost;
                    pq.offer(new Pair(nextNode,nextNodeCost));
                }
                else continue;

            }
        }
        int ans = 0;
        for(int i=1;i<minCost.length;i++){
            if(minCost[i]==Integer.MAX_VALUE) return -1;
            ans = Math.max(ans,minCost[i]);
        }
        return ans;
    }
}