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
		    maxAmount(a,n);
		}
	}
	static void maxAmount(int a[],int n){
	    int dp[][]=new int[n][n];
	    int x,y,z;
	    for(int k=0;k<n;k++){
	        for(int i=0,j=k;j<n;i++,j++){
	            if(i+2<=j)
	                x=dp[i+2][j];
	            else
	                x=0;
	            if(i+1<=j-1)
	                y=dp[i+1][j-1];
	            else
	                y=0;
	            if(i<=j-2)
	                z=dp[i][j-2];
	            else
	                z=0;
	            dp[i][j]=Math.max(a[i]+Math.min(x,y),a[j]+Math.min(y,z));
	        }
	    }
	    System.out.println(dp[0][n-1]);
	}
}
