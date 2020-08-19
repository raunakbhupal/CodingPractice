class Tree
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
	    int lh,rh;
	    if(root==null)
	        return true;
	    lh=height(root.left);
	    rh=height(root.right);
	    if(Math.abs(lh-rh)<=1&&isBalanced(root.left)&&isBalanced(root.right))
	        return true;
	    return false;
    }
    int height(Node root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
