class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(b[1]-a[1]));
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int num:nums){
            hmap.put(num,hmap.getOrDefault(num,0)+1);
        }
        for(Integer key:hmap.keySet()){
            pq.add(new int[]{key,hmap.get(key)});
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            ans[i] = pq.remove()[0];
        }
        return ans;
    }
}
