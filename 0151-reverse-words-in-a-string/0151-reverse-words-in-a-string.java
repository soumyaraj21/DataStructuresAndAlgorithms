class Solution {
    public String reverseWords(String s) {
        ArrayList<String> words = new ArrayList<>();
        String currentword = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                currentword = currentword + s.charAt(i);
            } else {
                if (currentword.length() > 0) {
                    words.add(currentword);
                    currentword = "";
                }
            }
        }
        if (currentword.length() > 0) {
            words.add(currentword);
        }
        StringBuilder result = new StringBuilder();
        for (int j = words.size() - 1; j >= 0; j--) {
            result.append(words.get(j));
            if (j != 0) {
                result.append(" ");
            }
        }
        return result.toString();
    }
}
