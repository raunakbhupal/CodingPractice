//iterative approach

void mirror(Node node)
    {
	    if(node==null)
	        return;
	    Queue<Node> q=new LinkedList<Node>();
	    q.add(node);
	    while(!q.isEmpty()){
	        Node cur=q.poll();
	        Node temp=cur.left;
	        cur.left=cur.right;
	        cur.right=temp;
	        if(cur.left!=null)
	            q.add(cur.left);
	        if(cur.right!=null)
	            q.add(cur.right);
	    }
    }
    
//recursive approach

Node mirror(Node node) 
    { 
        if (node == null) 
            return node; 
  
        /* do the subtrees */
        Node left = mirror(node.left); 
        Node right = mirror(node.right); 
  
        /* swap the left and right pointers */
        node.left = right; 
        node.right = left; 
  
        return node; 
    } 
