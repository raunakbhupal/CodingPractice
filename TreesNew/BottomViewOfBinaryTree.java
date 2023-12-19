class Solution {
	// Helper Node + Hd class
    class TreeNodeWithHD {
        TreeNode node;
        int hd;
        
        public TreeNodeWithHD(TreeNode node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    
    public List<Integer> bottomView(TreeNode root) {
        if(root == null)
            return new ArrayList();
		// Used to maintain the order of nodes hd = (-Inf to + Inf) or left to right
        TreeMap<Integer, Integer> treeMap = new TreeMap(); 
        Queue<TreeNodeWithHD> q = new LinkedList();
        q.add(new TreeNodeWithHD(root, 0));
        while(q.size() > 0) {
            TreeNodeWithHD temp = q.poll();
            treeMap.put(temp.hd, temp.node.val);
            if(temp.node.left != null)
                q.add(new TreeNodeWithHD(temp.node.left, temp.hd - 1));
            if(temp.node.right != null)
                q.add(new TreeNodeWithHD(temp.node.right, temp.hd + 1));
        }
        
        return new ArrayList(treeMap.values());
    }
}
