class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        for (int i = target.length() - 1; i >= 0; i--) {
            int[] temp = count.clone();
            boolean possible = true;
            for (int j = 0; j < i; j++) {
                int index = target.charAt(j) - 'a';
                if (temp[index] == 0) {
                    possible = false;
                    break;
                }
                temp[index]--;
            }
            if (!possible) {
                continue;
            }
            for (char c = (char) (target.charAt(i) + 1); c <= 'z'; c++) {
                int index = c - 'a';
                if (temp[index] > 0) {
                    temp[index]--;
                    StringBuilder ans = new StringBuilder(target.substring(0, i));
                    ans.append(c);
                    for (int j = 0; j < 26; j++) {
                        while (temp[j] > 0) {
                            ans.append((char) ('a' + j));
                            temp[j]--;
                        }
                    }
                    return ans.toString();
                }
            }
        }
        return "";
    }
}