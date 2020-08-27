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
		    System.out.println(maxDiff(a,n));
		}
	}
	static int maxDiff(int a[],int n){
	    if(n<=1)
	        return -1;
	    int max_diff=a[1]-a[0];
	    int min_ele=a[0];
	    for(int i=1;i<n;i++){
	        if(a[i]-min_ele>max_diff)
	            max_diff=a[i]-min_ele;
	        if(a[i]<min_ele)
	            min_ele=a[i];
	    }
	    if(max_diff<0)
	        return -1;
	    return max_diff;
	}
}
