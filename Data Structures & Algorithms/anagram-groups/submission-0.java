class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<Integer>> hmap = new HashMap<>();
        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            char[] strCharArray= strs[i].toCharArray();
            Arrays.sort(strCharArray);
            String resString = new String(strCharArray);
            if(hmap.containsKey(resString)){
                ls = hmap.get(resString);
                ls.add(i);
                hmap.put(resString,ls);
            }
            else{
                ls = new ArrayList<>();
                ls.add(i);
                hmap.put(resString,ls);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for(String key:hmap.keySet()){
            List<String> list = new ArrayList<>();
            for(Integer num: hmap.get(key)){
                list.add(strs[num]);
            }
            ans.add(list);
        }
        return ans;
    }
}
