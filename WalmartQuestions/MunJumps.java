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
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    System.out.println(minJumps(a,n));
		}
	}
	static int minJumps(int a[],int n){
	    if(a[0]==0)
	        return -1;
	    if(n<=1)
	        return 0;
	    int maxReach=a[0];
	    int steps=a[0];
	    int jumps=1;
	    for(int i=1;i<n;i++){
	        if(i==n-1)
	            return jumps;
	        maxReach=Math.max(maxReach,i+a[i]);
	        steps--;
	        if(steps==0){
	            jumps++;
	            if(i>=maxReach)
	                return -1;
	            steps=maxReach-i;
	        }
	    }
	    return -1; 
	}
}
