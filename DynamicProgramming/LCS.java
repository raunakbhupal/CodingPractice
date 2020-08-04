/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    String s1=sc.next();
		    String s2=sc.next();
        int m=s1.length();
		    int n=s2.length();
		    printLCS(s1,s2,m,n);
		}
	}
	static void printLCS(String s1,String s2,int m,int n){
	    int L[][]=new int[m+1][n+1];
	    for(int i=0;i<=m;i++){
	        for(int j=0;j<=n;j++){
	            if(i==0||j==0)
	                L[i][j]=0;
	            else if(s1.charAt(i-1)==s2.charAt(j-1))
	                L[i][j]=L[i-1][j-1]+1;
	            else
	                L[i][j]=Math.max(L[i-1][j],L[i][j-1]);
	        }
	    }
	    System.out.println(L[m][n]);
	}
}
