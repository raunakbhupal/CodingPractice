// Java Program to count palindrome substring 
// in a string 
public class PalindromeSubstring { 
	
	// Method which return count palindrome substring 
	static int countPS(String str){ 
		String temp = ""; 
		StringBuffer stf; 
		int count = 0; 
		// Iterate the loop twice 
		for (int i = 0; i < str.length(); i++) { 
			for (int j = i + 1; j <= str.length(); j++) { 
				// Get each substring 
				temp = str.substring(i, j); 
				
				// If length is greater than or equal to two 
				// Check for palindrome	 
				if (temp.length() >= 2) { 
					// Use StringBuffer class to reverse the string 
					stf = new StringBuffer(temp); 
					stf.reverse(); 
					// Compare substring wih reverse of substring 
					if (stf.toString().compareTo(temp) == 0) 
						count++; 
				} 
			} 
		} 
		// return the count 
		return count; 
	} 
	
	// Driver Code 
	public static void main(String args[]) throws Exception { 
		// Declare and initialize the string 
		String str = "abbaeae"; 
		// Call the method 
		System.out.println(countPS(str)); 
	} 
} // This code is contributes by hungundji 
