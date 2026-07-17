class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int INF = Integer.MAX_VALUE;
        int[] distance = new int[n];
        Arrays.fill(distance, INF);
        distance[src] = 0;
        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(distance, n);
            for (int[] flight : flights) {
                int from = flight[0];
                int to = flight[1];
                int price = flight[2];
                if (distance[from] != INF &&
                    distance[from] + price < temp[to]) {
                    temp[to] = distance[from] + price;
                }
            }
            distance = temp;
        }
        return distance[dst] == INF ? -1 : distance[dst];
    }
}