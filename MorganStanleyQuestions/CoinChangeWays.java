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
		    int cents=sc.nextInt();
		    countWays(a,n,cents);
		}
	}
	static void countWays(int a[],int n,int cents){
	    int table[]=new int[cents+1];
	    Arrays.fill(table,0);
	    table[0]=1; 
	    for(int i=0;i<n;i++)
	        for(int j=a[i];j<=cents;j++)
	            table[j]+=table[j-a[i]];
	    System.out.println(table[cents]);
	}
}
