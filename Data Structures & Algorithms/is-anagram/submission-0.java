class Solution {
    public boolean isAnagram(String s, String t) {
         if (s.length() != t.length())
            return false;
        Map<Character, Integer> hmap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            if (!hmap.containsKey(t.charAt(i)) || hmap.get(t.charAt(i)) == 0)
                return false;
            hmap.put(t.charAt(i), hmap.get(t.charAt(i))-1);

        }
        return true;
    }
}
