class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int si = 0;
        int maxLen = 1;
        for(int i=0;i<n;i++){
            dp[i][i] = true;
        }
        for(int i=0;i<n-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1] = true;
                si = i;
                maxLen = 2;
            }
        }
        for(int len=3;len<=n;len++){
            for(int i=0;i+len<=n;i++){
                int j = i+len-1;
                if(j>=n) break;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j] = true;
                    if(j-i+1 > maxLen){
                        si = i;
                        maxLen =j-i+1;
                    }
                }
            }
        }
        return s.substring(si,si+maxLen);
    }
}
