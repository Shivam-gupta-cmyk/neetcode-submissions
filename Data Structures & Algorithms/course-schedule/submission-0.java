class Solution {
     public boolean dfs(List<List<Integer>> adjList, int src, boolean[] visited, boolean[] pathVisited) {
        visited[src] = true;
        pathVisited[src] = true;
        for (int i = 0; i < adjList.get(src).size(); i++) {
            int val = adjList.get(src).get(i);
            if (!visited[val]) {
                boolean ans = dfs(adjList, val, visited, pathVisited);
                if (ans) {
                    return true;
                }
            } else if (pathVisited[val]) {
                return true;
            }

        }
        pathVisited[src] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        List<List<Integer>> ls = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            ls.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int num = prerequisites[i][0];
            List<Integer> res = ls.get(num);
            res.add(prerequisites[i][1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                boolean ans = dfs(ls, i, visited, pathVisited);
                if (ans)
                    return false;
            }
        }
        return true;
    }
}
