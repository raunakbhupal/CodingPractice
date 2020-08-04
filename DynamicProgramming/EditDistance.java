/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    String s1=sc.next();
		    String s2=sc.next();
		    editDistance(s1,s2,m,n);
		}
	}
	static void editDistance(String s1,String s2,int m,int n){
	    int dp[][]=new int[m+1][n+1];
	    for(int i=0;i<=m;i++){
	        for(int j=0;j<=n;j++){
	            if(i==0)
	                dp[i][j]=j;
	            else if(j==0)
	                dp[i][j]=i;
	            else if(s1.charAt(i-1)==s2.charAt(j-1))
	                dp[i][j]=dp[i-1][j-1];
	            else
	                dp[i][j]=1+min(dp[i-1][j],dp[i][j-1],dp[i-1][j-1]);
	        }
	    }
	    System.out.println(dp[m][n]);
	}
	static int min(int a,int b,int c){
	    if(a<=b&&a<=c)
	        return a;
	    else if(b<=a&&b<=c)
	        return b;
	    else
	        return c;
	}
}
