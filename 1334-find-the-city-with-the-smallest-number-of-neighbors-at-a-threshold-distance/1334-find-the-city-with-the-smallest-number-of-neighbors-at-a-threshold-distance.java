class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
     int[][] distance=new int[n][n];
      int INF = (int) 1e9;
      for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            distance[i][j]=INF;
        }
        distance[i][i]=0;
      } 
      for(int[] edge : edges){
        int u=edge[0];
        int v=edge[1];
        int weight=edge[2];
        distance[u][v] = weight;
        distance[v][u] = weight;
      }
       for (int via = 0; via < n; via++) {
            for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                    if (distance[i][via] != INF &&
                        distance[via][j] != INF) {
                        distance[i][j] = Math.min(distance[i][j],
                                distance[i][via] + distance[via][j]);
                    }
                }
            }
        }
        int minimumReachableCities = n;
        int answerCity = -1;
        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (distance[i][j] <= distanceThreshold) {
                    reachableCities++;
    }
}
if (reachableCities <= minimumReachableCities) {
                minimumReachableCities = reachableCities;
                answerCity = i;
            }
        }
        return answerCity;
    }
}