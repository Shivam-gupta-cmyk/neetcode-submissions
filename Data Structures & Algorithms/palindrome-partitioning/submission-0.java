class Solution {

    List<List<String>> res = new ArrayList<>();
    boolean[][] dp;

    public List<List<String>> partition(String s) {
        int n = s.length();
        dp = new boolean[n][n];

        // build dp table
        for (int len = 1; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = (len <= 2) || dp[i + 1][j - 1];
                }
            }
        }

        backtrack(s, 0, new ArrayList<>());
        return res;
    }

    private void backtrack(String s, int start, List<String> path) {

        if (start == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            if (dp[start][end]) {
                path.add(s.substring(start, end + 1));
                backtrack(s, end + 1, path);
                path.remove(path.size() - 1); // backtrack
            }
        }
    }
}
