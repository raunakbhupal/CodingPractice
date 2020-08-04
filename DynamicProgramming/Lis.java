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
		    LIS(a,n);
		}
	}
	static void LIS(int a[],int n){
	    int lis[]=new int[n];
	    for(int i=0;i<n;i++)
	        lis[i]=1;
	    for(int i=1;i<n;i++){
	        for(int j=0;j<i;j++){
	            if(a[i]>a[j]&&lis[i]<lis[j]+1)
	                lis[i]=lis[j]+1;
	        }
	    }
	    int max=0;
	    for(int i=0;i<n;i++)
	        if(max<lis[i])
	            max=lis[i];
	    System.out.println(max);
	}
}
