class Solution {
    public int swimInWater(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[2]-b[2]);
        pq.add(new int[]{0,0,0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int minTime = 0;
        while(!pq.isEmpty()){
            int[] topEle = pq.poll();
            int row = topEle[0];
            int col = topEle[1];
            int currTime = topEle[2];
            if(visited[row][col]) continue;
            visited[row][col] = true;
            minTime = Math.max(minTime,currTime);
            if(row==m-1 && col==n-1) return minTime;
            int ele = grid[row][col];
            int[] dirRow = {-1,1,0,0};
            int[] dirCol = {0,0,1,-1};
            for(int i=0;i<4;i++){
                int newRow = row+dirRow[i];
                int newCol = col+dirCol[i];
                if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length){
                    if(!visited[newRow][newCol]){
                        pq.add(new int[]{newRow,newCol,Math.max(ele,grid[newRow][newCol])});
                    }
                }
            }
        }
        return minTime;
    }
}
