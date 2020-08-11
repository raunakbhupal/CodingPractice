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
		    maxSum(a,n);
		}
	}
	static void maxSum(int a[],int n){
	    int max_ending=0,max_so_far=Integer.MIN_VALUE;
	    for(int i=0;i<n;i++){
	        max_ending+=a[i];
	        max_so_far=Math.max(max_so_far,max_ending);
	        if(max_ending<0)
	            max_ending=0;
	    }
	    System.out.println(max_so_far);
	}
}
