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
		    int m=sc.nextInt();
		    String x=sc.next();
		    String y=sc.next();
		    System.out.println(length(x,y,n,m));
		}
	}
	static int length(String x,String y,int n,int m){
	    int l[][]=new int[n+1][m+1];
	    int result=0;
	    for(int i=0;i<=n;i++){
	        for(int j=0;j<=m;j++){
	            if(i==0||j==0)
	                l[i][j]=0;
	            else if(x.charAt(i-1)==y.charAt(j-1)){
	                l[i][j]=l[i-1][j-1]+1;
	                result=Math.max(result,l[i][j]);
	            }
	            else
	                l[i][j]=0;
	        }
	    }
	    return result;
	}
}
