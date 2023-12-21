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
    public TreeNode candidate;
    public int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        candidate = null;
        maxDepth = -1;
        helper(root, 0);
        return candidate;
    }

    public int helper(TreeNode root, int depth) {
        if (root == null) {
            return -1;
        }

        if (root.left == null && root.right == null) {
            if (depth > maxDepth) {
                candidate = root;
                maxDepth = depth;
            }
            return depth;
        }

        int leftDepth = helper(root.left, depth + 1);
        int rightDepth = helper(root.right, depth + 1);

        if (leftDepth == rightDepth && leftDepth == maxDepth) {
            candidate = root;
        }

        return Math.max(leftDepth, rightDepth);
    }
}
