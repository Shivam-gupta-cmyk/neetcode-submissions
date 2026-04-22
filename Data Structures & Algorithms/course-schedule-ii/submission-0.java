class Solution {
    public boolean hasCycle(List<List<Integer>>adjList,boolean[]visited,boolean[]cycleTracker,int src,Stack<Integer>st){
        if(cycleTracker[src]) return true;
        if(visited[src]) return false;
        visited[src]=true;
        cycleTracker[src]=true;
        for(int i=0;i<adjList.get(src).size();i++){
            int val = adjList.get(src).get(i);
            if(hasCycle(adjList,visited,cycleTracker,val,st)){
                return true;
            }
        }
        st.push(src);
        cycleTracker[src]=false;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjList.add(new ArrayList<>());
        }
        int[] ans = new int[numCourses];
        for (int[] prereq : prerequisites) {
            adjList.get(prereq[1]).add(prereq[0]);
        }
        boolean[]visited = new boolean[numCourses];
        boolean[]recursionStack = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        int count=0;
        for(int i=0;i<adjList.size();i++){
            if(!visited[i]){
                if(hasCycle(adjList,visited,recursionStack,i,st)){
                    return new int[0];
                }
            }
        }
        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }
}
