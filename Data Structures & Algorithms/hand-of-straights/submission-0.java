class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length%groupSize!=0) return false;
        int totalGroups = hand.length%groupSize;
        TreeMap<Integer,Integer> tmap = new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            tmap.put(hand[i],tmap.getOrDefault(hand[i],0)+1);
        } 
        while(!tmap.isEmpty()){
            int firstCard = tmap.firstKey();
            for(int i=0;i<groupSize;i++){
                int currCard = firstCard + i;
                if(tmap.containsKey(currCard)){
                    int value = tmap.get(currCard);
                    if(value>1) tmap.put(currCard, value-1);
                    else tmap.remove(currCard);
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
