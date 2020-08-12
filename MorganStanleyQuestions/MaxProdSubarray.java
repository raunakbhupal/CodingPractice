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
		    maxProduct(a,n);
		}
	}
	static void maxProduct(int a[],int n){
	    int max_end=1,min_end=1,max_far=Integer.MIN_VALUE,flag=0;
	    for(int i=0;i<n;i++){
	        if(a[i]>0){
	            max_end=max_end*a[i];
	            min_end=Math.min(min_end*a[i],1);
	            flag=1;
	        }
	        else if(a[i]==0){
	            max_end=1;
	            min_end=1;
	        }
	        else{
	            int temp=max_end;
	            max_end=Math.max(min_end*a[i],1);
	            min_end=temp*a[i];
	        }
	        if(max_far<max_end)
	            max_far=max_end;
	    }
	    if(flag==0&&max_far==Integer.MIN_VALUE)
	        System.out.println("0");
	    else
	        System.out.println(max_far%1000000007);
	}
}
