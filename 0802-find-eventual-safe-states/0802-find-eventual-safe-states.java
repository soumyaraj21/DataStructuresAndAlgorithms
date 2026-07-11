class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int node = 0; node < n; node++) {
            for (int neighbour : graph[node]) {
                reverseGraph.get(neighbour).add(node);
                indegree[node]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        List<Integer> answer = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            answer.add(node);
            for (int neighbour : reverseGraph.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }
        Collections.sort(answer);
        return answer;
    }
}