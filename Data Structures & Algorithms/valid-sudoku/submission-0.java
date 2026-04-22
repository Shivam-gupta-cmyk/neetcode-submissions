class Solution {
    public static boolean findValidSudoku(char[][] board, boolean[] visited, int rowIndex, int colIndex) {
        // visited[board]
        for (int i = rowIndex; i < rowIndex + 3; i++) {
            for (int j = colIndex; j < colIndex + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (visited[board[i][j] - '0']) {
                    return false;
                } else {
                    visited[board[i][j] - '0'] = true;
                }
            }
        }
        return true;
    }

    public static boolean isValidSudoku(char[][] board) {
        /**
         * approach1: make a group of 3*3sudoku , validate each one if anyone return
         * false, just return false
         */
        int rowIndex = 0;
        int[] rowArray = new int[board.length / 3];
        for (int i = 0; i < rowArray.length; i++) {
            rowArray[i] = rowIndex;
            rowIndex += 3;
        }
        // check for boxes
        for (int i = 0; i < rowArray.length; i++) {
            for (int j = 0; j < rowArray.length; j++) {
                boolean[] visited = new boolean[10];
                boolean ans = findValidSudoku(board, visited, rowArray[i], rowArray[j]);
                if (!ans)
                    return false;
            }
        }

        // check for row
        for (int i = 0; i < board.length; i++) {
            boolean[] visited = new boolean[10];
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    if (visited[board[i][j] - '0'])
                        return false;
                    else
                        visited[board[i][j] - '0'] = true;
                }
            }
        }

        // check for column
        for (int i = 0; i < board[0].length; i++) {
            boolean[] visited = new boolean[10];
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.') {
                    if (visited[board[j][i] - '0'])
                        return false;
                    else
                        visited[board[j][i] - '0'] = true;
                }
            }
        }
        return true;
    }
}
