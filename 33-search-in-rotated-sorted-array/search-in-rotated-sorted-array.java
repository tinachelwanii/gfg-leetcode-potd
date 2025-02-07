class Solution {
    public int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(nums[mid]==target){
                return mid;
            }
                if (nums[start] <= nums[mid]) {  
                if (nums[start] <= target && target < nums[mid]) {
                    end = mid - 1;  // Target lies in the sorted left half
                } else {
                    start = mid + 1;  // Target is in the right half
                }
            } 
            else {  
                if (nums[mid] < target && target <= nums[end]) {
                    start = mid + 1;  // Target lies in the sorted right half
                } else {
                    end = mid - 1;  // Target is in the left half
                }
            }
        }
        return -1;
    }
}