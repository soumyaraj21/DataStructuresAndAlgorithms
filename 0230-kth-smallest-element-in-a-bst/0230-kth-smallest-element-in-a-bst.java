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
    int count=0;
    int ksmall=-1;
    public int kthSmallest(TreeNode root, int k) {
       inorder(root, k);
        return ksmall;
    }
        private void inorder(TreeNode node,int k){
            if(node==null){
                return;
            }
            inorder(node.left,k);
            count++;
            if(count==k){
                ksmall=node.val;
                return;
            }
            inorder(node.right,k);
    }
}