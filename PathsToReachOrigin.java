/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    static int count=0;
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    int n=sc.nextInt();
		    int m=sc.nextInt();
		    count=0;
		    steps(n,m);
		    System.out.println(count);
		}
	}
	static void steps(int n,int m){
	    if(n==0&&m==0)
	    {
	        count++;
	        return;
	    }
	    else if(n<0||m<0)
	        return;
	   steps(n-1,m);
	   steps(n,m-1);
	   }
}
