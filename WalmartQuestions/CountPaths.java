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
		    System.out.println(countPaths(m,n));
		}
	}
	static int countPaths(int m,int n){
	    int count[][]=new int[m][n];
	    int mod=(int)Math.ceil(Math.pow(10,9))+7;
	    for(int i=0;i<m;i++)
	        count[i][0]=1;
	    for(int j=0;j<n;j++)
	        count[0][j]=1;
	    for(int i=1;i<m;i++)
	        for(int j=1;j<n;j++)
	            count[i][j]=(count[i-1][j]%mod)+(count[i][j-1]%mod);
	    return count[m-1][n-1]%mod;
	}
}
