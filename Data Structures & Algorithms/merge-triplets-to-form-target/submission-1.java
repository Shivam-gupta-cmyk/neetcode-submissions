class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean isFoundA = false;
        boolean isFoundB = false;
        boolean isFoundC = false;
        for(int[] triplet:triplets){
            if(triplet[0]<=target[0] && triplet[1]<=target[1] && triplet[2]<=target[2]){
                if(triplet[0] == target[0]) isFoundA = true;
                if(triplet[1] == target[1]) isFoundB = true;
                if(triplet[2] == target[2]) isFoundC = true;

                if(isFoundA && isFoundB && isFoundC) return true;
            }
        }
        return false;
    }
}
