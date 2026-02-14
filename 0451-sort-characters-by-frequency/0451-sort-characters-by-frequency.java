class Solution {
    public String frequencySort(String s) {
        int freq[] = new int[256];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }

        List<int[]> pairs = new ArrayList<>();

        for (int i = 0; i < 256; i++) {
            if (freq[i] > 0) {
                pairs.add(new int[]{i, freq[i]});
            }
        }

        Collections.sort(pairs, (a, b) -> b[1] - a[1]);

        StringBuilder result = new StringBuilder();

        for (int[] p : pairs) {
            int index = p[0];
            int count = p[1];
            char c = (char) index;

            for (int i = 0; i < count; i++) {
                result.append(c);
            }
        }

        return result.toString();
    }
}
