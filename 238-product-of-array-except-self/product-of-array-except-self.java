class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] answer=new int[n];
        int prefix=1;
        for(int i=0;i<n;i++){
            answer[i]=prefix;
            prefix*=nums[i];
        }

        int suffix=1;
        for(int i=n-2;i>=0;i--){
                suffix*=nums[i+1];
                answer[i]*=suffix;
        }
            
        return answer;
    }
}