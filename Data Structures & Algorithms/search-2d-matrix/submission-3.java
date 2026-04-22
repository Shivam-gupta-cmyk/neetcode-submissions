class Solution {

    public boolean binarySearch(int[][]matrix, int currRow, int low, int high,int target){
        while(low<=high){
            int mid = (low+high)/2;
            if(matrix[currRow][mid]==target) return true;
            else if(matrix[currRow][mid]>target) high=mid-1;
            else low = mid+1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = m-1;
        if(low==high){
            return binarySearch(matrix,0,0,n-1,target);
        }
        while(low<=high){
            int mid = low+(high-low)/2;
            if(matrix[mid][0]==target){
                return true;
            }
            else if(matrix[mid][0]<target){
                if(matrix[mid][n-1]<target){
                    low=mid+1;
                }
                else{
                    return binarySearch(matrix,mid,0,n-1,target);
                }
            }
            else{
                high = mid-1;             
            }
        }
        return false;
    }
}
