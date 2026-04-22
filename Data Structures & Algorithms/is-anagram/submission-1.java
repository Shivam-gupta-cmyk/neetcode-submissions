class Solution {
    public boolean isAnagram(String s, String t) {
       if (s.length() != t.length())
            return false;
        int[] charArray = new int[128];
        for (int i = 0; i < s.length(); i++) {
            charArray[(int) s.charAt(i)]++;
        }
        for (int i = 0; i < t.length(); i++) {
            if (charArray[(int) t.charAt(i)] == 0)
                return false;
            charArray[(int) t.charAt(i)]--;
        }
        return true;
    }
}
