// Java program to Append odd position nodes 
// in reverse at the end of even 
// positioned nodes in a Linked List 
class sol 
{ 

// Linked List Node 
static class Node 
{ 
	int data; 
	Node next; 
}; 

// A utility function to create a new node 
static Node newNode(int key) 
{ 
	Node temp = new Node(); 
	temp.data = key; 
	temp.next = null; 
	return temp; 
} 

// Rearranges given linked list such that all even 
// positioned nodes are before odd positioned 
// in a reverse 
static Node rearrangeEvenOdd(Node head) 
{ 
	// Corner case 
	if (head == null) 
		return null; 

	// Initialize first nodes of even and 
	// odd lists 
	Node odd = head; 
	Node even = head.next; 

	// Remember the first node of even list so 
	// that we can connect the even list at the 
	// end of odd list. 
	Node evenFirst = even; 

	while (true) 
	{ 

		// If there are no more nodes, then connect 
		// first node of even list to the last node 
		// of odd list 
		if (odd == null || even == null || (even.next) == null) 
		{ 
			break; 
		} 

		// Connecting odd nodes 
		odd.next = even.next; 
		odd = even.next; 

		// If there are NO more even nodes after 
		// current odd. 
		if (odd.next == null) 
		{ 
			even.next = null; 
			break; 
		} 

		// Connecting evenevenFirs nodes 
		even.next = odd.next; 
		even = odd.next; 
	} 

	// Reversal of even linked list 
	Node current = evenFirst; 
	Node prev = null; 
	Node front = null; 

	// Iterate in the complete linked list 
	while (current != null) 
	{ 
		front = current.next; 
		current.next = prev; 
		prev = current; 
		current = front; 
	} 

	evenFirst = prev; 

	// Attach the reversed even linked 
	// list to odd linked list 
	odd.next = evenFirst; 
	return head; 
} 

// A utility function to print a linked list 
static void printlist(Node node) 
{ 
	while (node != null) 
	{ 
		System.out.print( node.data + " -> "); 
		node = node.next; 
	} 
	System.out.println( "null" ); 
} 

// Driver code 
public static void main(String args[]) 
{ 
	Node head = newNode(1); 
	head.next = newNode(2); 
	head.next.next = newNode(3); 
	head.next.next.next = newNode(4); 
	head.next.next.next.next = newNode(5); 
	head.next.next.next.next.next = newNode(6); 

	head = rearrangeEvenOdd(head); 

	printlist(head); 

} 
} 
