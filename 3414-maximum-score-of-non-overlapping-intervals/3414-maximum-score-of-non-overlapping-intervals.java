class Solution{
    class State{
        long score;
        List<Integer>list;
        State(long score,List<Integer>list){
            this.score=score;
            this.list=list;
        }
    }
    State better(State x,State y){
        if(x==null)return y;
        if(y==null)return x;
        if(x.score!=y.score)return x.score>y.score?x:y;
        for(int i=0;i<Math.min(x.list.size(),y.list.size());i++){
            if(!x.list.get(i).equals(y.list.get(i)))return x.list.get(i)<y.list.get(i)?x:y;
        }
        return x.list.size()<=y.list.size()?x:y;
    }
    public int[] maximumWeight(List<List<Integer>>intervals){
        int n=intervals.size();
        int[][]a=new int[n][4];
        for(int i=0;i<n;i++){
            a[i][0]=intervals.get(i).get(0);
            a[i][1]=intervals.get(i).get(1);
            a[i][2]=intervals.get(i).get(2);
            a[i][3]=i;
        }
        Arrays.sort(a,(x,y)->Integer.compare(x[1],y[1]));
        int[]prev=new int[n];
        for(int i=0;i<n;i++){
            int l=0,r=i-1;
            prev[i]=-1;
            while(l<=r){
                int mid=(l+r)/2;
                if(a[mid][1]<a[i][0]){
                    prev[i]=mid;
                    l=mid+1;
                }else r=mid-1;
            }
        }
        State[][]dp=new State[n+1][5];
        for(int i=0;i<=n;i++)dp[i][0]=new State(0,new ArrayList<>());
        for(int i=1;i<=n;i++){
            for(int k=1;k<=4;k++){
                State skip=dp[i-1][k];
                int p=prev[i-1]+1;
                State take=null;
                if(dp[p][k-1]!=null){
                    List<Integer>list=new ArrayList<>(dp[p][k-1].list);
                    int index=a[i-1][3];
                    int pos=Collections.binarySearch(list,index);
                    if(pos<0)pos=-pos-1;
                    list.add(pos,index);
                    take=new State(dp[p][k-1].score+(long)a[i-1][2],list);
                }
                dp[i][k]=better(skip,take);
                dp[i][k]=better(dp[i][k],dp[i][k-1]);
            }
        }
        List<Integer>ans=dp[n][4].list;
        int[]result=new int[ans.size()];
        for(int i=0;i<ans.size();i++)result[i]=ans.get(i);
        return result;
    }
}