/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
		    String s=sc.next();
		    toEven(s);
		}
	}
	static void toEven(String s){
	    char str[]=s.toCharArray();
	    int n=str.length;
	    int even=Integer.MAX_VALUE;
	    int pos=0;
	    for(int i=0;i<n-1;i++){
	        if((str[i]-'0')%2==0){
	            even=(str[i]-'0');
	            pos=i;
	        }
	        if(even<=str[n-1]-'0')
	            break;
	    }
	    if(even==Integer.MAX_VALUE){
	        System.out.println(str);
	        return;
	    }
	    char temp=str[pos];
	    str[pos]=str[n-1];
	    str[n-1]=temp;
	    System.out.println(str);
	}
}
