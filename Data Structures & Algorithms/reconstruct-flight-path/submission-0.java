class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String,PriorityQueue<String>> graph = new HashMap<>();
        for(List<String> ls: tickets){
            String from = ls.get(0);
            String to = ls.get(1);
            graph.putIfAbsent(from, new PriorityQueue<>());
            graph.get(from).offer(to);
        }
        List<String> result = new ArrayList<>();
        dfs(graph,"JFK",result);
        List<String> ans = new ArrayList<>();
        for(int i=result.size()-1;i>=0;i--){
            ans.add(result.get(i));
        }
        return ans;
    }

    void dfs(Map<String,PriorityQueue<String>> graph, String src, List<String> result){
        PriorityQueue<String> destinations = graph.get(src);
        while(destinations!=null && !destinations.isEmpty()){
            dfs(graph,destinations.poll(),result);
        }
        result.add(src);
    }
}