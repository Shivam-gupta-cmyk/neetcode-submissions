class Solution {
    public int findPivotIndex(int[]nums){
        int low = 0;
        int high = nums.length-1;
        while(low<high){
            int mid= low+(high-low)/2;
            if(nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid;
            }
        }
        return high;
    }

    public int findElement(int low,int high,int[] arr,int target){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target) return mid;
            else if(arr[mid]>target) high=mid-1;
            else low=mid+1;
        }
        return -1;
    }

    public int search(int[] nums, int target) {
        int val = findPivotIndex(nums);
        if(nums[val]==target) return val;
        if(target>nums[nums.length-1]){
            return findElement(0,val-1,nums,target);
        }
        else{
            return findElement(val+1,nums.length-1,nums,target);
        }
    }
}