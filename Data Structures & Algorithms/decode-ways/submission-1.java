class Solution {
    public int numDecodings(String s) {
        if(s.charAt(0) =='0') return 0;
        Set<String> hset = new HashSet<>();
        for(int i=1;i<=26;i++){
            hset.add(i+"");
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            String one = s.substring(i-1,i);
            if(hset.contains(one)){
                dp[i]+=dp[i-1];
            }
            String two = s.substring(i-2,i);
            if(hset.contains(two)){
                dp[i]+=dp[i-2];
            }
        }
        return dp[n];
    }
}
