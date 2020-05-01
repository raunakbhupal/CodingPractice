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
		    TreeMap<Integer,Integer> tmap=new TreeMap<>(); //I used treemap for optimization and it sorts and stores the key,value pairs
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        tmap.put(a[i],i);
		    }
		    int c=0;
		    for(int i:tmap.keySet()){
		        int j=tmap.get(i);
		        a[c]=j;
		        c++;/*package whatever //do not write package name here */

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
		    int b[]=new int[n];
		    for(int i=0;i<n;i++){
		        a[i]=sc.nextInt();
		        b[i]=a[i];
		    }
		    Arrays.sort(b);
		    for(int i=0;i<n;i++){
		        for(int j=0;j<n;j++){
		            if(b[i]==a[j]){
		                a[j]=i;
		                break;
		            }
		        }
		    }
		    for(int i=0;i<n;i++)
		        System.out.print(a[i]+" ");
            System.out.println();
		}
	}
}
		    }
		    for(int i=0;i<n;i++)
		        System.out.print(a[i]+" ");
		    System.out.println();
		}
	}
}
