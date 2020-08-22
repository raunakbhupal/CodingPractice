// Java Program to Count numbers on fingers 
class GFG 
{ 
static int count_num_finger(int n) 
{ 
	int r = n % 8; 
	if (r == 1) 
		return r; 
	if (r == 5) 
		return r; 
	if (r == 0 || r == 2) 
		return 2; 
	if (r == 3 || r == 7) 
		return 3; 
	if (r == 4 || r == 6) 
		return 4; 
	return n; 
} 

// Driver Code 
public static void main(String[] args) 
{ 
	int n; 
	n = 30; 
	System.out.println(count_num_finger(n)); 
} 
} 
