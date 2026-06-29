class Solution {

    private boolean isAlphaNumeric(char ch){
        if((ch>='A' && ch<='Z') || (ch>='a' && ch<='z') || (ch>='0' && ch<='9')) return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int i=0;
        int j= s.length()-1;
        while(i<j){
            if(isAlphaNumeric(s.charAt(i)) && isAlphaNumeric(s.charAt(j))){
                if((s.charAt(i)+"").equalsIgnoreCase(s.charAt(j)+"")){
                    i++;
                    j--;
                }
                else{
                    return false;
                }
            }
            else if(isAlphaNumeric(s.charAt(i)) && !isAlphaNumeric(s.charAt(j))){
                j--;
            }
            else if(!isAlphaNumeric(s.charAt(i)) && isAlphaNumeric(s.charAt(j))){
                i++;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}
