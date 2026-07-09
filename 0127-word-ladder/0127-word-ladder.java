class Solution {
    static class Pair {
        String word;
        int steps;
        Pair(String word, int steps) {
            this.word = word;
            this.steps = steps;
        }
    }
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(beginWord, 1));
        set.remove(beginWord);
        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            String word = current.word;
            int steps = current.steps;
            if (word.equals(endWord)) {
                return steps;
            }
            for (int i = 0; i < word.length(); i++) {
                char[] characters = word.toCharArray();
                char originalCharacter = characters[i];
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    characters[i] = ch;
                    String newWord = new String(characters);
                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        queue.offer(new Pair(newWord, steps + 1));
                    }
                }
                characters[i] = originalCharacter;
            }
        }
        return 0;
    }
}