/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    System.out.println(isBleak(n));
		}
	}
	static int isBleak(int n){
	    for(int x=n-ceilLog2(n);x<n;x++)
	        if(x+countSetBits(x)==n)
	            return 0;
	   return 1;
	}
	static int ceilLog2(int n){
	    int count=0;
	    n--;
	    while(n>0){
	        n=n>>1;
	        count++;
	    }
	    return count;
	}
	static int countSetBits(int x){
	    int count=0;
	    while(x>0){
	        x=x&(x-1);
	        count++;
	    }
	    return count;
	}
}
