class Solution {

    public boolean isAlphaNumericCharacter(char ch) {
        if ((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) {
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!isAlphaNumericCharacter(s.charAt(i))) {
                i++;
                continue;
            }
            if (!isAlphaNumericCharacter(s.charAt(j))) {
                j--;
                continue;
            }
            char first = (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') ? (char) (s.charAt(i) + 32) : s.charAt(i);
            char second = (s.charAt(j) >= 'A' && s.charAt(j) <= 'Z') ? (char) (s.charAt(j) + 32) : s.charAt(j);
            if (first != second)
                return false;
            i++;
            j--;
        }
        return true;
    }
}
