class Level_Order_Traverse
{
    static void levelOrder(Node node) 
    {
        if(node==null)
            return;
        Queue<Node> q=new LinkedList<Node>();
        q.add(node);
        while(true){
            int count=q.size();
            if(count==0)
                break;
            while(count>0){
                Node temp=q.poll();
                System.out.print(temp.data+" ");
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
                count--;
            }
            System.out.print("$"+" ");
        }
    }
}

//Rest is driver code
//If not given then solve it yourself
