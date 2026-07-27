class Solution {

    public void dfs(List<String> path,Map<String,PriorityQueue<String>> adjMapping, String src){
        while(adjMapping.containsKey(src) && !adjMapping.get(src).isEmpty()){
            String destEle = adjMapping.get(src).poll();
            dfs(path,adjMapping,destEle);
        }    
        path.add(src);
    }
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> adjMapping = new HashMap<>();
        for(int i=0;i<tickets.size();i++){
            String src = tickets.get(i).get(0);
            String dest = tickets.get(i).get(1);
            if(!adjMapping.containsKey(src)){
                PriorityQueue<String> srcMapping = new PriorityQueue<>();
                srcMapping.add(dest);
                adjMapping.put(src,srcMapping);
            }
            else{
                adjMapping.get(src).add(dest);
            }
        }
        List<String> path = new ArrayList<>();
        dfs(path, adjMapping, "JFK");
        Collections.reverse(path);
        return path;
    }
}
