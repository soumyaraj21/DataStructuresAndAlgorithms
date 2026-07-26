class Solution {
    public int[][] merge(int[][] intervals) {
       Arrays.sort(intervals, (interval1, interval2) -> interval1[0] - interval2[0]);
       List<int[]> answer=new ArrayList<>();
       answer.add(intervals[0]);
       for (int currentIndex = 1; currentIndex < intervals.length; currentIndex++) {
            int[] lastInterval = answer.get(answer.size() - 1);
            if (intervals[currentIndex][0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], intervals[currentIndex][1]);
            } 
            else {
                answer.add(intervals[currentIndex]);
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }
}