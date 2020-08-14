/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static final int no_of_chars=256;
    
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    String str=sc.next();
		    System.out.println(longestLength(str));
		}
	}
	static int longestLength(String str){
	    int last[]=new int[no_of_chars];
	    Arrays.fill(last,-1);
	    int res=0;
	    int i=0;
	    for(int j=0;j<str.length();j++){
	        i=Math.max(i,last[str.charAt(j)]+1);
	        res=Math.max(res,j-i+1);
	        last[str.charAt(j)]=j;
	    }
	    return res;
	}
}
