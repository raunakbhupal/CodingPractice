public boolean isValidBST(TreeNode root) {
    return validate(root, null, null);
}

private boolean validate(TreeNode node, Integer min, Integer max) {
    if (node == null) return true;                      // empty is valid

    if (min != null && node.val <= min) return false;   // too small
    if (max != null && node.val >= max) return false;   // too big

    return validate(node.left, min, node.val)           // left: max becomes node.val
        && validate(node.right, node.val, max);         // right: min becomes node.val
}

//inorder

private Integer prev = null;

public boolean isValidBST(TreeNode root) {
    if (root == null) return true;

    if (!isValidBST(root.left)) return false;           // left subtree

    if (prev != null && root.val <= prev) return false; // check against previous
    prev = root.val;                                     // then update

    return isValidBST(root.right);                       // right subtree
}
