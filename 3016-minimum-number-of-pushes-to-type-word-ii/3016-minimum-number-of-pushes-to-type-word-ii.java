class Solution {
    public int minimumPushes(String word) {
       int frequency[]=new int[26];
       for(char character:word.toCharArray()) {
            frequency[character-'a']++;
        }
    Arrays.sort(frequency);
    int pushes=1;
    int count=0;
    int answer=0;
    for(int i=25;i>=0;i--){
        if(frequency[i]==0){
            break;
        }
        answer+=frequency[i]*pushes;
        count++;
        if(count==8){
            pushes++;
            count=0;
        }
    }
    return answer;
    }
}