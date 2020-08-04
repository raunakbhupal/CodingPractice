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
		    countSteps(n);
		}
	}
	static void countSteps(int n){
	    int dp[]=new int[n+1];
      //Base Condition
	    if(n==0||n==1){
	        System.out.println("1");
	        return;
	    }
	    else if(n==2){
	        System.out.println("2");
	        return;
	    }
	    dp[0]=1;
	    dp[1]=1;
	    dp[2]=2;
	    for(int i=3;i<=n;i++)
	        dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
	    System.out.println(dp[n]);
	}
}
