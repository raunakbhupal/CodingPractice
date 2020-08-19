public class Tree
{
    // return true if the given tree is a BST, else return false
    boolean isBST(Node root)
        {
            return isBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        }
    boolean isBSTUtil(Node root,int min,int max){
        if(root==null)
            return true;
        if(root.data<min||root.data>max)
            return false;
        return (isBSTUtil(root.left,min,root.data-1)&&
        isBSTUtil(root.right,root.data+1,max));
    }
}
