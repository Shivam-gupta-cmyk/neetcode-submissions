class Solution {
    public boolean dfs(char[][]board, String word, int currRow, int currCol, int currIndex,boolean[][]visited){
        if(currIndex==word.length()-1) return true;
        visited[currRow][currCol] = true;
        int[] dirRow = {-1,1,0,0};
        int[] dirCol = {0,0,1,-1};
        for(int i=0;i<4;i++){
            int newRow = currRow + dirRow[i];
            int newCol = currCol + dirCol[i];
            if(newRow>=0 && newRow<board.length && newCol>=0 && newCol<board[0].length && !visited[newRow][newCol] && board[newRow][newCol]==word.charAt(currIndex+1)){
                if(dfs(board, word, newRow, newCol, currIndex+1, visited)) return true;
            }
        }
        visited[currRow][currCol] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)) if(dfs(board,word,i,j, 0,visited)) return true;
            }
        }
        return false;
    }
}
