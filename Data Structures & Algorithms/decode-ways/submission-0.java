class Solution {
     public int numDecodings(String s) {
        Integer[]memo = new Integer[s.length()];
        return helper(s,0,memo);
    }

    private int helper(String s, int index,Integer[]memo){
        if(index==s.length()) return 1;
        if(s.charAt(index)=='0') return 0;

        if(memo[index]!=null) return memo[index];
        int ans = helper(s,index+1,memo);

        if(index+1<s.length()){
            int twoDigit = Integer.parseInt(s.substring(index,index+2));
            if(twoDigit>=10 && twoDigit<=26){
                ans += helper(s,index+2,memo);
            }
        }
        memo[index]=ans;
        return ans;
    }
}
