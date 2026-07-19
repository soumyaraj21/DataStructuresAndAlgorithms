class Solution {
    static class DisjointSet {
        int[] parent;
        int[] size;
        DisjointSet(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        int findUltimateParent(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = findUltimateParent(parent[node]);
        }
        void unionBySize(int u, int v) {
            int ultimateParentU = findUltimateParent(u);
            int ultimateParentV = findUltimateParent(v);
            if (ultimateParentU == ultimateParentV) {
                return;
            }
            if (size[ultimateParentU] < size[ultimateParentV]) {
                parent[ultimateParentU] = ultimateParentV;
                size[ultimateParentV] += size[ultimateParentU];
            }
            else {
                parent[ultimateParentV] = ultimateParentU;
                size[ultimateParentU] += size[ultimateParentV];
            }
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisjointSet disjointSet = new DisjointSet(n);
        HashMap<String, Integer> emailToAccount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToAccount.containsKey(email)) {
                    emailToAccount.put(email, i);
                }
                else {
                    int previousAccount = emailToAccount.get(email);
                    disjointSet.unionBySize(i,previousAccount);
                }
            }
        }
        ArrayList<String>[] mergedEmails = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedEmails[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            String email = entry.getKey();
            int accountIndex = entry.getValue();
            int parent = disjointSet.findUltimateParent(accountIndex);
            mergedEmails[parent].add(email);
        }
        List<List<String>> answer = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mergedEmails[i].isEmpty()) {
                continue;
            }
            Collections.sort(mergedEmails[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            temp.addAll(mergedEmails[i]);
            answer.add(temp);
        }
        return answer;
    }
}