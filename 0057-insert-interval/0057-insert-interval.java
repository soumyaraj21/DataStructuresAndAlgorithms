class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
         List<int[]> answer = new ArrayList<>();
         int curr=0;
         while(curr<intervals.length && intervals[curr][1]<newInterval[0]){
            answer.add(intervals[curr]);
            curr++;
         }
         while(curr<intervals.length &&  intervals[curr][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[curr][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[curr][1]);
            curr++;
         }
        answer.add(newInterval);
        while(curr < intervals.length) {
            answer.add(intervals[curr]);
            curr++;
        }
        return answer.toArray(new int[answer.size()][]);
    }
}