class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int numberOfFleets = 0;
        TreeMap<Integer,Double> tmap = new TreeMap<>((a,b)->b-a);
        for(int i=0;i<position.length;i++){
            double time = (double)(target - position[i])/speed[i];
            tmap.put(position[i],time);
        }
        double maxTime = 0;
        for(Double time:tmap.values()){
            if(time>maxTime){
                numberOfFleets++;
                maxTime = time;
            }
        }
        return numberOfFleets;
    }
}
