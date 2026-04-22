class Solution {
    public void dfs(char[][]board, boolean[][]visited,int row,int col,int flag){
        visited[row][col]=true;
        if(flag==0) board[row][col]='X';
        int[]dirRow = {-1,1,0,0};
        int[]dirCol = {0,0,-1,1};
        for(int i=0;i<4;i++){
            int newRow = row+dirRow[i];
            int newCol= col+dirCol[i];
            if(newRow>=0 && newRow<board.length && newCol>=0 && newCol<board[0].length
            && !visited[newRow][newCol] && board[newRow][newCol]=='O'){
                dfs(board,visited,newRow,newCol,flag);
            }
        }
    }
    public void solve(char[][] board) {
        if(board.length<=2 || board[0].length<=2) return ;
        boolean[][]visited = new boolean[board.length][board[0].length];
        for(int i=0;i<board[0].length;i++){
            if(!visited[0][i] && board[0][i]=='O'){
                dfs(board,visited,0,i,1);
            }
        }
        for(int i=0;i<board[0].length;i++){
            if(!visited[board.length-1][i] && board[board.length-1][i]=='O'){
                dfs(board,visited,board.length-1,i,1);
            }
        }
        for(int i=0;i<board.length;i++){
            if(!visited[i][0] && board[i][0]=='O'){
                dfs(board,visited,i,0,1);
            }
        }
        for(int i=0;i<board.length;i++){
            if(!visited[i][board[0].length-1] && board[i][board[0].length-1]=='O'){
                dfs(board,visited,i,board[0].length-1,1);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    dfs(board,visited,i,j,0);
                }
            }
        }}
}
