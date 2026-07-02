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
    public TreeNode deleteNode(TreeNode root, int key) {
    if(root==null){
        return null;
    }
    if(root.val==key){
        return helper(root);
    }
    TreeNode current=root;
    while(current!=null){
    if(key<current.val){
        if(current.left!=null && current.left.val==key){
            current.left=helper(current.left);
            break;
        }
        current=current.left;
    }
    else{
        if(current.right!=null && current.right.val==key){
            current.right=helper(current.right);
            break;
        }
        current=current.right;
    }
    }
    return root;
    }
    private TreeNode helper(TreeNode node){
    if(node.left==null){
        return node.right;
    }
    if(node.right==null){
        return node.left;
    }
    TreeNode rightchild=node.right;
    TreeNode lastright=findlastright(node.left);
    lastright.right=rightchild;
    return node.left;
    }
     private TreeNode findlastright(TreeNode node){
        while(node.right!=null){
            node=node.right;
        }
        return node;
    }
}