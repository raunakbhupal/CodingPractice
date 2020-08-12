/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int m=sc.nextInt();
		    int n=sc.nextInt();
		    int a[][]=new int[m][n];
		    for(int i=0;i<m;i++){
		        for(int j=0;j<n;j++)
		            a[i][j]=sc.nextInt();
		    }
		    printArray(a,m,n);
		}
	}
	static void printArray(int a[][],int m,int n){
	    int k=0,l=0;
	    while(k<m&&l<n){
	        //print first row from remaining rows
	        for(int i=k;i<n;i++)
	            System.out.print(a[k][i]+" ");
	        k++;
	        //print last col from remaining cols
	        for(int i=k;i<m;i++)
	            System.out.print(a[i][n-1]+" ");
	        n--;
	        if(k<m){
	            //print last row from remaining rows
	            for(int i=n-1;i>=k-1;i--)
	                System.out.print(a[m-1][i]+" ");
	            m--;
	        }
	        if(l<n){
	            //print las col from remaining cols
	            for(int i=m-1;i>=k;i--)
	                System.out.print(a[i][l]+" ");
	            l++;
	        }
	    }
	    System.out.println();
	}
}
