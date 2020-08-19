class Tree
{
 
    // Method that returns the bottom view.
    public ArrayList <Integer> bottomView(Node root)
    {
        ArrayList<Integer> res=new ArrayList<Integer>();
        if(root==null)
            return res;
        int hd=0;
        Map<Integer,Integer> map=new TreeMap<Integer,Integer>();
        Queue<Node> q=new LinkedList<Node>();
        root.hd=0;
        q.add(root);
        while(!q.isEmpty()){
            Node temp=q.poll();
            hd=temp.hd;
            map.put(hd,temp.data);
            if(temp.left!=null){
                temp.left.hd=hd-1;
                q.add(temp.left);
            }
            if(temp.right!=null){
                temp.right.hd=hd+1;
                q.add(temp.right);
            }
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet())
            res.add(entry.getValue());
        return res;
    }
}
