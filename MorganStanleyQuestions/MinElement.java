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
		    System.out.println(findMin(a,0,n-1));
		}
	}
	static int findMin(int a[],int l,int h){
	    while(l<h){
	        int mid=l+h/2;
	        if(a[mid]==a[h])
	            h--;
	        else if(a[mid]>a[h])
	            l=mid+1;
	        else
	            h=mid;
	    }
	    return a[h];
	}
}
