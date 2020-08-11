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
		    maxSumSubsequence(a,n);
		}
	}
	static void maxSumSubsequence(int a[],int n){
	    int ms[]=new int[n];
	    for(int i=0;i<n;i++)
	        ms[i]=a[i];
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(a[i]>a[j]&&ms[i]<ms[j]+a[i])
	                ms[i]=ms[j]+a[i];
	        }
	    }
	    int max=Integer.MIN_VALUE;
	    for(int i=0;i<n;i++){
	        if(max<ms[i])
	            max=ms[i];
	    }
	    System.out.println(max);
	}
}
