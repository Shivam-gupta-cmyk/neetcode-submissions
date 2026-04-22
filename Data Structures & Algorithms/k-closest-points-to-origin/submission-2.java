class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Integer,List<int[]>> pointsMap = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int[]point:points){
            Integer distance = (int)Math.pow(point[0],2)+(int)Math.pow(point[1],2);
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
            Integer distance = pq.poll();
            int[] point = new int[2];
            List<int[]> ls = pointsMap.get(distance);
            if(ls.size()>1){
                point = ls.remove(ls.size()-1);
                 
            }
            else{
                point = ls.remove(ls.size()-1);
                pointsMap.remove(distance);
            }
            ans[i][0] = point[0];
            ans[i][1] = point[1];
            i++;
        }
        return ans;
    }
}
