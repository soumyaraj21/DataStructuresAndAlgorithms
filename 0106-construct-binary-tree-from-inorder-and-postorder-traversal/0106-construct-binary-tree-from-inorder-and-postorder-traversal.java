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
    HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    for (int i = 0; i < inorder.length; i++) {
        map.put(inorder[i], i);
        }
    return build(inorder, 0, inorder.length - 1,
                     postorder, 0, postorder.length - 1);
    }
    private TreeNode build(int[] inorder, int inStart, int inEnd,
                           int[] postorder, int postStart, int postEnd) {
     if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        int rootValue = postorder[postEnd];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = map.get(rootValue);
        int leftSize = rootIndex - inStart;
        root.left = build(inorder,inStart,rootIndex - 1,postorder,postStart,
                          postStart + leftSize - 1);
        root.right = build(inorder,rootIndex + 1,inEnd,postorder,
                           postStart + leftSize,postEnd - 1);
        return root;
    }
}