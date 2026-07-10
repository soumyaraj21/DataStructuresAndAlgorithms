import java.util.*;

class Solution {
public boolean dfs(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,boolean[] pathVisited,Stack<Integer> stack) {
        visited[node] = true;
        pathVisited[node] = true;
        for (int neighbour : adj.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, adj, visited, pathVisited, stack)) {
                    return true;
                }
            }
             else if (pathVisited[neighbour]) {
                return true;
            }
        }
        pathVisited[node] = false;
        stack.push(node);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (dfs(i, adj, visited, pathVisited, stack)) {
                    return new int[0];
                }
            }
        }
        int[] answer = new int[numCourses];
        int index = 0;
        while (!stack.isEmpty()) {
            answer[index] = stack.pop();
            index++;
        }
        return answer;
    }
}