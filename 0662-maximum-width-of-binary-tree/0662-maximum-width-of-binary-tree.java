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
class Pair {
    TreeNode node;
    long index;
    Pair(TreeNode node, long index) {
        this.node = node;
        this.index = index;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            long min = q.peek().index;
            long first = 0;
            long last = 0;
            for(int i = 0; i < size; i++) {
                Pair temp = q.poll();
                TreeNode node = temp.node;
                long curr = temp.index - min;
                if(i == 0) {
                    first = curr;
                }
                if(i == size - 1) {
                    last = curr;
                }
                if(node.left != null) {
                    q.offer(new Pair(node.left,2 * curr + 1));
                }
                if(node.right != null) {
                    q.offer(new Pair(node.right, 2 * curr + 2));
                }
            }
            ans = Math.max(ans,(int)(last - first + 1));
        }
        return ans;
    }
}