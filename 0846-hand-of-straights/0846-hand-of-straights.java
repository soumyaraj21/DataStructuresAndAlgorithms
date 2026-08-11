class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize !=0){
         return false;
        }
        TreeMap<Integer,Integer> map=new TreeMap<>();
        for(int i=0;i<hand.length;i++){
            map.put(hand[i],map.getOrDefault(hand[i],0)+1);
        }
        while(!map.isEmpty()){
            int first=map.firstKey();
            for(int i=0;i<groupSize;i++){
                int card=first+i;
                if(!map.containsKey(card)){
                    return false;
                }
            map.put(card,map.get(card)-1);
            if(map.get(card)==0){
                map.remove(card);
            }
            }
        }
        return true;
    }
}