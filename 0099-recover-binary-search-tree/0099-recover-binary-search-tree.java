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
    TreeNode first = null;
    TreeNode second = null;
    TreeNode previous = null;
 public void recoverTree(TreeNode root) {
        inorder(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    private void inorder(TreeNode node) {
        if (node == null)
          return;
        inorder(node.left);
        if (previous != null && previous.val > node.val) {
            if (first == null)
                first = previous;
            second = node;
        }
        previous = node;
        inorder(node.right);
    }
}