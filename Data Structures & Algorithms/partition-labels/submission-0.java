class Solution {
    public List<Integer> partitionLabels(String s) {
        Map<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<s.length();i++){
            hmap.put(s.charAt(i),i); // stores last Index
        }
        List<Integer> ls = new ArrayList<>();
        int lastIndex = -1;
        int currLength = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            lastIndex = Math.max(lastIndex,hmap.get(ch));
            currLength++;
            if(i==lastIndex){
                ls.add(currLength);
                currLength = 0;
            }
        }
        return ls;
    }
}
