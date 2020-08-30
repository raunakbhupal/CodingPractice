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
		    Arrays.sort(a);
		    int diff=Integer.MAX_VALUE;
		    for(int i=0;i<n-1;i++){
		        if(a[i+1]-a[i]<diff)
		            diff=a[i+1]-a[i];
		    }
		    System.out.println(diff);
		}
	}
}
