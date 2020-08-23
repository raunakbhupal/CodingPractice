// Java program for recursive level order traversal in spiral form 

/* A binary tree node has data, pointer to left child 
and a pointer to right child */
class Node { 
	int data; 
	Node left, right; 

	public Node(int d) 
	{ 
		data = d; 
		left = right = null; 
	} 
} 

class BinaryTree { 
	Node root; 

	// Function to print the spiral traversal of tree 
	void printSpiral(Node node) 
	{ 
		int h = height(node); 
		int i; 

		/* ltr -> left to right. If this variable is set then the 
		given label is traversed from left to right */
		boolean ltr = false; 
		for (i = 1; i <= h; i++) { 
			printGivenLevel(node, i, ltr); 

			/*Revert ltr to traverse next level in opposite order*/
			ltr = !ltr; 
		} 
	} 

	/* Compute the "height" of a tree -- the number of 
	nodes along the longest path from the root node 
	down to the farthest leaf node.*/
	int height(Node node) 
	{ 
		if (node == null) 
			return 0; 
		else { 

			/* compute the height of each subtree */
			int lheight = height(node.left); 
			int rheight = height(node.right); 

			/* use the larger one */
			if (lheight > rheight) 
				return (lheight + 1); 
			else
				return (rheight + 1); 
		} 
	} 

	/* Print nodes at a given level */
	void printGivenLevel(Node node, int level, boolean ltr) 
	{ 
		if (node == null) 
			return; 
		if (level == 1) 
			System.out.print(node.data + " "); 
		else if (level > 1) { 
			if (ltr != false) { 
				printGivenLevel(node.left, level - 1, ltr); 
				printGivenLevel(node.right, level - 1, ltr); 
			} 
			else { 
				printGivenLevel(node.right, level - 1, ltr); 
				printGivenLevel(node.left, level - 1, ltr); 
			} 
		} 
	} 
	/* Driver program to test the above functions */
	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(7); 
		tree.root.left.right = new Node(6); 
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(4); 
		System.out.println("Spiral order traversal of Binary Tree is "); 
		tree.printSpiral(tree.root); 
	} 
} 




//Iterative



// Java implementation of an O(n) approach of level order 
// traversal in spiral form 

import java.util.*; 

// A Binary Tree node 
class Node { 
	int data; 
	Node left, right; 

	public Node(int item) 
	{ 
		data = item; 
		left = right = null; 
	} 
} 

class BinaryTree { 

	static Node root; 

	void printSpiral(Node node) 
	{ 
		if (node == null) 
			return; // NULL check 

		// Create two stacks to store alternate levels 
		// For levels to be printed from right to left 
		Stack<Node> s1 = new Stack<Node>(); 
		// For levels to be printed from left to right 
		Stack<Node> s2 = new Stack<Node>(); 

		// Push first level to first stack 's1' 
		s1.push(node); 

		// Keep printing while any of the stacks has some nodes 
		while (!s1.empty() || !s2.empty()) { 
			// Print nodes of current level from s1 and push nodes of 
			// next level to s2 
			while (!s1.empty()) { 
				Node temp = s1.peek(); 
				s1.pop(); 
				System.out.print(temp.data + " "); 

				// Note that is right is pushed before left 
				if (temp.right != null) 
					s2.push(temp.right); 

				if (temp.left != null) 
					s2.push(temp.left); 
			} 

			// Print nodes of current level from s2 and push nodes of 
			// next level to s1 
			while (!s2.empty()) { 
				Node temp = s2.peek(); 
				s2.pop(); 
				System.out.print(temp.data + " "); 

				// Note that is left is pushed before right 
				if (temp.left != null) 
					s1.push(temp.left); 
				if (temp.right != null) 
					s1.push(temp.right); 
			} 
		} 
	} 

	public static void main(String[] args) 
	{ 
		BinaryTree tree = new BinaryTree(); 
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(7); 
		tree.root.left.right = new Node(6); 
		tree.root.right.left = new Node(5); 
		tree.root.right.right = new Node(4); 
		System.out.println("Spiral Order traversal of Binary Tree is "); 
		tree.printSpiral(root); 
	} 
} 
