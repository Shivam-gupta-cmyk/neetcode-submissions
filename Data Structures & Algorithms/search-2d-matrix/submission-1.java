class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int low = 0;
        int high = matrix.length*matrix[0].length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            int midEle = matrix[mid/col][mid%col];
            if(midEle==target) return true;
            else if(midEle>target) high=mid-1;
            else low=mid+1;
        }
        return false;
       
    }
}
