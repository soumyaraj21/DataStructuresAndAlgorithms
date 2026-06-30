class Solution {
    public int longestStrChain(String[] words) {
     Arrays.sort(words, (a, b) -> a.length() - b.length());
     HashMap<String, Integer> dp = new HashMap<>();
     int maxLen = 1;
        for (String word : words) {
            dp.put(word, 1);
        for (int i = 0; i < word.length(); i++) {
        String predecessor =word.substring(0, i) + word.substring(i + 1);
        if (dp.containsKey(predecessor)) {
            dp.put(word,Math.max(dp.get(word),dp.get(predecessor) + 1));
                }
            }
         maxLen = Math.max(maxLen, dp.get(word));
        }
        return maxLen;
}
}
