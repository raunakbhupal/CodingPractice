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
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		   //     b[i]=s.toCharArray();
		    }
//		    char b[]=a.toCharArray();
		    findNext(a,n);
		}
	}
	static void findNext(int a[],int n){
	    int i;
	    for(i=n-1;i>0;i--){
	        if(a[i]>a[i-1])
	            break;
	    }
	    if(i==0){
	        Arrays.sort(a);
	        for(int j=0;j<n;j++)
	            System.out.print(a[j]+" ");
	        System.out.println();
	        return;
	    }
	    int val=a[i-1];
	    int min=i;
	    for(int j=i+1;j<n;j++){
	        if(a[j]>val&&a[j]<a[min])
	            min=j;
	    }
	    int temp=a[i-1];
	    a[i-1]=a[min];
	    a[min]=temp;
	    Arrays.sort(a,i,n);
	    for(int j=0;j<n;j++)
	        System.out.print(a[j]+" ");
	    System.out.println();
	}
}
