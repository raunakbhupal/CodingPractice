// Java implementation of the approach 
class GfG 
{ 

// Binary tree node 
static class Node 
{ 
	Node left; 
	Node right; 
	int data; 

	Node(int data) 
	{ 
		this.data = data; 
		this.left = null; 
		this.right = null; 
	} 
} 

// Recursive Function to find height 
// of binary tree 
static int height(Node root) 
{ 
	// Base condition 
	if (root == null) 
		return 0; 

	// Compute the height of each subtree 
	int lheight = height(root.left); 
	int rheight = height(root.right); 

	// Return the maximum of two 
	return Math.max(1 + lheight, 1 + rheight); 
} 

// Function to Print Nodes from left to right 
static void leftToRight(Node root, int level) 
{ 
	if (root == null) 
		return; 

	if (level == 1) 
		System.out.print(root.data + " "); 

	else if (level > 1) 
	{ 
		leftToRight(root.left, level - 1); 
		leftToRight(root.right, level - 1); 
	} 
} 

// Function to Print Nodes from right to left 
static void rightToLeft(Node root, int level) 
{ 
	if (root == null) 
		return; 

	if (level == 1) 
		System.out.print(root.data + " "); 

	else if (level > 1) 
	{ 
		rightToLeft(root.right, level - 1); 
		rightToLeft(root.left, level - 1); 
	} 
} 

// Function to print clockwise spiral 
// traversal of a binary tree without using 2D array 
static void ClockWiseSpiral(Node root) 
{ 
	int i = 1; 
	int j = height(root); 

	// Flag to mark a change in the direction 
	// of printing nodes 
	int flag = 0; 
	while (i <= j) 
	{ 

		// If flag is zero print nodes 
		// from left to right 
		if (flag == 0) 
		{ 
			leftToRight(root, i); 

			// Set the value of flag as zero 
			// so that nodes are next time 
			// printed from right to left 
			flag = 1; 

			// Increment i 
			i++; 
		} 

		// If flag is one print nodes 
		// from right to left 
		else
		{ 
			rightToLeft(root, j); 

			// Set the value of flag as zero 
			// so that nodes are next time 
			// printed from left to right 
			flag = 0; 

			// Decrement j 
			j--; 
		} 
	} 
} 

// Driver code 
public static void main(String[] args) 
{ 
	Node root = new Node(10); 

	root.left = new Node(12); 
	root.right = new Node(13); 

	root.right.left = new Node(14); 
	root.right.right = new Node(15); 

	root.right.left.left = new Node(21); 
	root.right.left.right = new Node(22); 
	root.right.right.left = new Node(23); 
	root.right.right.right = new Node(24); 

	ClockWiseSpiral(root); 
} 
}
