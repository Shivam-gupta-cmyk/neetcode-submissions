class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dictSet = new HashSet<String>(wordDict);
        Boolean[] memo = new Boolean[s.length()];
        return helper(s,0,dictSet,memo);
    }
    public boolean helper(String s,int start, Set<String> dictSet, Boolean[]memo){
        if(start==s.length()) return true;
        if(memo[start]!=null) return memo[start];
        if(s.length()==0) return true;
        for(int end=start+1;end<=s.length();end++){
            String prefix = s.substring(start,end);
            if(dictSet.contains(prefix) && helper(s,end,dictSet,memo)){
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start]=false;
        return memo[start];
    }
}
