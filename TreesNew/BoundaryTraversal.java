class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList();
        if(root == null)
            return result;
            
        result.add(root.val);
        leftSide(root.left, result);
        leafNode(root.left, result);
        leafNode(root.right, result);
        rightSide(root.right, result);
        
        return result;
    }
    
    private void leftSide(TreeNode node, List<Integer> result) {
        if(node == null)
            return;
        if(node.left != null) {
            result.add(node.val);
            leftSide(node.left, result);
        } else if(node.right != null) {
            result.add(node.val);
            leftSide(node.right, result);
        }
    }
    
    private void leafNode(TreeNode node, List<Integer> result) {
        if(node == null)
            return;
        leafNode(node.left, result);
        if(node.left == null && node.right == null)
            result.add(node.val);
        leafNode(node.right, result);
    }
    
    
    private void rightSide(TreeNode node, List<Integer> result) {
        if(node == null)
            return;
        if(node.right != null) {
            rightSide(node.right, result);
            result.add(node.val);
        } else if(node.left != null) {
            rightSide(node.left, result);
            result.add(node.val);
        }
    }
}
