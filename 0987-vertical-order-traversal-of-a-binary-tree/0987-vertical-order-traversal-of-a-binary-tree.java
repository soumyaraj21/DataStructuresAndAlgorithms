/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map
                = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.offer(new Tuple(root, 0, 0));
        while(!q.isEmpty()) {
            Tuple temp = q.poll();
            TreeNode node = temp.node;
            int x = temp.x;
            int y = temp.y;
            map.putIfAbsent(x, new TreeMap<>());
            map.get(x).putIfAbsent(y,
                    new PriorityQueue<>());
            map.get(x).get(y).offer(node.val);
            if(node.left != null) {
                q.offer(new Tuple(
                        node.left,
                        x - 1,
                        y + 1));
            }
            if(node.right != null) {
                q.offer(new Tuple(node.right,x + 1,y + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer,
            PriorityQueue<Integer>> ys: map.values()) {
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> nodes
                : ys.values()) {
                while(!nodes.isEmpty()) {
                    col.add(nodes.poll());
                }
            }
            ans.add(col);
        }
        return ans;
    }
}
class Tuple {
    TreeNode node;
    int x;
    int y;
    Tuple(TreeNode node,int x, int y) {
        this.node = node;
        this.x = x;
        this.y = y;
    }
}