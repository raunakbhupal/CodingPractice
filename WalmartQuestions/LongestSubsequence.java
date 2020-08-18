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
		    System.out.println(longest(a,n));
		}
	}
	static int longest(int a[],int n){
	    HashSet<Integer> hs=new HashSet<Integer>(n);
	    int res=0;
	    for(int i=0;i<n;i++)
	        hs.add(a[i]);
	    for(int i=0;i<n;i++){
	        if(!hs.contains(a[i]-1)){
	            int j=a[i];
	            while(hs.contains(j)){
	                j++;
	            }
	            if(res<j-a[i])
	                res=j-a[i];
	        }
	    }
	    return res;
	}
}
