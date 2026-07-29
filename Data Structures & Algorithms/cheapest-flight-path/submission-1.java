class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        List<List<int[]>> ls = new ArrayList<>();
        int[][] dist = new int[n][k+1];
        for(int[]arr:dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        for(int i=0;i<n;i++){
            ls.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int srcStation = flights[i][0];
            int destStation = flights[i][1];
            int price = flights[i][2];
            ls.get(srcStation).add(new int[]{destStation, price});
        }
        int cheapestPrice = 0;
        pq.add(new int[]{src,0,-1});
        while(!pq.isEmpty()){
            int[] topEle = pq.poll();
            int srcEle = topEle[0];
            int price = topEle[1];
            int stops = topEle[2];
            if(srcEle == dst) return price;
            if(stops>=k) continue;
            for(int i=0;i<ls.get(srcEle).size();i++){
                int[] nei = ls.get(srcEle).get(i);
                if(price+nei[1] < dist[nei[0]][stops+1]){
                    pq.add(new int[]{nei[0],price+nei[1],stops+1});
                    dist[nei[0]][stops+1] = price + nei[1];
                }
                   
            }
        }
        return -1;
    }
}
