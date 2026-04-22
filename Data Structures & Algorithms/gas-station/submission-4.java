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
        for(int i=0;i<gas.length;i++){
            if(canComplete(gas,cost,i)) return i;
        }
        return -1;
    }
}
