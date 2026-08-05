class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
    List<List<Integer>> adjlist=new ArrayList<>();
    for(int i=0;i<n;i++){
        adjlist.add(new ArrayList<>());
    } 
    for(int invocation[]:invocations){
        adjlist.get(invocation[0]).add(invocation[1]);
    }  
    boolean[] suspicious=new boolean[n];
    dfs(k, adjlist, suspicious);
    for(int invocation[]:invocations){
        if(!suspicious[invocation[0]] && suspicious[invocation[1]]){
            List<Integer> answer=new ArrayList<>();
            for(int i=0;i<n;i++){
                answer.add(i);
            }
            return answer;
        }
    }
List<Integer> answer = new ArrayList<>();
for(int i=0;i<n;i++) {
    if (!suspicious[i]) {
        answer.add(i);
    }
}
return answer;
}
public void dfs(int node, List<List<Integer>> adjlist, boolean[] suspicious) {
 suspicious[node]=true;
    for (int neighbor:adjlist.get(node)) {
        if (!suspicious[neighbor]){
            dfs(neighbor,adjlist,suspicious);
        }
    }
}
}