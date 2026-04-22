class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[1]-a[1]);
        Map<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hmap.put(nums[i],hmap.getOrDefault(nums[i],0)+1);
        }
        for(Integer key:hmap.keySet()){
            pq.add(new int[]{key,hmap.get(key)});
        }
        int i=0;
        int[] res = new int[k];
        while(i<k){
            res[i] = pq.remove()[0];
            i++;
        }
        return res;
    }
}
