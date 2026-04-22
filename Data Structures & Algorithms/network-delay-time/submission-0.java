class Solution {

    public class Pair implements Comparable<Pair>{
        int node;
        int weight;
        Pair(int node, int weight){
            this.node = node;
            this.weight= weight;
        }

        public int compareTo(Pair o){
            if(o.weight!=this.weight){
                return Integer.compare(this.weight,o.weight);
            }
            else{
                return Integer.compare(this.node,o.node);
            }
        }

        public boolean equals(Object o){
            if(this==o) return true;
            if(o==null || o.getClass()!= this.getClass()) return false;
            Pair pair = (Pair) o;
            return pair.node==this.node && pair.weight==this.weight;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        // Djikstra algorithm
        List<List<Pair>> res = new ArrayList<>();
        for(int i=0;i<n+1;i++){
            List<Pair> ls = new ArrayList<>();
            res.add(ls);
        }
        for(int i=0;i<times.length;i++){
            int nodeSrc = times[i][0];
            int nodeDest = times[i][1];
            int nodeWeight = times[i][2];
            res.get(nodeSrc).add(new Pair(nodeDest,nodeWeight));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.offer(new Pair(k,0));
        int[] arr = new int[n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[k]=0;
        while(!pq.isEmpty()){
            Pair topEle = pq.poll();
            int topNode = topEle.node;
            int topNodeWeight = topEle.weight;
            if(topNodeWeight>arr[topNode]) continue;
            for(int i=0;i<res.get(topNode).size();i++){
                Pair newPair = res.get(topNode).get(i);
                if(arr[topNode]+newPair.weight<arr[newPair.node]){
                    arr[newPair.node]=arr[topNode]+newPair.weight;
                    pq.offer(new Pair(newPair.node,arr[newPair.node]));
                }
            }
        }
        int maxAns = 0;
        for(int i=1;i<=n;i++){
            if(arr[i]==Integer.MAX_VALUE) return -1;
            maxAns = Math.max(maxAns,arr[i]);
        }
        return maxAns;
    }
}