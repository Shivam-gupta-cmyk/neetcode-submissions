class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> hmap = new HashMap<>();
        int currLength = 0;
        int ans = 0;
        int currIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (!hmap.containsKey(s.charAt(i))) {
                currLength++;
            } else {
                if (hmap.get(s.charAt(i)) < currIndex) {
                    currLength++;
                } else {
                    currIndex = hmap.get(s.charAt(i));
                    currLength = i - currIndex;
                }
            }
            ans = Math.max(ans, currLength);
            hmap.put(s.charAt(i), i);
        }
        return ans;
    }
}
