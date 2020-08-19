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
		    System.out.println(inversions(a,0,n-1));
		}
	}
	static int inversions(int a[],int l,int r){
	    int count=0;
	    if(l<r){
	        int m=(l+r)/2;
	        count+=inversions(a,l,m);
	        count+=inversions(a,m+1,r);
	        count+=merge(a,l,m,r);
	    }
	    return count;
	}
	static int merge(int a[],int l,int m,int r){
	    int left[]=Arrays.copyOfRange(a,l,m+1);
	    int right[]=Arrays.copyOfRange(a,m+1,r+1);
	    int i=0,j=0,k=l,swaps=0;
	    while(i<left.length&&j<right.length){
	        if(left[i]<=right[j]){
	            a[k++]=left[i++];
	        }
	        else{
	            a[k++]=right[j++];
	            swaps+=(m+1)-(l+i);
	        }
	    }
	    while(i<left.length)
	        a[k++]=left[i++];
	    while(j<right.length)
	        a[k++]=right[j++];
	    return swaps;
	}
}
