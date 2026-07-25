class Solution {
    int preIdx = 0;                          // walks through preorder
    Map<Integer, Integer> inorderIdx = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inorderIdx.put(inorder[i], i);   // value → its index in inorder
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;       // empty range → no node

        int rootVal = preorder[preIdx++];    // next preorder value is the root
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIdx.get(rootVal);   // where root sits in inorder

        root.left  = build(preorder, left, mid - 1);   // inorder left part
        root.right = build(preorder, mid + 1, right);  // inorder right part

        return root;
    }
}
