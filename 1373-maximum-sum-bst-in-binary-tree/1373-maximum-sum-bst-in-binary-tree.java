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

    class NodeValue {

        int minNode;
        int maxNode;
        int sum;

        NodeValue(int minNode, int maxNode, int sum) {
            this.minNode = minNode;
            this.maxNode = maxNode;
            this.sum = sum;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {

        helper(root);

        return maxSum;
    }

    private NodeValue helper(TreeNode node) {

        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }

        NodeValue left = helper(node.left);
        NodeValue right = helper(node.right);

        if (left.maxNode < node.val && node.val < right.minNode) {

            int currentSum = left.sum + right.sum + node.val;

            maxSum = Math.max(maxSum, currentSum);

            return new NodeValue(

                    Math.min(node.val, left.minNode),

                    Math.max(node.val, right.maxNode),

                    currentSum);
        }

        return new NodeValue(

                Integer.MIN_VALUE,

                Integer.MAX_VALUE,

                0);
    }
}