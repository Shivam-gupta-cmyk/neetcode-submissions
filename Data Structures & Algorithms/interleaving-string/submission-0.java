class Solution {
    public boolean helper(String s1, String s2,String s3, int s1Index,int s2Index,Boolean[][]memo){
        if(s1Index==s1.length() && s2Index==s2.length()) return true;
        if(memo[s1Index][s2Index]!=null) return memo[s1Index][s2Index];
        int s3Index = s1Index+s2Index;
        boolean v1= false;
        boolean v2 = false;
        if(s1Index<s1.length() && s1.charAt(s1Index)==s3.charAt(s3Index)){
            v1 = helper(s1,s2,s3,s1Index+1,s2Index,memo);
        }
        if(s2Index<s2.length() && s2.charAt(s2Index)==s3.charAt(s3Index)){
            v2 = helper(s1,s2,s3,s1Index,s2Index+1,memo);
        }
        return memo[s1Index][s2Index] = v1 || v2;
    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length()+s2.length()!=s3.length()) return false;
        Boolean[][] memo= new Boolean[s1.length()+1][s2.length()+1];
        return helper(s1,s2,s3,0,0,memo);
    }
}
