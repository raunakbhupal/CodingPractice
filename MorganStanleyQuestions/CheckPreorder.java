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
		    System.out.println(checkPreorder(a,n));
		}
	}
	static int checkPreorder(int a[],int n){
	    Stack<Integer> s=new Stack<Integer>();
	    int root=Integer.MIN_VALUE;
	    for(int i=0;i<n;i++){
	        if(a[i]<root)
	            return 0;
	        while(!s.empty()&&s.peek()<a[i])
	            root=s.pop();
	        s.push(a[i]);
	    }
	    return 1;
	}
}
