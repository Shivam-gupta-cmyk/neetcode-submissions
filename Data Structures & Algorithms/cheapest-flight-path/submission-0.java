class Solution {
    public class Pair implements Comparable<Pair>{
        int node;
        int price;
        int steps;
        Pair(int node, int price, int steps){
            this.node = node;
            this.price = price;
            this.steps = steps;
        }

        @Override
        public int compareTo(Pair o){
            return Integer.compare(this.price,o.price);
        }

    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> ls = new ArrayList<>();
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            ls.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(src,0,-1));
        int[]minSteps = new int[n];
        Arrays.fill(minSteps,Integer.MAX_VALUE);
        while(!pq.isEmpty()){
            Pair topPair = pq.poll();
            int srcNode = topPair.node;
            int price = topPair.price;
            int steps = topPair.steps;
            if(srcNode==dst){
                return price;
            }
            if(steps>=k || steps>minSteps[srcNode]) continue;
            minSteps[srcNode]=steps;
            for(int i=0;i<ls.get(srcNode).size();i++){
                int[] flightNode = ls.get(srcNode).get(i);
                pq.add(new Pair(flightNode[0],price+flightNode[1],steps+1));
            }
        }
        return -1;
    }
}
