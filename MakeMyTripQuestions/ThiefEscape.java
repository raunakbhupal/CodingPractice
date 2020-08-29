// Java program to find the number of 
// jumps required 
public class GFG { 
	
	/* function to calculate jumps required 
		to cross walls */
	static int jumpcount(int x, int y, int n, 
								int height[]) 
	{ 
		int jumps = 0; 
	
		for (int i = 0; i < n; i++) { 
			if (height[i] <= x) { 
				jumps++; 
				continue; 
			} 
	
			/* If height of wall is greater than 
			up move */
			int h = height[i]; 
			while (h > x) 
			{ 
				jumps++; 
				h = h - (x - y); 
			} 
			jumps++; 
		} 
		return jumps; 
	} 
	
	/*driver function*/
	public static void main(String args[]) 
	{ 
		int x = 10, y = 1; 
		int height[] = { 11, 10, 10, 9 }; 
		int n = height.length; 
		System.out.println(jumpcount(x, y, n, height)); 
	} 
} 
