class Solution {

    public boolean checkArraysAreEqual(int[] a1, int[] b1) {
        for (int i = 0; i < 26; i++) {
            if (a1[i] != b1[i])
                return false;
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
     if (s1.length() > s2.length())
            return false;
        int[] charArray1 = new int[26];
        int[] charArray2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            charArray1[s1.charAt(i) - 'a']++;
            charArray2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (checkArraysAreEqual(charArray1, charArray2))
                return true;
            charArray2[s2.charAt(i)-'a']--;
            charArray2[s2.charAt(i + s1.length())-'a']++;
        }
        if (checkArraysAreEqual(charArray1, charArray2))
            return true;
        return false;
    }
}
