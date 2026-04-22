class Solution {
    public int maxFrequency(int[] arr){
        int ans = 0;
        for(int num:arr){
            ans = Math.max(ans,num);
        }
        return ans;
    }
    public int characterReplacement(String s, int k) {
        int i = 0;
        int j = 0;
        int ans = 0;
        int[] charArray = new int[26];
        while (j < s.length()) {
            charArray[s.charAt(j) - 'A']++;
            if ((j - i + 1) - maxFrequency(charArray) <= k) {
                j++;
            } else {
                charArray[s.charAt(i) - 'A']--;
                charArray[s.charAt(j) - 'A']--;
                i++;
            }
            ans = Math.max(ans, j - i);
        }
        return ans;
    }
}
