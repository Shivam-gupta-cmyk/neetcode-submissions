class Solution {

    private static int[][] dirArray = {{-1,0},{0,1},{0,-1},{1,0}};
    public int orangesRotting(int[][] grid) {
        Queue<int[]> bfsQueue = new ArrayDeque<>();
        int freshOranges = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2) bfsQueue.offer(new int[]{i,j});
                else if(grid[i][j] == 1) freshOranges++;
            }
        }
        if(freshOranges==0) return 0;
        int timeLapsed = 0;
        while(!bfsQueue.isEmpty() && freshOranges>0){
            int size = bfsQueue.size();
            for(int i=0;i<size;i++){
                int[] topPair = bfsQueue.poll();
                for(int j=0;j<dirArray.length;j++){
                    int newRow = topPair[0] + dirArray[j][0];
                    int newCol = topPair[1] + dirArray[j][1];
                    if(newRow>=0 && newCol>=0 && newRow<grid.length && newCol<grid[0].length && grid[newRow][newCol]==1){
                        grid[newRow][newCol] = 2;
                        bfsQueue.offer(new int[]{newRow,newCol});
                        freshOranges--;
                    }
                }
            }
            timeLapsed++;
        }
        return freshOranges==0?timeLapsed:-1;
    }
}
