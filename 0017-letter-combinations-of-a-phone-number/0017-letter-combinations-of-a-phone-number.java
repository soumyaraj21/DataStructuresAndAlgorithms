class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if(digits.length()==0){
            return result;
        }
        String[] map = {
            "", "",
            "abc", "def", "ghi",
            "jkl", "mno", "pqrs",
            "tuv", "wxyz"
        };
        generateCombinations(0, digits, "", result, map);
        return result;
    }
     public void generateCombinations(int index,String digits,String current, List<String> result,String[] map) {
        if(index == digits.length()) {
            result.add(current);
            return;
        }
        String letters = map[digits.charAt(index) - '0'];
        for(int i = 0; i < letters.length(); i++) {
            generateCombinations(index + 1,digits,current + letters.charAt(i),result,map);
}
     }
}