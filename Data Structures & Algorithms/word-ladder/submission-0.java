class Solution {
    public class Pair{
        String word;
        int steps;
        Pair(String word, int steps){
            this.word=word;
            this.steps=steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String,Boolean> hmap= new HashMap<>();
        for(String str:wordList){
            hmap.put(str,false);
        }
        if(!hmap.containsKey(endWord)) return 0;
        Queue<Pair> pq = new ArrayDeque<>();
        pq.add(new Pair(beginWord,1));
        while(!pq.isEmpty()){
            Pair topPair = pq.poll();
            String topWord = topPair.word;
            int steps = topPair.steps;
            if(topWord.equals(endWord)) return steps;
            StringBuilder sb = new StringBuilder(topWord);
                for(int i=0;i<topWord.length();i++){
                    char ch = sb.charAt(i);
                    for(int j=0;j<26;j++){
                        sb.setCharAt(i,(char)(97+j));
                        if(sb.toString().equals(endWord)) return steps+1;
                        if(hmap.containsKey(sb.toString()) && !hmap.get(sb.toString())){
                            pq.add(new Pair(sb.toString(),steps+1));
                            hmap.put(sb.toString(),true);
                        }

                    }
                    sb.setCharAt(i,ch);
            }
            
        }
        return 0;
    }
}
