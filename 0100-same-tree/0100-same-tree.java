/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case 1: Both are null -> Identical
        if (p == null && q == null) {
            return true;
        }
        
        // Base Case 2: One is null, other is not -> Not identical
        if (p == null || q == null) {
            return false;
        }
        
        // Base Case 3: Values are different -> Not identical
        if (p.val != q.val) {
            return false;
        }
        
        // Step 4: If current nodes match, recursively check left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}