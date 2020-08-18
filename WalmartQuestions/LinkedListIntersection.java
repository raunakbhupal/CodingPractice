class Sol
{
    public static Node findIntersection(Node head1, Node head2)
    {
        HashSet<Integer> set=new HashSet<Integer>();
        Node temp=head2;
        while(temp!=null){
            set.add(temp.data);
            temp=temp.next;
        }
        Node res=null,res1=null;
        temp=head1;
        while(temp!=null){
            if(set.contains(temp.data)){
                if(res==null)
                    res=res1=new Node(temp.data);
                else{
                    res1.next=new Node(temp.data);
                    res1=res1.next;
                }
            }
            temp=temp.next;
        }
        return res;
    }
}

//Rest is driver code
