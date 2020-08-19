/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int k=sc.nextInt();
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    for(int i=0;i<n;i++)
		        a[i]=sc.nextInt();
		    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
		    for(int i=0;i<k-1;i++){
		        pq.add(a[i]);
		        System.out.print("-1 ");
		    }
		    pq.add(a[k-1]);
		    System.out.print(pq.peek()+" ");
		    for(int i=k;i<n;i++){
		        if(pq.peek()<a[i]){
		            pq.poll();
		            pq.add(a[i]);
		        }
		        System.out.print(pq.peek()+" ");
		    }
		    System.out.println();
		}
	}
}
