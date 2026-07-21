class Solution {
    private int getRightBoundary(String s, int start,int[] first,int[] last) {
        int end = last[s.charAt(start) - 'a'];
        for (int index = start; index <= end; index++) {
            int character = s.charAt(index) - 'a';
            if (first[character] < start) {
                return -1;
            }
            end = Math.max(end, last[character]);
        }
        return end;
    }
    public List<String> maxNumOfSubstrings(String s) {
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int index = 0; index < s.length(); index++) {
            int character = s.charAt(index) - 'a';
            if (first[character] == -1) {
                first[character] = index;
            }
            last[character] = index;
        }
        List<String> answer = new ArrayList<>();
        int previousEnd = -1;
        for (int index = 0; index < s.length(); index++) {
            int character = s.charAt(index) - 'a';
            if (index != first[character]) {
                continue;
            }
            int currentEnd = getRightBoundary(s, index, first,last);
            if (currentEnd == -1) {
                continue;
            }
            if (index > previousEnd) {
                answer.add(s.substring(index,currentEnd + 1));
            }
            else {
                answer.remove(answer.size() - 1);
                answer.add(s.substring(index,currentEnd + 1));
            }
            previousEnd = currentEnd;
        }
        return answer;
    }
}
         