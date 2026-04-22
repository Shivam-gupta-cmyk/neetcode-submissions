class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> hmap = new HashMap<>();
        List<String> ls = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            char[] strCharArray = strs[i].toCharArray();
            Arrays.sort(strCharArray);
            String resString = new String(strCharArray);
            if (hmap.containsKey(resString)) {
                ls = hmap.get(resString);
                ls.add(strs[i]);
                hmap.put(resString, ls);
            } else {
                ls = new ArrayList<>();
                ls.add(strs[i]);
                hmap.put(resString, ls);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : hmap.keySet()) {
            ans.add(hmap.get(key));
        }
        return ans;
    }
}
