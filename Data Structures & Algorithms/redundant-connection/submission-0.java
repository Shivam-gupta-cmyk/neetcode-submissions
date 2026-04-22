class Solution {

    public class DisjointSet{
        int[] parent;
        int[] rank;
        DisjointSet(int size){
            parent= new int[size];
            rank = new int[size];
            for(int i=0;i<size;i++){
                parent[i]=i;
                rank[i]=0;
            }
        }
        public int findParent(int node){
            if(parent[node]!=node){
                parent[node]=findParent(parent[node]);
            }
            return parent[node];
        }
        public void union(int node1, int node2){
            int parent1= parent[node1];
            int parent2 = parent[node2];
            if(parent1==parent2) return;
            if(rank[parent1]>rank[parent2]){
                parent[parent2]=parent1;
            }
            else if(rank[parent1]<rank[parent2]){
                parent[parent1]=parent2;
            }
            else{
                parent[parent2]=parent1;
                rank[parent1]++;
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DisjointSet ds = new DisjointSet(edges.length+1);
        int[]edge = new int[]{-1};
        for(int i=0;i<edges.length;i++){
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            if(ds.findParent(node1)==ds.findParent(node2)) edge= edges[i];
            else ds.union(node1,node2);
        }
        return edge;
    }
}
