class Solution {
    public String longestPalindrome(String s) {
    int n = s.length();
    boolean[][] dp = new boolean[n][n];
    int start = 0, maxLen = 1;

    // L is the length of the substring we are checking
    for (int len = 1; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1; // Ending index

            // Rule 1: Ends must match
            if (s.charAt(i) == s.charAt(j)) {
                // Rule 2: It's a palindrome if length is < 3 OR inner part is true
                if (len <= 3 || dp[i + 1][j - 1]) {
                    dp[i][j] = true;
                    if (len > maxLen) {
                        start = i;
                        maxLen = len;
                    }
                }
            }
        }
    }
    return s.substring(start, start + maxLen);
}
}
