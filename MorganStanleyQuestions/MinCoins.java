/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int v=sc.nextInt();
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    System.out.println(minCoins(a,n,v));
		}
	}
	static int minCoins(int a[],int n,int v){
	    int table[]=new int[v+1];
	    table[0]=0;
	    for(int i=1;i<=v;i++)
	        table[i]=Integer.MAX_VALUE;
	    for(int i=1;i<=v;i++){
	        for(int j=0;j<n;j++){
	            if(a[j]<=i){
	                int res=table[i-a[j]];
	                if(res!=Integer.MAX_VALUE&&res+1<table[i])
	                    table[i]=res+1;
	            }
	        }
	    }
	    if(table[v]==Integer.MAX_VALUE)
	        return -1;
	    return table[v];
	}
}
