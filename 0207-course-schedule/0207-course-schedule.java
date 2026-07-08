
class Solution {
    public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[]visited,boolean[] pathVisited) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, pathVisited)) {
                    return true;
                }

            } else if (pathVisited[neighbour]) {
                return true;

            }
        }
        pathVisited[node] = false;
        return false;
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int prereq = prerequisite[1];
            adj.get(prereq).add(course);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] pathVisited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited)) {
                    return false;
                }
            }
        }
        return true;
    }
}