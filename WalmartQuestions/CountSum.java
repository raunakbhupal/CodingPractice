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
		    int count=0;
		    for(int i=2;(i*(i+1))/2<=n;i++){
                if((n-(i*(i+1))/2)%i==0)
                    count++;
            }
		    System.out.println(count);
		}
	}
}
