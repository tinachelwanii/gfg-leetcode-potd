class Solution {
    public int maxSubArray(int[] nums) {
        int ms = Integer.MIN_VALUE; // Maximum subarray sum
        int cs = 0; // Current subarray sum

        for (int i = 0; i < nums.length; i++) {
            cs += nums[i];
            ms = Math.max(ms, cs);
            if (cs < 0) {
                cs = 0; // Reset current sum if it goes negative
            }
        }

        return ms; // Return the maximum subarray sum
    }
}
