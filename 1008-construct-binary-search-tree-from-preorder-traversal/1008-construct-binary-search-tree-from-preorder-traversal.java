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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return build(preorder,Integer.MAX_VALUE);
    }
    private TreeNode build(int[] preorder,int bound){
        if(index==preorder.length || preorder[index] > bound){
            return null;
        }
    TreeNode node = new TreeNode(preorder[index]);
    index++;
        node.left = build(preorder, node.val);
        node.right = build(preorder, bound);
        return node;
    }
}