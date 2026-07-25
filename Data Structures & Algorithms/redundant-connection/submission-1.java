class Solution {
    int[] parent;
    int[] rank;

    private int find(int[][]edges, int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node] = find(edges,parent[node]);
    }

    private void unionByRank(int u, int v){
        if(parent[u] == parent[v]) return;
        int pu = parent[u];
        int pv = parent[v];
        if(rank[pu]>rank[pv]){
            parent[pv] = pu;
        }
        else if(rank[pu]<rank[pv]){
            parent[pu] = pv;
        }
        else{
            parent[pu] = pv;
            rank[pv]++;
        }
        return;
    }

    public int[] findRedundantConnection(int[][] edges) {
        // can be done through dsu
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        for(int i=0;i<=edges.length;i++){
            parent[i] = i;
        }
        for(int i=0;i<edges.length;i++){
            if(find(edges,edges[i][0])!=find(edges,edges[i][1])){
                unionByRank(edges[i][0],edges[i][1]);
            }
            else{
                return new int[]{edges[i][0],edges[i][1]};
            }
        }
        return null;

    }
}
