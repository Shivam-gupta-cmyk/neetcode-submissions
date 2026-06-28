class Solution {

    public boolean checkBox(char[][] board, int startRow, int startCol){
        Set<Character> hset = new HashSet<>();
        for(int i= startRow;i<startRow+3;i++){
            for(int j= startCol;j<startCol+3;j++){
                if(board[i][j]=='.') continue;
                if(hset.contains(board[i][j])) return false;
                hset.add(board[i][j]);
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // row check
        for(int i=0;i<board.length;i++){
            Set<Character> hset = new HashSet<>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                if(hset.contains(board[i][j])) return false;
                hset.add(board[i][j]);
            }
        }
        // col check
        for(int i=0;i<board[0].length;i++){
            Set<Character> hset = new HashSet<>();
            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.') continue;
                if(hset.contains(board[j][i])) return false;
                hset.add(board[j][i]);
            }
        }
        // box check
        for(int i=0;i<board.length;i+=3){
            for(int j=0;j<board[0].length;j+=3){
                if(!checkBox(board,i,j)) return false;
            }
        }
        return true;
    }
}
