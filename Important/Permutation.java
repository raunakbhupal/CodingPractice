import java.lang.*;
import java.io.*;
import java.util.*;

class Permutation {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
		while(tc-- >0)
    	{
    	 String str1=sc.next();
    	 char[] ch=str1.toCharArray();
    	 Arrays.sort(ch);
    	String str= String.valueOf(ch);
    	 permutation("",str);
    	 System.out.println();
    	 
	    
    	}
	}
	
	public static void permutation(String prefix, String str)
	{
	    int n=str.length();
	    if(n==0) {System.out.print(prefix+" ");
	       
	    }
	    else {
	        for(int i=0;i<n;i++)
	        {
	            permutation(prefix+str.charAt(i), str.substring(0,i)+str.substring(i+1,n));
	        }
	    }
	}
}
