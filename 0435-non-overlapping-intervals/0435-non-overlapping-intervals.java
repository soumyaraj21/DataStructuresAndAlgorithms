class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
      Arrays.sort(intervals, (interval1, interval2) -> interval1[1] - interval2[1]);
        int lastEnd = intervals[0][1];
        int removeCount = 0;
        for (int currentIndex = 1; currentIndex < intervals.length; currentIndex++) {
            if (intervals[currentIndex][0] >= lastEnd) {
                lastEnd = intervals[currentIndex][1];
            } else {
                removeCount++;
            }
        }
        return removeCount;
    }
}  
