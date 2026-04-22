class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double,List<int[]>> pointsMap = new HashMap<>();
        PriorityQueue<Double> pq = new PriorityQueue<>();
        for(int[]point:points){
            Double distance = Math.sqrt(Math.pow(point[0],2)+Math.pow(point[1],2));
            pq.add(distance);
            if(pointsMap.containsKey(distance)){
                List<int[]> ls = pointsMap.get(distance);
                ls.add(point);
                pointsMap.put(distance,ls);
            }
            else{
                List<int[]> ls = new ArrayList<>();
                ls.add(point);
                pointsMap.put(distance,ls);
            }
            
        }
        int i=0;
        int[][] ans = new int[k][2];
        while(i<k){
            Double distance = pq.poll();
            List<int[]> ls = pointsMap.get(distance);
            if(ls.size()>1){
                int[] point = ls.remove(ls.size()-1);
                 ans[i][0] = point[0];
            ans[i][1] = point[1];
            }
            else{
                int[] point = ls.remove(ls.size()-1);
                 ans[i][0] = point[0];
            ans[i][1] = point[1];
                pointsMap.remove(distance);
            }
           
            i++;
        }
        return ans;
    }
}
