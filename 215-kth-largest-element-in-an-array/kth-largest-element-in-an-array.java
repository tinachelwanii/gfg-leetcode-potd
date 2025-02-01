public class Solution {
    public int findKthLargest(int[] nums, int k) {
    int size=nums.length;
    PriorityQueue<Integer> minH = new PriorityQueue<>();
    for(int i=0;i<size;i++){
        minH.add(nums[i]);
        if(minH.size()>k){
            minH.poll();
        }
    }
    return minH.peek();
    }
}