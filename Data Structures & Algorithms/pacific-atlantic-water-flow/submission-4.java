class Solution {

    int[] dirRow = {-1, 1, 0, 0};
    int[] dirCol = {0, 0, -1, 1};

    public void dfs(int[][] heights, int row, int col, boolean[][] visited) {
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + dirRow[i];
            int newCol = col + dirCol[i];

            if (newRow >= 0 && newRow < heights.length &&
                newCol >= 0 && newCol < heights[0].length &&
                !visited[newRow][newCol] &&
                heights[newRow][newCol] >= heights[row][col]) {

                dfs(heights, newRow, newCol, visited);
            }
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific (top row)
        for (int j = 0; j < n; j++) {
            dfs(heights, 0, j, pacific);
        }

        // Pacific (left column)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, 0, pacific);
        }

        // Atlantic (bottom row)
        for (int j = 0; j < n; j++) {
            dfs(heights, m - 1, j, atlantic);
        }

        // Atlantic (right column)
        for (int i = 0; i < m; i++) {
            dfs(heights, i, n - 1, atlantic);
        }

        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }
}