class Solution {
    public int[][] merge(int[][] intervals) {

        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        List<int[]> ans = new ArrayList();
        int strIdx=start[0], endIdx=end[0];

        for(int i=1; i<intervals.length; i++){

            if(start[i] <= endIdx){
                endIdx = end[i];
            }
            else{
                ans.add(new int[]{strIdx, endIdx});
                strIdx = start[i];
                endIdx = end[i];
            }
        }

        ans.add(new int[]{strIdx, endIdx});
        
        return ans.toArray(new int[0][]);
    }

}