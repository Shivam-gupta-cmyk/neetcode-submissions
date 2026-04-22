class Solution {

    public boolean canComplete(int[] gas, int[] cost, int src){
        int currGasAmount = gas[src];
        for(int i=src;i<src+gas.length;i++){
            currGasAmount -= cost[i%gas.length];
            if(currGasAmount>=0){
                if((i+1)%gas.length==src) return true;
                else currGasAmount+=gas[(i+1)%gas.length];
            }
            else return false;
        }
        return true;
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int startIndex = 0; // index from we need to start to have a closed loop 
        int totalSurplus = 0; // helps in finding whether we have the solution or not;
        int currSurplus = 0; // helps in finding the index;
        for(int i=0;i<gas.length;i++){
            int netGain = gas[i]-cost[i];
            currSurplus += netGain;
            totalSurplus += netGain;
            if(currSurplus<0){
                startIndex = i+1;
                currSurplus = 0;
            }
        }
        return totalSurplus>=0 ? startIndex : -1;
    }
}
