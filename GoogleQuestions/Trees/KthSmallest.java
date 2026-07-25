public int kthSmallest(TreeNode root, int k) {
    Deque<TreeNode> stack = new ArrayDeque<>();
    TreeNode curr = root;

    while (curr != null || !stack.isEmpty()) {
        while (curr != null) {          // go as far LEFT as possible
            stack.push(curr);
            curr = curr.left;
        }
        curr = stack.pop();             // visit the smallest unvisited node
        k--;                            // count it down
        if (k == 0) return curr.val;    // this is the kth → done, stop early
        curr = curr.right;              // then explore its right subtree
    }
    return -1;   // k out of range (won't happen given constraints)
}

//recursive
private int count = 0;
private int result = -1;

public int kthSmallest(TreeNode root, int k) {
    inorder(root, k);
    return result;
}

private void inorder(TreeNode node, int k) {
    if (node == null) return;
    inorder(node.left, k);              // left
    count++;                            // visit
    if (count == k) { result = node.val; return; }
    inorder(node.right, k);             // right
}
