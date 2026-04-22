class Solution {
    public int swimInWater(int[][] grid) {
        PriorityQueue<int[]> bfs = new PriorityQueue<>((a,b)->a[0]-b[0]);
        bfs.add(new int[]{grid[0][0],0,0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int[][]dir={{-1,0},{1,0},{0,1},{0,-1}};
        while(!bfs.isEmpty()){
            int[] top = bfs.poll();
            int time = top[0];
            int sr = top[1];
            int sc = top[2];
            if(sr==grid.length-1 && sc==grid[0].length-1){
                return time;
            }
            if(visited[sr][sc]) continue;
            visited[sr][sc]=true;
            for(int[] dirArray:dir){
                int newRow = sr+dirArray[0];
                int newCol = sc+dirArray[1];
                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length && !visited[newRow][newCol]){
                    bfs.offer(new int[]{Math.max(time,grid[newRow][newCol]),newRow,newCol});
                }
            }
        }
        return -1;
    }
}