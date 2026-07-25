class Solution {
    public boolean compareWords(String a, String b) {
        if (a.length() != b.length())
            return false;
        int flag = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i))
                flag++;
            if (flag == 2)
                return false;
        }
        return flag == 1;
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Queue<String> pq = new ArrayDeque<>();
        pq.add(beginWord);
        visited.add(beginWord);
        int level = 1;
        boolean flag = false;
        while (!pq.isEmpty()) {
            int size = pq.size();
            while (size != 0) {
                String topWord = pq.poll();
                size--;
                if(topWord.equals(endWord)){
                    flag = true;
                    return level;
                }
                for (int i = 0; i < wordList.size(); i++) {
                    if (!visited.contains(wordList.get(i))
                        && compareWords(topWord, wordList.get(i))) {
                            visited.add(wordList.get(i));
                            pq.add(wordList.get(i));
                    }
                }
            }
            level++;
        }
        return !flag ? 0:level;
    }
}
