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
		    String p=new String();
		    String q=new String();
		    for(int i=0;i<n;i++){
		        if(i%2==0)
		            p+=a[i];
		        else
		            q+=a[i];
		    }
		    System.out.println(Integer.parseInt(p)+Integer.parseInt(q));
		}
	}
}
