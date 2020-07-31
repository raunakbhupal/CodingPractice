// Java program to find number of occurrences of 
// a subsequence of length 3 
import java.util.*; 
import java.lang.*; 

public class GfG{ 
	
	// Function to find number of occurrences of 
	// a subsequence of length three in a string 
	public static int findOccurrences(String str1, String substr1) 
	{ 
		// calculate length of string 
		int n = str1.length(); 
		
		char[] str = str1.toCharArray(); 
		char[] substr = substr1.toCharArray(); 
		
		// auxiliary array to store occurrences of 
		// first character 
		int[] preLeft = new int[n]; 

		// auxiliary array to store occurrences of 
		// third character 
		int[] preRight = new int[n]; 

		if (str[0] == substr[0]) 
			preLeft[0]++; 

		// calculate occurrences of first character 
		// upto ith index from left 
		for (int i = 1; i < n; i++) 
		{ 
			if (str[i] == substr[0])	 
				preLeft[i] = preLeft[i-1] + 1;	 
			else
				preLeft[i] = preLeft[i-1];	 
		} 

		if (str[n-1] == substr[2]) 
			preRight[n-1]++; 

		// calculate occurrences of third character 
		// upto ith index from right 
		for(int i = n-2; i >= 0; i--) 
		{ 
			if (str[i] == substr[2])	 
				preRight[i] = preRight[i+1] + 1;	 
			else	
				preRight[i] = preRight[i+1];	 
		} 

		// variable to store total number of occurrences 
		int counter = 0; 

		// loop to find the occurrences of middle element 
		for (int i = 1; i < n-1; i++) 
		{ 
			// if middle character of subsequence is found 
			// in the string 
			if (str[i] == str[1]) 
			{ 
				// multiply the total occurrences of first 
				// character before middle character with 
				// the total occurrences of third character 
				// after middle character 
				int total = preLeft[i-1] * preRight[i+1]; 
				counter += total; 
			} 
		} 

		return counter; 
	} 
	
	// Driver function 
	public static void main(String argc[]){ 
		String str = "GFGFGYSYIOIWIN"; 
		String substr = "GFG"; 
		
		System.out.println(findOccurrences(str, substr)); 
	} 
} 
