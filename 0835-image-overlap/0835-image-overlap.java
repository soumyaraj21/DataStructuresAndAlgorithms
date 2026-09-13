class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n=img1.length;
        int ans=0;
        HashMap<String,Integer> map=new HashMap<>();
        for(int r1=0;r1<n;r1++){
            for(int c1=0;c1<n;c1++){
                if(img1[r1][c1]==1){
                    for(int r2=0;r2<n;r2++){
                        for(int c2=0;c2<n;c2++){
                            if(img2[r2][c2]==1){
                                int dr=r2-r1;
                                int dc=c2-c1;
                                String key=dr+","+dc;
                                int count=map.getOrDefault(key,0)+1;
                                map.put(key,count);
                                ans=Math.max(ans,count);
                            }
                        }
                }
                }
            }
    }
     return ans;
    }
}