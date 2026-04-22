class Solution {
    public String minWindow(String s, String t) {
        int[] charArray = new int[58];
        for (int i = 0; i < t.length(); i++) {
            charArray[t.charAt(i) - 'A']++;
        }
        int i = 0, j = 0, minStart = -1;
        int counter = t.length();
        int ans = Integer.MAX_VALUE;
        while (j < s.length()) {
            if (charArray[s.charAt(j) - 'A'] > 0)
                counter--;
            charArray[s.charAt(j) - 'A']--;
            j++;
            while (counter == 0) {
                if (ans > j - i) {
                    ans = j - i;
                    minStart = i;
                }
                charArray[s.charAt(i) - 'A']++;
                if (charArray[s.charAt(i) - 'A'] > 0)
                    counter++;
                i++;
            }
        }

        return minStart != -1 ? s.substring(minStart, minStart + ans) : "";
    }
}
