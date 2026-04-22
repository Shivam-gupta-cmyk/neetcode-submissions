class Solution {
    int[] parent;
    int[] rank;
    class Edge implements Comparable<Edge>{
        int src;
        int dest;
        int weight;
        Edge(int src, int dest, int weight){
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge other){
            return this.weight-other.weight;
        }
    }
    public int find(int x){
        if(parent[x]!=x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public boolean union(int a, int b){
        int parentA = find(a);
        int parentB = find(b);
        if(parentA==parentB) return false;
        if(rank[parentA]>rank[parentB]) parent[parentB] = parentA;
        else if(rank[parentA]<rank[parentB]) parent[parentA]=parentB;
        else parent[parentB] = parentA;rank[parentA]++;
        return true;
    }
    public int minCostConnectPoints(int[][] points) {
        parent = new int[points.length];
        rank = new int[points.length];
        for(int i=0;i<points.length;i++){
            parent[i]=i;
            rank[i]=0;
        }
        List<Edge> ls = new ArrayList<>();
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int weight = Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                ls.add(new Edge(i,j,weight));
            }
        }
        Collections.sort(ls);
        int edgesUsed = 0;
        int cost = 0;
        for(Edge e : ls){
            if(union(e.src,e.dest)){
                if(edgesUsed==points.length-1) break;
                edgesUsed++;
                cost+=e.weight;
            }
        }
        return cost;
    }
}