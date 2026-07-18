class Solution {
    static class Pair{
        int node;
        long distance;
        Pair(int node,long distance){
            this.node=node;
            this.distance=distance;
        }
    }
    public int countPaths(int n, int[][] roads) {
        int MOD=1000000007;
         ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int weight = road[2];
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }  
  long[] distance = new long[n];
        Arrays.fill(distance, Long.MAX_VALUE);
        int[] ways = new int[n];
        distance[0] = 0;
        ways[0] = 1;
        PriorityQueue<Pair> priorityQueue =new PriorityQueue<>((a, b) ->
                        Long.compare(a.distance, b.distance));
        priorityQueue.offer(new Pair(0, 0));
        while (!priorityQueue.isEmpty()) {
            Pair current = priorityQueue.poll();
            int node = current.node;
            long currentDistance = current.distance;
            for (Pair neighbour : adj.get(node)) {
                int newNode = neighbour.node;
                long edgeWeight = neighbour.distance;
                if (currentDistance + edgeWeight < distance[newNode]) {
                    distance[newNode] = currentDistance + edgeWeight;
                    ways[newNode] = ways[node];
                    priorityQueue.offer(
                            new Pair(newNode, distance[newNode]));
                }
                else if (currentDistance + edgeWeight == distance[newNode]) {
                ways[newNode] = (ways[newNode] + ways[node]) % MOD;
                }
            }
        }
        return ways[n - 1];
    }
}