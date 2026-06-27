class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> hmap = new HashMap<>();
        for(String str:strs){
            int[] charArray = new int[26];
            for(char ch: str.toCharArray()){
                charArray[ch-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for(int i=0;i<26;i++){
                if(charArray[i]>0){
                    sb.append((char)('a'+i)).append(charArray[i]);
                }
            }
            if(hmap.containsKey(sb.toString())){
                List<String> ls = hmap.get(sb.toString());
                ls.add(str);
                hmap.put(sb.toString(),ls);
            }
            else{
                List<String> ls = new ArrayList<>();
                ls.add(str);
                hmap.put(sb.toString(), ls);
            }
        }
        List<List<String>> res = new ArrayList<>();
        for(String key:hmap.keySet()){
            res.add(hmap.get(key));
        }
        return res;
    }
}
