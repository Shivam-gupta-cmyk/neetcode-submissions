class Solution {
    public String longestPalindrome(String s) {
         int maxLength= 1;
        int start =0;
        int n = s.length();
        boolean[][]dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=true;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                dp[i][i+1]=true;
                start=i;
                maxLength=2;
            }
        }

        for(int len=3;len<=n;len++){
            for(int i=0;i<=n-len;i++){
                int j =i+len-1;
                if(dp[i+1][j-1] && s.charAt(i)==s.charAt(j)){
                    dp[i][j]=true;
                    if((j-i+1)>maxLength){
                        maxLength = j-i+1;
                        start=i;
                    }
                }
            }
        }
        return s.substring(start,start+maxLength);
    }
}
